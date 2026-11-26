package com.restassured.tests.OAUTH;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OAuthTest {


    @Test
    public static String generateAccessToken() {
        // Code to generate access token using OAuth 2.0
        // This typically involves making a POST request to the authorization server with client credentials
        // and receiving an access token in response.

        RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/";


        String response = given().log().all()
        .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
        .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")   
        .formParam("grant_type", "client_credentials")
        .formParam("scope", "trust")
        .when().post("/oauth2/resourceOwner/token")
        .then().assertThat().statusCode(200)
        .extract().response().asString();

        JsonPath js = new JsonPath(response);
        String accessToken = js.getString("refresh_token");

        System.out.println("Access Token: " + accessToken);

        return accessToken;
    }
    
}
