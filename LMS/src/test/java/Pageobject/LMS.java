package Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class LMS {
	WebDriver driver;
	WaitUtils waitUtils;
	
	@FindBy(xpath = "//li[@title=\\\"I don't have it\\\"]//input[@type='radio']")
	public WebElement popup1;
	@FindBy(xpath = "//span[contains(text(),\"Later\")]")
	public WebElement popup2;

	public LMS(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);

	}

	public void popupC1() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", popup1);
		

	}

	public void popupC2() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", popup2);
	}
	


}
