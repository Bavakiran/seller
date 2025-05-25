package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class Menu {
	
	WebDriver driver;
	WaitUtils waitUtils;
	
	@FindBy(id="threedotId")
	public WebElement Hamburger;
	@FindBy(xpath="//*[contains(text(),\"Manage Contacts\")]")
	public WebElement managecontacts;
	@FindBy(xpath="//*[contains(text(),\"Add Contact\")]")
	public WebElement addcontact;
	@FindBy(id="addContactName")
	public WebElement name;
	@FindBy(id="addContactMobile")
	public WebElement mobile;
	@FindBy(id="addContactNote")
	public WebElement note;
	@FindBy(id="addcon")
	public WebElement submit;
	
	public Menu(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);

	}
	public void AddContact(String nam,String num,String not) throws InterruptedException {
		Thread.sleep(2000);
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(managecontacts).click();
		waitUtils.waitForClickability(addcontact).click();
		name.sendKeys(nam);
		mobile.sendKeys(num);
		note.sendKeys(not);
		Thread.sleep(2000);
		waitUtils.waitForClickability(submit).click();


		

		
	}
}

