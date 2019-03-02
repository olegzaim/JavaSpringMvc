package com.em.automation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(BlockJUnit4ClassRunner.class)
public class Automation {
	@Test
	public void testLoginPage() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/olegzaimm/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
		Thread.sleep(5000); // Let the user actually see something!
		WebElement usernameElement = driver.findElement(By.name("username"));
		WebElement passElement = driver.findElement(By.name("password"));
		WebElement formElement = driver.findElement(By.id("loginForm"));
		
		
		usernameElement.sendKeys("oleg");
		passElement.sendKeys("oleg");
		
		formElement.submit();
		
		Thread.sleep(5000); // Let the user actually see something!
		driver.quit();
		// Close the instance of browser
		driver.close();
	}

}
