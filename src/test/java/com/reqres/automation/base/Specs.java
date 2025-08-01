package com.reqres.automation.base;

import com.reqres.automation.data.Route;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specs {
    public static RequestSpecification getRequestSpecs() {
        return given()
                .baseUri(Route.BASE_URL)
                .contentType(ContentType.JSON)
                .header(Route.API_KEY_HEADER, Route.API_KEY_VALUE);
    }
}
