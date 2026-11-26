package com.restassured.tests.OAUTH;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetCourseDetailsTest {

    @Test
    public void getCourseDetails(){

        RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/";

        given().log().all()
        .queryParam("access_token", OAuthTest.generateAccessToken())
        .when().get("/getCourseDetails")
        .then().assertThat().statusCode(401)
        .extract().response().asString();
    }


    
}
