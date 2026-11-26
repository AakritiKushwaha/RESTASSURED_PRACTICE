package com.restassured.utilities;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public static String rawToJson(String Response, String key){

        JsonPath js = new JsonPath(Response);
        String value = js.getString(key);
        return value;

    }
    
}