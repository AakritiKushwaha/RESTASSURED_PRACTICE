package com.restassured.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.utilities.Payloads;

import io.restassured.RestAssured;

public class DynamicJsonTest {


    @DataProvider (name = "BooksData")
    public Object[][] getBooksData() {
        return new Object[][] {
            {"Learn Appium Automation with Java1", "22222", "John foe1"},
            {"Learn Appium Automation with Python", "33333", "John foe2"},
            {"Learn Appium Automation with Selenium", "44444", "John foe3"}
            
        };
    }

    @Test(dataProvider = "BooksData")
    public void addBook(String name, String isbn, String author) {
        RestAssured.baseURI = "http://216.10.245.166";

        given().log().all()
                .header("Content-Type", "application/json")
                .body(Payloads.AddBook(name, isbn, author))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200);
    }

    
}
