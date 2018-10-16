package com.sidenis.timemaster.selenium.blocks;

import com.sidenis.timemaster.selenium.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBlock extends PageObject {

    public TopBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sidenis-logo")
    public WebElement sidenisLogo;

    @FindBy(xpath = "//button//*[text()='Timetable']")
    public  WebElement buttonTimetable;

    @FindBy(xpath = "//button//*[text()='Workload']")
    public WebElement buttonWorkload;

    @FindBy(xpath = "//button//*[text()='Settings']")
    public WebElement buttonSettings;

    @FindBy(xpath = "//button//*[text()='Vacations']")
    public WebElement buttonVacations;

    @FindBy(xpath = "//button//*[text()='Help']")
    public WebElement buttonHelp;

    @FindBy(xpath = "//button//*[text()='Logout']")
    public WebElement buttonLogout;

    public void goToTimetable() {
        buttonTimetable.click();
    }

    public void goToWorkload() {
        buttonWorkload.click();
    }

    public void goToSettings() {
        buttonSettings.click();
    }

    public void goToVacations() {
        buttonVacations.click();
    }

    public void goToHelp() {
        buttonHelp.click();
    }

    public void logout() {
        buttonLogout.click();
    }

}
