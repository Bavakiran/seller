package Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class Menu {

	WebDriver driver;
	WaitUtils waitUtils;

	@FindBy(id = "threedotId")
	public WebElement Hamburger;
	@FindBy(xpath = "//*[contains(text(),\"Manage Contacts\")]")
	public WebElement managecontacts;
	@FindBy(xpath = "//*[contains(text(),\"Add Contact\")]")
	public WebElement addcontact;
	@FindBy(id = "addContactName")
	public WebElement name;
	@FindBy(id = "addContactMobile")
	public WebElement mobile;
	@FindBy(id = "addContactNote")
	public WebElement note;
	@FindBy(id = "addcon")
	public WebElement submit;
	@FindBy(xpath = "//div[contains(text(),'Kiran')][1]")
	public WebElement contacts;
	@FindBy(xpath = "//div[@id='all_features_caret']")
	public WebElement dropdown;
	@FindBy(xpath = "//span[normalize-space()='Hide']")
	public WebElement hidecontacts;
	@FindBy(xpath = "//*[contains(text(),\"Hidden Contacts\")]")
	public WebElement hiddencontacts;
	@FindBy(className = "three_dot_icns")
	public WebElement unhidecontacts;
	@FindBy(xpath = "//*[@id=\"message_tab\"]/a")
	public WebElement LMS;
	@FindBy(xpath = "//div[contains(text(),\"Nellai Ceramic Centre\")]")
	public WebElement toblock;
	@FindBy(xpath = "//span[contains(text(),\"Block\")]")
	public WebElement block;
	@FindBy(xpath = "//button[contains(text(),\"Block\")]")
	public WebElement blockconf;
	@FindBy(xpath = "//div[contains(text(),\"Blocked Contacts\")]")
	public WebElement blockedcontacts;
	@FindBy(xpath = "//span[@title='Unblock']")
	public WebElement unblock;
	
	public Menu(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);

	}

	public void AddContact(String nam, String num, String not) throws InterruptedException {
		Thread.sleep(2000);
		waitUtils.waitForClickability(managecontacts).click();
		waitUtils.waitForClickability(addcontact).click();
		name.sendKeys(nam);
		mobile.sendKeys(num);
		note.sendKeys(not);
		Thread.sleep(2000);
		// waitUtils.waitForClickability(submit).click();

	}

	public void HideContact() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(contacts).perform();
		actions.contextClick().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", hidecontacts);
		Thread.sleep(3000);
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(managecontacts).click();
		waitUtils.waitForClickability(hiddencontacts).click();
		actions.moveToElement(contacts).perform();
		actions.contextClick(contacts).perform();
		waitUtils.waitForClickability(unhidecontacts).click();
		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);
		

	}
	public void BlockContact() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(toblock).perform();
		actions.contextClick(toblock).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", block);
		waitUtils.waitForClickability(blockconf).click();
		Thread.sleep(3000);
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(managecontacts).click();
		waitUtils.waitForClickability(blockedcontacts).click();
		actions.moveToElement(toblock).perform();
		actions.contextClick(toblock).perform();
		waitUtils.waitForClickability(unblock).click();
		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);
		

	}
	

}
