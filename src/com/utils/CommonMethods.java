package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {

	public static WebDriver driver;

	/**
	 * Use this method to open webpage.
	 * 
	 * @param browser =>Use this parameter to specify which browser to use
	 * @param url     =>Use this parameter to provide the URL.
	 * @return
	 */
	public static WebDriver setUp(String browser, String url) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.err.println("Browser not supported; please choose Firefox or Chrome.");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		return driver;

	}

	/**
	 * THis method will dismiss the alert
	 * 
	 * @throws will throw NoAlertPresentation
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert has been dismissed.");
		}
	}

	/**
	 * This method will accept an alert.
	 * 
	 * @throws will throw NoAlertPresentation
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert has been accepted.");
		}
	}

	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert text has been stored");
			return null;
		}

	}

	/**
	 * This method will swith to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(String nameorID) {
		try {
			driver.switchTo().frame(nameorID);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present. ");
		}
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}

	/**
	 * JavaScript code to click on element when the clicking can't be automated isn't working
	 * 
	 * @param webElement
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method will scroll the page until the specified element is found
	 * 
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down by the specified number of pixels
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll up on the page by the amount of the specified pixel
	 * amount
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will switch to the frame
	 * 
	 * @param element
	 */

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}

}
