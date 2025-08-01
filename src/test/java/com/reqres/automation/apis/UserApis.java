package com.reqres.automation.apis;

import com.reqres.automation.base.Specs;
import com.reqres.automation.models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApis {

    public static Response createUser(User user) {
        return given()
                .spec(Specs.getRequestSpecs())
                .body(user)
        .when()
                .post("/users")
        .then()
                .extract().response();
    }

    public static Response updateUser(User user, String userID) {
        return given()
                .spec(Specs.getRequestSpecs())
                .body(user)
                .when()
                .put("/users/" + userID)
                .then()
                .extract().response();
    }

    public static Response getUser(String userID) {
        return given()
                .spec(Specs.getRequestSpecs())
                .when()
                .get("/users/" + userID)
                .then()
                .extract().response();
    }

    public static Response deleteUser(String userID) {
        return given()
                .spec(Specs.getRequestSpecs())
                .when()
                .delete("/users/" + userID)
                .then()
                .extract().response();
    }
    }
