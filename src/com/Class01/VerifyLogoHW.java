package com.Class01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

public class VerifyLogoHW extends CommonMethods{

	/*
	 * Open chrome browser
	 * Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	 * Enter valid username and password
	 * Click on login button
	 * Then verify Syntax Logo is displayed
	 * Close the browser

	 */
	
	@BeforeMethod
	public void openURL() {
		setUp("Chrome", Constants.HRMURL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void logoVeryfication() {
		boolean logoDisplayed = driver.findElement(By.xpath("//img[@alt='OrangeHRMm']")).isDisplayed();
		
		Assert.assertTrue(logoDisplayed, "logo is displayed");
	if (logoDisplayed) {
		System.out.println("Test => PASS");
	}else {
		System.out.println("TEst => FAIL");
	}
	}
}
