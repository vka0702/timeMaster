package com.sidenis.timemaster.selenium.pageobject;

import com.sidenis.timemaster.selenium.PageObject;
import com.sidenis.timemaster.selenium.blocks.TopBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimeTablePage extends PageObject {
    public TimeTablePage(WebDriver driver) {
        super(driver);
    }
    public static final String URL = "http://timemaster-dev3.sidenis.io/time-tracker";

    public TopBlock topBlock = new TopBlock(driver);

    @FindBy(css = ".sidenis-logo")
    public WebElement sidenisLogo;

    @FindBy(xpath = "//button//*[text()='Logout']")
    public WebElement buttonLogout;

}
