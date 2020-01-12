package com.Class01;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TitleLogoAndLoginVerification extends CommonMethods {

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
		String title = driver.getTitle();
		String expTitle = "Human Management System";
		if (title.equals(expTitle)) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL");
		}
	}
	
	@Test
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Test => PASS");
		} else {
			System.out.println("Test => FAIL");
		}
	}
	
	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
}
