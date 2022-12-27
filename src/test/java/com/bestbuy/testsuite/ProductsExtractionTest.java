package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }


    //    21. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }
//22. Extract the total

    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }


    //23. Extract the name of 5th product
    @Test
    public void test003() {
        String name = response.extract().path("data[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }


//24. Extract the names of all the products

    @Test
    public void test004() {
        List<String> name = response.extract().path("data.name");
        name.size();
        System.out.println("total name : " + name.size());

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

//25. Extract the productId of all the products


    @Test
    public void test005() {
        List<Integer> ids = response.extract().path("data.id");
        ids.size();
        System.out.println("total name : " + ids.size());

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products ids: " + ids);
        System.out.println("------------------End of Test---------------------------");
    }


//26. Print the size of the data list

    @Test
    public void test006() {
        List<Integer> ids = response.extract().path("data");
        ids.size();
        System.out.println("total size of data list : " + ids.size());

    }


//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4- Pack)

    @Test
    public void test007() {
        List<HashMap<String, ?>> des = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product description : " + des);
        System.out.println("------------------End of Test---------------------------");

    }


//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2- Pack)

    @Test
    public void test008() {
        List<HashMap<String, ?>> model = response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of  model : " + model);
        System.out.println("------------------End of Test---------------------------");

    }


//29. Get all the categories of 8th products

    @Test
    public void test009() {
        List<HashMap<String, ?>> categories = response.extract().path("data[8].categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all categories: " + categories);
        System.out.println("------------------End of Test---------------------------");

    }


//30. Get categories of the store where product id = 150115

    @Test
    public void test010() {
        List<Integer> listOfIds = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");

    }
//31. Get all the descriptions of all the products

    @Test
    public void test011() {
        List<String> data = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of data are : " + data);
        System.out.println("------------------End of Test---------------------------");

    }


    //32. Get id of all the all categories of all the products
    @Test
    public void test012() {
        List<Integer> data = response.extract().path("data.categories.id");
        data.size();
        System.out.println("size:" + data.size());
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all categories of products: " + data);
        System.out.println("------------------End of Test---------------------------");

    }


//13. Find the product names Where type = HardGood

    @Test
    public void test013() {
        List<String> productName = response.extract().path("data.findAll{it.type=='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All productName: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }


//34. Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)

    @Test
    public void test014() {
        List<String> noOfCategories = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All noOfCategories: " + noOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }


//35. Find the createdAt for all products whose price < 5.49

    @Test
    public void test015() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }


    // 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-  Pack)”
    // Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test016() {
        List<String> categories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All categories: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }


    //37. Find the manufacturer of all the products
    @Test
    public void test017() {
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All manufacturer: " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }


//38. Find the imge of products whose manufacturer is = Energizer

    @Test
    public void test018() {
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.manufacturer =='Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All image: " + image);
        System.out.println("------------------End of Test---------------------------");
    }


//39. Find the createdAt for all categories products whose price > 5.99

    @Test
    public void test019() {
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
//40. Find the uri of all the product


    @Test
    public void test020() {
        List<HashMap<String, ?>> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All url: " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}
