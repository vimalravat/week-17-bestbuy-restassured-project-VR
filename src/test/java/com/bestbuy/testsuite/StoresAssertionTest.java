package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StoresAssertionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1. Verify the if the total is equal to 1561
    @Test
    public void totalIs1561() {
        response.body("total", equalTo(1561));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void equalTo10() {
        response.body("limit", equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void inverGroveHeights() {
        response.body("data.name", hasItem("Inver Grove Heights"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void checkRosevilleBurnsvilleMaplewood() {
        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }

    //5. Verify the storeid=7 inside storeservices of the third store of second services
    @Test
    public void storeId7() {
        response.body("data[2].services[2].storeservices.storeId", equalTo(7));
    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void mapValuesCreatedAt() {
        response.body("data.name", hasItem("Roseville"));
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("name", "Roseville");
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/stores");
        response.prettyPrint();
        response.then().statusCode(200);
    }



    //7. Verify the state = MN of forth store
    @Test
    public void test007() {
        response.body("data[4].state", equalTo("MN"));

    }

   //8. Verify the store name = Rochester of 9th store
    @Test
    public void test008() {
        response.body("data[9].name", equalTo("Oakdale"));

    }

//9. Verify the storeId = 11 for the 6th store
@Test
public void test009() {
 response.body("data[6].id", equalTo(12)); }


//10. Verify the serviceId = 4 for the 7th store of forth service
@Test
public void test010() {

 response.body("data[7].services[4].id", equalTo(7)); }



         }


