package com.sidenis.timemaster.common.annotation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class BaseTimeMasterTest extends Constants {
    static{ RestAssured.baseURI = "http://timemaster-dev2.sidenis.io/";}


}

