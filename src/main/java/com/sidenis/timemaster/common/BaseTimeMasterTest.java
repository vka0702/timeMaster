package com.sidenis.timemaster.common;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.sidenis.timemaster.rest.vo.User;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.jayway.restassured.RestAssured.given;

public class BaseTimeMasterTest extends Constants {
    static{ RestAssured.baseURI = "http://timemaster-dev3.sidenis.io/";}

    protected <T> T getExpectedJsonFromFile(String locationJson, Class<T> classOfT) throws IOException {
        String expectedData = "";
        try {
            expectedData = Resources.toString(Resources.getResource(locationJson), Charset.defaultCharset());
        }
        catch (IllegalArgumentException e){
            System.out.println("Expected file is not found");
        }
        Gson gson = new Gson();
        return gson.fromJson(expectedData, classOfT);

    }


}

