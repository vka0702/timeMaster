package rest;

import com.sidenis.timemaster.common.rest.ExtraController;
import org.junit.BeforeClass;

import java.util.Map;

import static com.sidenis.timemaster.common.annotation.Constants.userName_AA;
import static com.sidenis.timemaster.common.annotation.Constants.userPassword_AA;

public class ExtraControllerTests extends ExtraController {

    static Map<String, String> cookies;
    @BeforeClass
    public void log(){
        cookies = login(userName_AA, userPassword_AA);
    }



}
