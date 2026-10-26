package org.example.api;

import io.restassured.RestAssured;
import org.example.config.Config;
import org.example.model.SignupRequest;
import org.example.model.TestUser;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    public static void registerUser(TestUser user) {
        RestAssured.baseURI = Config.BASE_URL;

        SignupRequest request = new SignupRequest(user.getEmail(), user.getPassword());

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/api/signup")
                .then()
                .statusCode(201);
    }
}