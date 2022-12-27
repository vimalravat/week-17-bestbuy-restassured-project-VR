package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class StoresExtractionTest extends TestBase {
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
//  1. Extract the limit
    @Test
public void test001() {
    int limit =response.extract().path("limit");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " + limit);
    System.out.println("------------------End of Test---------------------------");

}

//2. Extract the total
@Test
public void test002() {
    int total =response.extract().path("total");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of total is : " + total);
    System.out.println("------------------End of Test---------------------------");

}

//3. Extract the name of 5th store
@Test
public void test003() {
    String storeName =response.extract().path("data[5].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of the 5th store is : " + storeName);
    System.out.println("------------------End of Test---------------------------");

}


//4. Extract the names of all the store
@Test
public void test004() {

    List<Integer> allStoreName = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of the All store is : " + allStoreName);
    System.out.println("------------------End of Test---------------------------");

}

//5. Extract the storeId of all the store
@Test
public void test005() {

    List<Integer> allStoreID = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of the All store is : " + allStoreID);
    System.out.println("------------------End of Test---------------------------");
}

//6. Print the size of the data list
@Test
public void test006() {
List<Integer> sizeOfListData = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of the All store is : " + sizeOfListData.size());
    System.out.println("------------------End of Test---------------------------");}

//7. Get all the value of the store where store name = St Cloud
@Test
public void test007() {
    List<Integer> storeName = response.extract().path("data.findAll{it.name == 'St Cloud'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of St Cloud is : " + storeName);
    System.out.println("------------------End of Test---------------------------");
}

//8. Get the address of the store where store name = Rochester
@Test
public void test008() {
    List<Integer> storeAddress = response.extract().path("data.findAll{it.name == 'Rochester'}.address");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of St Cloud is : " + storeAddress);
    System.out.println("------------------End of Test---------------------------");
}


//9. Get all the services of 8th store
@Test
public void test009() {
    List<Integer> allServices = response.extract().path("data[8].services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of the All store is : " + allServices);
    System.out.println("------------------End of Test---------------------------");
}

//10. Get store services of the store where service name = Windows Store
@Test
public void test010() {
    List<String> storeServicesWindowsStore = response.extract().path("data.findAll{it.name == 'Windows Store'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The store services is : " + storeServicesWindowsStore);
    System.out.println("------------------End of Test---------------------------");
}

//11. Get all the storeId of all the store
@Test
public void test011() {
    List<Integer> allStoreId = response.extract().path("data.services.storeservices.storeId");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All storeId  is : " + allStoreId);
    System.out.println("------------------End of Test---------------------------");
}


//12. Get id of all the store
@Test
public void test012() {
    List<Integer> allDataId = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All store ID is : " + allDataId);
    System.out.println("------------------End of Test---------------------------");
}

//13. Find the store names Where state = ND
@Test
public void test013() {
    List<Integer> storeNameND = response.extract().path("data.findAll{it.state == 'ND'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The store name is : " + storeNameND);
    System.out.println("------------------End of Test---------------------------");
}
//14. Find the Total number of services for the store where store name = Rochester
@Test
public void test014() {
    List<Integer> totalNumberOfServices = response.extract().path("data.findAll{it.name == 'Rochester'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The total number of services is : " + totalNumberOfServices.size());
    System.out.println("------------------End of Test---------------------------");
}

//15. Find the createdAt for all services whose name = “ Windows Store”
@Test
public void test015() {
    List<String> createAtAllServices = response.extract().path("data.findAll{it.name == 'Windows Store'}.services.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt for all of services is : " + createAtAllServices);
    System.out.println("------------------End of Test---------------------------");
}
//16. Find the name of all services Where store name = “Fargo”
@Test
public void test016() {
    List<Integer> nameOfAllServices = response.extract().path("data.findAll{it.name == 'Fargo'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The total number of services is : " + nameOfAllServices);
    System.out.println("------------------End of Test---------------------------");
}

//17. Find the zip of all the store
@Test
public void test017() {
    List<Integer> allDataZip = response.extract().path("data.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All store zip is : " + allDataZip);
    System.out.println("------------------End of Test---------------------------");
}

//18. Find the zip of store name = Roseville
@Test
public void test018() {
    List<Integer> zipOfRosevilleStore = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Roseville store zip is : " + zipOfRosevilleStore);
    System.out.println("------------------End of Test---------------------------");
}

//19. Find the store services details of the service name = Magnolia Home Theater
@Test
public void test019() {
    List<Integer> storeServicesDetails = response.extract().path("data.findAll{it.services.name == 'Magnolia Home Theater'}.storeservices");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store services details of Magnolia Home Theater  is : " + storeServicesDetails);
    System.out.println("------------------End of Test---------------------------");
}

//20. Find the lat of all the stores
@Test
public void test020() {
    List<Integer> allDataIat = response.extract().path("data.Iat");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All store Iat is : " + allDataIat);
    System.out.println("------------------End of Test---------------------------");
}

}
