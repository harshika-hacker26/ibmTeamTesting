package com.ibm.apiTesting;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APITest {

    @BeforeClass
    public void setup() {
        baseURI = "https://automationexercise.com/api";
    }

    @Test
    public void getAllProductsList() {
        given()
        .when()
            .get("/productsList")
        .then()
            .statusCode(200)
            .body("products", notNullValue());
    }

    @Test
    public void postToProductsList() {
        given()
        .when()
            .post("/productsList")
        .then()
            .statusCode(200);
    }

    @Test
    public void getAllBrandsList() {
        given()
        .when()
            .get("/brandsList")
        .then()
            .statusCode(200)
            .body("brands", notNullValue());
    }

    @Test
    public void putToBrandsList() {
        given()
        .when()
            .put("/brandsList")
        .then()
            .statusCode(200);
    }

    @Test
    public void searchProduct() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("search_product", "top")
        .when()
            .post("/searchProduct")
        .then()
            .statusCode(200);
    }

    @Test
    public void searchProductWithoutParam() {
        given()
        .when()
            .post("/searchProduct")
        .then()
            .statusCode(200);
    }

    @Test
    public void verifyLoginValid() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "test@test.com")
            .formParam("password", "123456")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void verifyLoginWithoutEmail() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("password", "123456")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(200);
    }

    @Test
    public void deleteVerifyLogin() {
        given()
        .when()
            .delete("/verifyLogin")
        .then()
            .statusCode(200);
    }

    @Test
    public void verifyLoginInvalid() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "wrong@test.com")
            .formParam("password", "wrong")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(200);
    }

    @Test
    public void createUserAccount() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Rishi")
            .formParam("email", "rishi_api_" + System.currentTimeMillis() + "@test.com")
            .formParam("password", "123456")
        .when()
            .post("/createAccount")
        .then()
            .statusCode(200);
    }

    @Test
    public void deleteUserAccount() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "test@test.com")
            .formParam("password", "123456")
        .when()
            .delete("/deleteAccount")
        .then()
            .statusCode(200);
    }

    @Test
    public void updateUserAccount() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Updated Name")
        .when()
            .put("/updateAccount")
        .then()
            .statusCode(200);
    }

    @Test
    public void getUserByEmail() {
        given()
            .queryParam("email", "test@test.com")
        .when()
            .get("/getUserDetailByEmail")
        .then()
            .statusCode(200);
    }
}
