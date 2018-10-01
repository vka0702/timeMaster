package com.sidenis.timemaster.common.rest;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

//Kirill
public class DaysController extends TimeMasterController {
    protected static JsonPath getDaysForTheMonth(Map<String, String> cookies, String year, String month) {
        return given()
                .when().cookies(cookies).get("/api/days/current_user/"+year+"/"+month+"/")
                .then().log().all().extract().jsonPath();
    }

    protected static JsonPath getOneDay(Map<String, String> cookies, String year, String month, String day) {
        return given()
                .when().cookies(cookies).log().all().get("/api/days/current_user/"+year+"/"+month+"/"+day+"/")
                .then().log().all().extract().jsonPath();
    }
}
