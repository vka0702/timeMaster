package rest;

import com.sidenis.timemaster.rest.controller.ExtraController;
import com.sidenis.timemaster.rest.vo.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExtraControllerTests extends ExtraController {

    private static  Map<String, String> cookies;
    @BeforeClass
    public static void log() {
        cookies = login(userName_AA, userPassword_AA);
    }

    @Test
    public void testGetWhoAmI() {
        User iAm = ExtraController.getWhoAmI(cookies);
        assertEquals(userName_AA, iAm.getUid());
    }

    @AfterClass
    public static void unLog() {
        logout(cookies);
    }

}
