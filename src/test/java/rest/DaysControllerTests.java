package rest;

import com.sidenis.timemaster.common.rest.DaysController;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DaysControllerTests extends DaysController {

    private static  Map<String, String> cookies;
    @BeforeClass
    public static void log() {
        cookies = login(userName_KD, userPassword_KD);
    }
    @Test
    public void testGetDaysForTheMonth() {
        String year = "2018";
        String month = "10";
        List<String> dates = getDaysForTheMonth(cookies,year,month).get("wdate");
        for (String i: dates) {
            assertThat(i, is(containsString(year+"-"+month)));

        }
    }

    @Test
    public void testGetOneDay() {
        String year = "2018";
        String month = "10";
        String day = "03";
        String date = getOneDay(cookies, year, month, day).get("wdate");
        if (date != null) {
            assertEquals(year+"-"+month+"-"+day, date);
        }
        else System.out.println("Date is null");
    }
}
