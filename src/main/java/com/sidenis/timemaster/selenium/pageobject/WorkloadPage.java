package com.sidenis.timemaster.selenium.pageobject;

import com.sidenis.timemaster.selenium.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class WorkloadPage extends PageObject {
    public WorkloadPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "http://timemaster-dev3.sidenis.io/workload";

    @FindBy(xpath = "//*[@placeholder='Month and Year']")
    public WebElement fieldMonth;

    @FindBy(xpath = "//*[@placeholder='Find user']")
    public WebElement fieldFind;

    @FindBy(xpath = "//table//tr[1]/td")
    public WebElement firstUserInTable;

    @FindBy(xpath = "//table//tr[2]/td")
    public WebElement secondUserInTable;

    @FindBy(xpath = "//table//tr[270]/td")
    public WebElement lastUserInTable;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement iconCalendar;

    @FindBy(xpath = "//div[text()='SEP']")
    public WebElement valueSeptember;

    @FindBy(xpath = "//div[text()='OCT']")
    public WebElement valueOctober;

    @FindBy(xpath = "//div[text()='NOV']")
    public WebElement valueNovember;

    public void putFieldFind(String user) {
        fieldFind.clear();
        fieldFind.sendKeys(user);
        fieldFind.sendKeys(Keys.ENTER);
    }

}
