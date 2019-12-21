package rest;

import com.sidenis.timemaster.rest.controller.DaysController;
import com.sidenis.timemaster.rest.vo.Day;
import net.minidev.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DaysControllerTests extends DaysController {

//    private String getFile(String filename) {
//        String expectedDay = "";
//        ClassLoader classLoader = getClass().getClassLoader();
//        try {
//            expectedDay = IOUtils
//        }
//    }

    private static  Map<String, String> cookies;
    @BeforeClass
    public static void log() {
        cookies = login(userName_AA, userPassword_AA);
    }
    @Test
    public void testGetDaysForTheMonth() throws IOException {
        String year = "2018";
        String month = "09";
        Day[] actualDays = getDaysForTheMonth(cookies,year,month);
        Day[] expectedDays = getExpectedJsonFromFile("testGetDaysForTheMonth", Day[].class);
        assertEquals(expectedDays, actualDays);
    }

    @Test
    public void testGetOneDay() throws IOException {
        String year = "2018";
        String month = "10";
        String day = "02";
        Day actualDay = getOneDay(cookies, year, month, day);
        Day expectedDay = getExpectedJsonFromFile("testGetOneDay", Day.class);
        assertEquals(expectedDay,actualDay);
    }

    @Test
    public void testPostBreakTime() {
        int breakTime = 2700;
        Map body = new HashMap();
        body.put("break_time", breakTime);
        int actualBreak = postBreakTime(cookies, body).get("break_time");
        assertEquals(breakTime, actualBreak);
    }

    @Test
    public void testGetValidateDaysForTheMonth() {
        String year = "2018";
        String month = "10";
        ArrayList<JSONObject> requestJsonMessage = getValidateDaysForTheMonth(cookies, year, month).getJsonObject("messages");
        for (int i=0; i<requestJsonMessage.size(); i++){
            assertThat(String.valueOf(requestJsonMessage.get(i)), is(containsString(year+"-"+month)));
        }
    }

    @Test
    public void testPutDayForCurrentUser() {

        Map body = new HashMap();
        body.put("code_id", null);
        body.put("assigments", "");
        body.put("wdate", "2018-10-10");
        body.put("start_time", 36900);
        body.put("stop_time", 68400);
        body.put("break_time", 3600);
        body.put("comment", "test 34");

        //String comment = putDayForCurrentUser(cookies, body).get("comment");
        assertEquals(body.get("comment"), putDayForCurrentUser(cookies, body).get("comment"));
    }

    @Test
    public void testPutDayForUserWithId() {

        int id = 37;
        Map body = new HashMap();
        body.put("code_id", null);
        body.put("assigments", "");
        body.put("wdate", "2018-10-17");
        body.put("start_time", 36900);
        body.put("stop_time", 68400);
        body.put("break_time", 3600);
        body.put("comment", "test by Days Controller Test Cl");

        //String comment = putDayForCurrentUser(cookies, body).get("comment");
        assertEquals(body.get("comment"), putDayForUserWithId(cookies, body, id).get("comment"));
    }

}
