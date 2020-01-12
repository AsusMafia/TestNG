package com.Class01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class NegativeLogin extends CommonMethods{
	
	/*
	 * Open chrome browser
	 * Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	 * Enter valid username
	 * Leave password field empty
	 * Verify error message with text “Password cannot be empty” is displayed.
	 */

	@BeforeMethod
	public void openURL() {
		setUp("Chrome", Constants.HRMURL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void emptyPassword() {
		String spanMessage =driver.findElement(By.cssSelector("span#spanMessage")).getText();
		String expTest ="Password cannot be empty";
		Assert.assertEquals(spanMessage, expTest);
//		if(spanMessage.equals(expTest)) {
//			System.out.println("Test => PASS");
//		}else {
//			System.out.println("Test => FAIL");
//		}
	}
}
