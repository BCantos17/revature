package com.reavture.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demoaut.newtours.LoginPage;

public class NewToursLoginTest {
	private WebDriver driver;

	@Before
	public void makedriver() {
		String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		;
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		// Notice the absence of Selenium code
		LoginPage page = new LoginPage(driver);

		org.junit.Assert.assertEquals("Welcome: Mercury Tours", page.getPageTitle());
		page.setUsername("a");
		page.setPassword("a");
		FindFlightPage findFight = page.clickLoginButton();

		// Made it to the next page
		org.junit.Assert.assertEquals("Find a Flight: Mercury Tours:", findFight.getPageTitle());
		findFight.selectOneWay();
		findFight.selectPassenegers(2);
		findFight.selectDepartLocation("New York");
		findFight.clickFindFlightsButton();
		
		org.junit.Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
	}

	@After
	public void quit() {
		driver.quit();
	}

}