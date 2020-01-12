package com.Class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionExercise extends CommonMethods{
	
	@BeforeMethod
	public void login() {
		setUp("chrome", Constants.HRMURL);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
	}
	
	@Test
	public void addEmp() {
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		SoftAssert softAssert = new SoftAssert();
		
		boolean fullnameDisp = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
		Assert.assertTrue(fullnameDisp);
		softAssert.assertTrue(fullnameDisp);
		
		boolean idDisp = driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		Assert.assertTrue(idDisp);
		softAssert.assertTrue(idDisp);
		
		boolean photoDisp = driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		Assert.assertTrue(photoDisp);
		softAssert.assertTrue(photoDisp);
		
		driver.findElement(By.cssSelector("input#firstName")).sendKeys("Deer");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Park");
		WebElement empID = driver.findElement(By.cssSelector("input#employeeId"));
		empID.clear();
		empID.sendKeys("1231312312");
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
