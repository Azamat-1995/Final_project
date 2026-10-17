package org.example.api;

import io.restassured.RestAssured;
import org.example.config.Config;
import org.example.model.TestUser;

import static io.restassured.RestAssured.given;


public class UserApiClient {

    public static void registerUser(TestUser user) {
        RestAssured.baseURI = Config.BASE_URL;

        given()
                .contentType("application/json")
                .body(String.format(
                        "{ \"email\": \"%s\", \"password\": \"%s\", \"submitPassword\": \"%s\" }",
                        user.getEmail(), user.getPassword(), user.getPassword()
                ))
                .when()
                .post("/api/signup")
                .then()
                .statusCode(201);
    }
}
