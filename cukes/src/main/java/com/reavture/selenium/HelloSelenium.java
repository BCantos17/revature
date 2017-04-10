package com.reavture.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * Selenium WebDriver
 * @Automate your testing
 * http://newtours.demoaut.com/
 *
 */
public class HelloSelenium {
	public static void main(String[] args) {
		String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		String URL = "http://revature.com";
		WebDriver driver = new ChromeDriver();
		
		// should open the browser and navigate to URL
		driver.get(URL);
		
		String X_PATH = "//*[@id=\"menu-item-234\"]/a";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.click(); // clicks the link or button
		
		// driver.close(); will only close browser
		
		// "pause" the automation test
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Kills the driver process and closes broswer
		driver.quit();
	}
}
