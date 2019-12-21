package rest;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.sidenis.timemaster.rest.controller.ExtraController;
import com.sidenis.timemaster.rest.vo.Day;
import com.sidenis.timemaster.rest.vo.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ExtraControllerTests extends ExtraController {

    private static  Map<String, String> cookies;
    @BeforeClass
    public static void log() {
        cookies = login(userName_AA, userPassword_AA);
    }

    @Test
    public void testGetWhoAmI() throws IOException {
        User actualUser = ExtraController.getWhoAmI(cookies);
        User expectedUser = getExpectedJsonFromFile("testGetWhoAmI", User.class);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void srav() {
        List<String> expect = new ArrayList<>();
        expect.add("qwer");
        expect.add("ty");
        assertThat(expect.toString()).isEqualTo("qwerty");

    }

//    @AfterClass
//    public static void unLog() {
//        logout(cookies);
//    }

}
