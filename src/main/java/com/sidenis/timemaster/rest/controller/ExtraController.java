package com.sidenis.timemaster.rest.controller;

import com.jayway.restassured.http.ContentType;
import com.sidenis.timemaster.rest.vo.User;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

//Daria
public class ExtraController extends TimeMasterController {

    protected static User getWhoAmI(Map<String, String> cookies) {
        return given().when().contentType(ContentType.JSON).cookies(cookies).log().all()
                .get("/api/whoami/")
                .then().log().all().extract().as(User.class);
    }
}
