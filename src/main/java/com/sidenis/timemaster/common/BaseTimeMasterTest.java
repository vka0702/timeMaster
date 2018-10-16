package com.sidenis.timemaster.common;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.given;

public class BaseTimeMasterTest extends Constants {
    static{ RestAssured.baseURI = "http://timemaster-dev3.sidenis.io/";}


}

