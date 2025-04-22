package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.WaitUtils;

public class Dashboard {
	WebDriver driver;
	WaitUtils waitUtils;

	By popup1 = By.xpath("//span[text()='Later']");
	By headerlms = By.id("messageWid");
	By LMS = By.id("messageCount");

	public Dashboard(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
	}

	public void popup() {
		try {
			// Adding static wait to give time for the popup to appear
			Thread.sleep(3000);

			WebElement laterBtn = waitUtils.waitForClickability(driver.findElement(popup1));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", laterBtn);
		} catch (Exception e) {
			System.out.println("Popup not found or not clickable. Skipping popup.");
		}
	}
	public void LMSclick() {
		driver.findElement(headerlms).click();
		driver.navigate().back();
		WebElement lms=waitUtils.waitForClickability(driver.findElement(LMS));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", lms);

		
	}
	}