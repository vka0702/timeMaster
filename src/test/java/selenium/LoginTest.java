package selenium;

import com.sidenis.timemaster.selenium.PageObject;
import com.sidenis.timemaster.selenium.blocks.TopBlock;
import com.sidenis.timemaster.selenium.pageobject.LoginPage;
import com.sidenis.timemaster.selenium.pageobject.TimeTablePage;
import com.sidenis.timemaster.selenium.pageobject.WorkloadPage;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;

import static junit.framework.TestCase.assertFalse;
import static com.sidenis.timemaster.selenium.PageObject.findWebElementOnPage;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoginTest extends DeclareClass{

    private static LoginPage loginPage = new LoginPage(driver);
    private static TopBlock topBlock = new TopBlock(driver);
    private static WorkloadPage workloadPage = new WorkloadPage(driver);

//    @Test
//    public void testLogin() {
//        assertEquals(TimeTablePage.URL, driver.getCurrentUrl());
//    }

    @Test
    public void testLoadWorkload() {
        //topBlock.goToWorkload();
        driver.get(workloadPage.URL);
        DateFormat format = new SimpleDateFormat("MM/yyyy");
        Date date = new Date();
        PageObject.waitFor(ExpectedConditions.visibilityOfAllElements(workloadPage.fieldFind, workloadPage.fieldMonth, workloadPage.firstUserInTable));
        assertEquals(format.format(date), workloadPage.fieldMonth.getAttribute("value"));
        assertEquals("", workloadPage.fieldFind.getAttribute("value"));
    }

    @Test
    public void testCorrectPutFieldFind() throws InterruptedException {
        topBlock.goToWorkload();
        String name = "Kirill Dus";
        workloadPage.putFieldFind(name);
        PageObject.waitFor(ExpectedConditions.visibilityOf(workloadPage.firstUserInTable));
        assertThat(workloadPage.firstUserInTable.getText(), is(containsString(name)));
    }

    @Test
    public void testUncorrectPutFieldFind() {
        topBlock.goToWorkload();
        String name = "Kirill Mushin";
        workloadPage.putFieldFind(name);
        assertFalse(findWebElementOnPage(workloadPage.firstUserInTable));

    }

    @Test
    public void testLogout() {
        topBlock.logout();
        PageObject.waitFor(ExpectedConditions.visibilityOf(loginPage.logoOnLoginPage));
        assertEquals(LoginPage.URL, driver.getCurrentUrl());
    }


//    @Test
//    public void testLogout() {
//        driver.get(LoginPage.URL);
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterToTimemaster();
//        TimeTablePage timeTablePage = new TimeTablePage(driver);
//        PageObject.waitFor(ExpectedConditions.visibilityOf(timeTablePage.topBlock.sidenisLogo));
//        assertEquals(timeTablePage.URL, driver.getCurrentUrl());
//        timeTablePage.topBlock.buttonLogout.click();
//        PageObject.waitFor(ExpectedConditions.visibilityOf(loginPage.logoOnLoginPage));
//        assertEquals(loginPage.URL, driver.getCurrentUrl());
//    }

}
