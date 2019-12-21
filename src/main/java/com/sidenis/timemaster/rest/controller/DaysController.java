package com.sidenis.timemaster.rest.controller;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.sidenis.timemaster.rest.vo.Day;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

//Kirill
public class DaysController extends TimeMasterController {
    protected static Day[] getDaysForTheMonth(Map<String, String> cookies, String year, String month) {
        return given()
                .when().cookies(cookies).get("/api/days/current_user/"+year+"/"+month+"/")
                .then().log().all().extract().as(Day[].class);
    }

    protected static Day getOneDay(Map<String, String> cookies, String year, String month, String day) {
        return given()
                .when().cookies(cookies).log().all().get("/api/days/current_user/"+year+"/"+month+"/"+day+"/")
                .then().log().all().extract().as(Day.class);
    }

    protected static JsonPath postBreakTime(Map<String, String> cookies, Map body) {

        return given().contentType(ContentType.JSON)
                .header("X-CSRFToken", cookies.get("csrftoken"))
                .when().cookies(cookies)
                .body(body)
                .log().all()
                .post("/api/days/set_time/")
                .then().log().all().extract().jsonPath();
    }

    protected static JsonPath getValidateDaysForTheMonth(Map cookies, String year, String month) {
        return given()//.params("year", year, "month", month)
                .when().cookies(cookies)
                .log().all().get("/api/days/validate/"+year+"/"+month+"/")
                .then().log().all().extract().jsonPath();
    }

    public static JsonPath putDayForCurrentUser(Map cookies, Map body) {

        return given().contentType(ContentType.JSON)
                .when().header("X-CSRFToken", cookies.get("csrftoken")).cookies(cookies).body(body)
                .log().all().put("/api/days/current_user/")
                .then().log().all().extract().jsonPath();
    }

    public static JsonPath putDayForUserWithId(Map cookies, Map body, int id) {
        return given().contentType(ContentType.JSON)
                .when().header("X-CSRFToken", cookies.get("csrftoken")).cookies(cookies).body(body)
                .log().all().put("/api/days/"+id+"/")
                .then().log().all().extract().jsonPath();
    }

}
