package com.sidenis.timemaster.selenium.pageobject;

import com.sidenis.timemaster.common.Constants;
import com.sidenis.timemaster.selenium.PageObject;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "http://timemaster-dev3.sidenis.io/login";

    @FindBy(css = "#mat-input-0")
    public WebElement fieldLogin;

    @FindBy(css = "#mat-input-1")
    public WebElement fieldPass;

    @FindBy(css = ".mat-raised-button")
    public WebElement buttonAuth;

    @FindBy(css=".logo")
    public WebElement logoOnLoginPage;

    public void enterToTimemaster() {
        //fieldLogin.click();
        fieldLogin.sendKeys(Constants.userName_KD);
        //fieldPass.click();
        fieldPass.sendKeys(Constants.userPassword_KD);
        buttonAuth.click();
    }
}
