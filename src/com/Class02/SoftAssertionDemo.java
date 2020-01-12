package com.Class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * open application
 * Verify Logo is displayed
 * Enter a valid credentials
 * Verify user has successfully logged in
 */

public class SoftAssertionDemo extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("Chrome", Constants.HRMURL);

	}

	@Test
	public void logoAndLogin() {

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();

		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		//welcomeDisplayed = false; // Hard assertion: essentially you're controlling the test result so that that
									// specific test
		//Assert.assertTrue(welcomeDisplayed); // either passes or fails.

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(welcomeDisplayed, "Welcome is not Displayed");

		boolean logoDisplayed = driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		softAssert.assertTrue(logoDisplayed, "Logo is not displayed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
