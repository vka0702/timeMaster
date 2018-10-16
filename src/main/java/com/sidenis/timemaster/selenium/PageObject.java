package com.sidenis.timemaster.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class PageObject {
    protected static WebDriver driver;

    public PageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void waitFor(ExpectedCondition condition) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(condition);
    }

    public static boolean findWebElementOnPage (WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
