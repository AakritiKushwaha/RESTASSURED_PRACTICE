package com.restassured.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.restassured.utilities.Payloads;
import com.restassured.utilities.ReusableMethods;

import io.restassured.RestAssured;

public class GoogleAppAPI {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        System.out.print("\nAdding new place to the API");

        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payloads.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.print(response);

        String placeID = ReusableMethods.rawToJson(response, "place_id");
        System.out.print("Newly added PlaceID is: " + placeID);

        System.out.print("\nRetrieving the address of the newly added place using GET API");

        String getResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .header("Content-Type", "application/json")
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        String address = ReusableMethods.rawToJson(getResponse, "address");
        System.out.print("Retrieved Address is: " + address);

        System.out.print("\nUpdating the address of the newly added place using PUT API");

        given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .header("Content-Type", "application/json")
                .body(Payloads.UpdatePlace(placeID, "70 Summer walk, USA"))
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        System.out.print("\nRetrieving the address of the newly added place using GET API");

        String getResponse2 = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .header("Content-Type", "application/json")
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        String address2 = ReusableMethods.rawToJson(getResponse2, "address");
        System.out.print("Retrieved Address is: " + address2);
    }
}
