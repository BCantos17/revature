package com.demoaut.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.reavture.selenium.FindFlightPage;

import java.util.concurrent.TimeUnit;

/**
 * Page Object Model
 * for NewTours LoginPage
 * http://newtours.demoaut.com/
 *
 * Interfaces with the webpage
 * Enhances reusability of Selenium code
 * A "JavaBean" for my web page
 */
public class LoginPage {

    private final String usernameBoxName = "userName";
    private final String passwordBoxName = "password";
    private final String loginButtonName = "login";

    private WebDriver driver;

    /**
     * Uses appropriate provided driver
     * e.g. chromdriver, iedriver
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://newtours.demoaut.com/");
    }

    /**
     * Types the specified username in
     * @param username
     */
    public void setUsername(String username) {
        driver.findElement(By.name(usernameBoxName)).sendKeys(username);
        implicitWait();
    }

    /**
     * Types the specified password in
     * @param password
     */
    public void setPassword(String password) {
        driver.findElement(By.name(passwordBoxName)).sendKeys(password);
        implicitWait();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    
    public FindFlightPage clickLoginButton() {
        driver.findElement(By.name(loginButtonName)).click();
        implicitWait();
        return new FindFlightPage(driver);
    }

    /**
     * Either wait 5 seconds or until the next thing finishes
     */
    private void implicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}