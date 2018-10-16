package com.sidenis.timemaster.rest.controller;

import com.sidenis.timemaster.common.BaseTimeMasterTest;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class TimeMasterController extends BaseTimeMasterTest {

    public static Map<String, String> login(String login, String password) {
        return given()
                .params("username", login, "password", password)
                .auth().preemptive().basic(login, password)
                .when()
                .post("api/login/")
                .then().extract().cookies();

    }

    public static String logout(Map<String, String> cookies){
        System.out.println("---------------------------------------------->LOGOUT<-----------------------------------------------------------");
        return given()
                .header("X-CSRFToken", cookies.get("csrftoken"))
                .when()
                .cookies(cookies).log().all()
                .post("api/logout/")
                .then()
                .log().all()
                .statusCode(202)
                .extract().statusLine();
    }
}
