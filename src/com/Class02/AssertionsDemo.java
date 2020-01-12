package com.Class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionsDemo extends CommonMethods{
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp("Chrome", Constants.HRMURL);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

	@Test
	public void titleVerification() {
		String actualTitle = driver.getTitle();
		String expTitle = "Human Management System+Wrong";
		
		Assert.assertEquals(actualTitle, expTitle, "Titles are matched!"); 			//Compares both statements displays the message is they're exact match!. 
		//Using if conditions, we can't make testNG test fails. 
//		if (actualTitle.equals(expTitle)) {
//			System.out.println("Test PASS");
//		} else {
//			System.out.println("Test FAIL");
//		}
	}
	
	@Test
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax Logo is displayed");
//		if (isDisplayed) {
//			System.out.println("Test => PASS");
//		} else {
//			System.out.println("Test => FAIL");
//		}
	}
	
	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
}


