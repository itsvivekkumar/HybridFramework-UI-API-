package api.user;

import base.ApiBaseTest;
import dataProviders.UserDataProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserPayload;

import java.util.List;

public class User extends ApiBaseTest {

    String basePath = "user";
    int id;
    String userName;

    @Test(priority = 1, dataProvider = "userClassData", dataProviderClass = UserDataProvider.class)
    public void getUserLogin(List<UserPayload> userPayloads) {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Login", "login")
                .queryParam("username", userPayloads.getFirst().getUsername())
                .queryParam("password", userPayloads.get(0).getPassword())
                .header("accept", "application/json")
                .when().get("/{Login}")
                .then().statusCode(200).extract().response();
//        System.out.println("Get response"+res.asString());
        int codeId = Integer.parseInt(res.jsonPath().getString("code"));
        System.out.println("Code id =" + codeId);

        String typeVal = res.jsonPath().getString("type");
        String msgVal = res.jsonPath().getString("message");
        Assert.assertEquals(codeId, 200);
        Assert.assertEquals(typeVal, "unknown");
//        Assert.assertEquals(msgVal,"");

        System.out.println("Get User login done ---------");
    }


    @Test(priority = 2, dataProvider = "userClassData", dataProviderClass = UserDataProvider.class)
    public void postListOfUsers(List<UserPayload> userPayloads) {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("CreateList", "createWithList")
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .body(userPayloads)
                .when().post("/{CreateList}")
                .then().statusCode(200).extract().response();
        System.out.println("Get response as string " + res.asString());
        int codeId = Integer.parseInt(res.jsonPath().getString("code"));
        System.out.println("Code =" + codeId);

        String typeVal = res.jsonPath().getString("type");
        String msgVal = res.jsonPath().getString("message");
        Assert.assertEquals(codeId, 200);
        Assert.assertEquals(typeVal, "unknown");
        Assert.assertEquals(msgVal, "ok");

        System.out.println("Post list of User done ---------");
    }


    @Test(priority = 3, dataProvider = "userClassData", dataProviderClass = UserDataProvider.class)
    public void getUserByUsername(List<UserPayload> userPayloads) {
        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Username", userPayloads.getFirst().getUsername())
                .header("accept", "application/json")
                .when().get("/{Username}")
                .then().statusCode(200).extract().response();
//        System.out.println("Get response"+res.asString());
        id = Integer.parseInt(res.jsonPath().getString("id"));
        System.out.println("Get created id =" + id);
        userName = res.jsonPath().getString("username");
        String pass = res.jsonPath().getString("password");
        System.out.println("Username =" + id + " Password =" + pass);
        String mail = res.jsonPath().getString("email");
        Assert.assertTrue(mail.contains("@example.com"));
        System.out.println("Get User by userName done ---------");
    }


    @Test(priority = 4, dataProvider = "userClassData", dataProviderClass = UserDataProvider.class)
    public void putUserByUsername(List<UserPayload> userPayloads) {
        UserPayload newUserPayload=new UserPayload();
        newUserPayload.setFirstName(userPayloads.getFirst().getFirstName());

        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Username", userPayloads.getFirst().getUsername())
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .body(newUserPayload)
                .when().get("/{Username}")
                .then().statusCode(200).extract().response();
//        System.out.println("Get response"+res.asString());
//        int codeId = Integer.parseInt(res.jsonPath().getString("code"));
//        Assert.assertEquals(codeId,200);
//        String typeVal = res.jsonPath().getString("type");
//        Assert.assertEquals(typeVal,"unknown");
        System.out.println("Update User by userName done ---------");
    }

    @Test(priority = 5, dataProvider = "userClassData", dataProviderClass = UserDataProvider.class)
    public void getUserLogout(List<UserPayload> userPayloads) {

        Response res = RestAssured.given()
                .basePath(basePath)
                .pathParam("Logout", "logout")
                .header("accept", "application/json")
                .when().get("/{Logout}")
                .then().statusCode(200).extract().response();
//        System.out.println("Get response"+res.asString());
        int codeId = Integer.parseInt(res.jsonPath().getString("code"));
        Assert.assertEquals(codeId,200);
        String typeVal = res.jsonPath().getString("type");
        Assert.assertEquals(typeVal,"unknown");
        String msgVal = res.jsonPath().getString("message");
        Assert.assertEquals(msgVal,"ok");
        System.out.println("Get User logout done ---------");
    }

}
