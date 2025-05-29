package Pageobject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class Dashboard {
	WebDriver driver;
	WaitUtils waitUtils;
	
	@FindBy(xpath="//span[text()='Later']")
	public WebElement popup1;
	@FindBy(id="messageWid")
	public WebElement headerlms;
	@FindBy(xpath="//*[@id=\"message_tab\"]/a")
	public WebElement LMS;
	
	
	   public Dashboard(WebDriver driver, WaitUtils waitUtils) {
	        this.driver = driver;
	        this.waitUtils = waitUtils;
	        PageFactory.initElements(driver, this); 
	    
	}

	public void popup() {
		try {
			Thread.sleep(3000);
			 waitUtils.waitForClickability(popup1);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", popup1);
		} catch (Exception e) {
			System.out.println("Popup not found or not clickable. Skipping popup.");
		}
	}
	public void LMSclick() throws InterruptedException {
		headerlms.click();
		driver.navigate().back();
		Thread.sleep(2000);
		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);

		
	}
	}