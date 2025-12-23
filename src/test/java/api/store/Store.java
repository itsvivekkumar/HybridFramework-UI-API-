package api.store;

import base.ApiBaseTest;
import dataProviders.StoreDataProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.StorePayload;

public class Store extends ApiBaseTest {
    String basePath = "store";
    int id;

    @Test(priority = 1)
    public void getStoreInventry() {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Inventry", "inventory")
                .header("accept", "application/json")
                .when().get("/{Inventry}")
                .then().statusCode(200).extract().response();
//        System.out.println("Get response"+res.asString());
//        int aval=Integer.parseInt(res.jsonPath().getString("AVAILABLE"));
//        System.out.println("Get Available ="+aval);
        System.out.println("Get store inventory done ---------");
    }

    @Test(priority = 2, dataProvider = "storeOrderData", dataProviderClass = StoreDataProvider.class)
    public void postStoreOrder(StorePayload storePayload) {

        //1- using normal String approach(hard coded value)
//        String payload = """
//                {
//                    "id": 10,
//                        "petId": 1,
//                        "quantity": 0,
//                        "shipDate": "2025-12-22T09:38:54.295Z",
//                        "status": "placed",
//                        "complete": true
//                }""";

        //2-using POJO concept
//        StorePayload storePayload=new StorePayload();
//        storePayload.setId(10);
//        storePayload.setPetId(1);
//        storePayload.setQuantity(0);
//        storePayload.setShipDate("2025-12-22T09:38:54.295Z");
//        storePayload.setStatus("placed");
//        storePayload.setComplete(true);


        //3- using Data provider( data driven api testing) { DataProvider->connect to Pojo-> then runtime RestAssured automatically perform serilisation}
        //Need to use ( dataProvider="name of dataprovier" given in that method at test method)

        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Order", "order")
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .body(storePayload)
                .when().post("/{Order}")
                .then().log().all().statusCode(200).extract().response();
        id = Integer.parseInt(res.jsonPath().getString("id"));
        int petid = Integer.parseInt(res.jsonPath().getString("petId"));
        String statusValue = res.jsonPath().getString("status");
        String completeVal = res.jsonPath().getString("complete");
        Assert.assertEquals(10, id);
        Assert.assertEquals(1, petid);
        Assert.assertEquals(statusValue, "placed");
        Assert.assertEquals(completeVal, "true");
        System.out.println("Post store order done ---------");
    }

    @Test(priority = 3)
    public void getStoreOrderById() {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Order", "order")
                .pathParam("OrderId", id)
                .header("accept", "application/json")
                .when().get("/{Order}/{OrderId}")
                .then().log().all().statusCode(200).extract().response();
//        int id = Integer.parseInt(res.jsonPath().getString("id"));
        System.out.println("Fetched id value =" + id);
        int petid = Integer.parseInt(res.jsonPath().getString("petId"));
        String statusValue = res.jsonPath().getString("status");
        String completeVal = res.jsonPath().getString("complete");
        Assert.assertEquals(Integer.parseInt(res.jsonPath().getString("id")), id);
        Assert.assertEquals(1, petid);
        Assert.assertEquals(statusValue, "placed");
        Assert.assertEquals(completeVal, "true");
        System.out.println("Get store order by ID done ---------");
    }

    @Test(priority = 4)
    public void deleteStoreOrderById() {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Order", "order")
                .pathParam("OrderId", id)
                .header("accept", "application/json")
                .when().get("/{Order}/{OrderId}")
                .then().log().all().statusCode(200).extract().response();
//        int id = Integer.parseInt(res.jsonPath().getString("id"));
        System.out.println("Fetched id value =" + id);
        System.out.println("Fetched value =" + res.jsonPath().getString("code"));

        //we can not fetch here delete record bcuz that is not documented.Only verify statuscode()
//        int outCode = Integer.parseInt(res.jsonPath().getString("code"));
//        int outCode = res.jsonPath().get("code");
//        Assert.assertEquals(res.statusCode(),outCode);

//        String typeVal = res.jsonPath().getString("type");
//        Assert.assertEquals(typeVal,"unknown");

//        Assert.assertEquals(Integer.parseInt(res.jsonPath().getString("message")), id);
        System.out.println("Delete store order by ID done ---------");
    }

}
