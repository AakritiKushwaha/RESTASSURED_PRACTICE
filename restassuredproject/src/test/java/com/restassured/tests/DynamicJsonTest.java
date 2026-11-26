package com.restassured.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.restassured.utilities.Payloads;

import io.restassured.RestAssured;

public class DynamicJsonTest {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";

        given().log().all()
                .header("Content-Type", "application/json")
                .body(Payloads.AddBook("Learn Appium Automation with Java1", "22222", "John foe1"))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200);
    }
}
