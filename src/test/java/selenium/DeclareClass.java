package selenium;

import com.sidenis.timemaster.common.BaseTimeMasterTest;
import com.sidenis.timemaster.common.Constants;
import com.sidenis.timemaster.selenium.PageObject;
import com.sidenis.timemaster.selenium.blocks.TopBlock;
import com.sidenis.timemaster.selenium.pageobject.LoginPage;
import com.sidenis.timemaster.selenium.pageobject.TimeTablePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.sidenis.timemaster.common.Constants.*;
import static org.junit.Assert.assertEquals;

public class DeclareClass {

    protected static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);

        driver.get(LoginPage.URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterToTimemaster();
        TimeTablePage timeTablePage = new TimeTablePage(driver);
        PageObject.waitFor(ExpectedConditions.visibilityOf(timeTablePage.topBlock.sidenisLogo));
        assertEquals(TimeTablePage.URL, driver.getCurrentUrl());
    }


    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

}
