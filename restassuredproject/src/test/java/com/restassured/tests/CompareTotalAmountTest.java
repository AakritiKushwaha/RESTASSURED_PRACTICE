package com.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.utilities.Payloads;

import io.restassured.path.json.JsonPath;

public class CompareTotalAmountTest {

    @Test
    public void compareTotalAmount() {
        int sum = 0;

        JsonPath js = new JsonPath(Payloads.CoursePrice());
        int courseCount = js.getInt("courses.size()");

        for (int i = 0; i < courseCount; i++) {
            int amount = js.getInt("courses[" + i + "].price")
                    * js.getInt("courses[" + i + "].copies");
            sum += amount;
        }

        Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), sum);
    }
}
