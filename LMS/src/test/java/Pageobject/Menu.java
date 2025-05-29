package Pageobject;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	@FindBy(xpath = "//div[@role=\"gridcell\"][1]")
	public WebElement contacts;
	@FindBy(xpath = "//div[@id='all_features_caret']")
	public WebElement dropdown;
	@FindBy(xpath = "//span[normalize-space()='Hide']")
	public WebElement hidecontacts;
	@FindBy(xpath = "//*[contains(text(),\"Hidden Contacts\")]")
	public WebElement hiddencontacts;
	@FindBy(className = "three_dot_icns")
	public WebElement unhidecontacts;
	@FindBy(id = "leftnav_dash_link")
	public WebElement LMS;
	@FindBy(id = "messageCount")
	public WebElement LMS1;
	@FindBy(xpath = "//div[contains(text(),\"Rehoboth\")]")
	public WebElement toblock;
	@FindBy(xpath = "//span[contains(text(),\"Block\")]")
	public WebElement block;
	@FindBy(xpath = "//button[contains(text(),\"Block\")]")
	public WebElement blockconf;
	@FindBy(xpath = "//div[contains(text(),\"Blocked Contacts\")]")
	public WebElement blockedcontacts;
	@FindBy(xpath = "//span[@title='Unblock']")
	public WebElement unblock;
	@FindBy(xpath = "//div[contains(text(),'Support & Information')]")
	public WebElement SupportandInfo;
	@FindBy(xpath = "//div[contains(text(),'All Alerts')]")
	public WebElement AllAlerts;
	@FindBy(xpath = "//li[contains(text(),'Past')]")
	public WebElement past;
	@FindBy(xpath = "//li[contains(text(),'Active')]")
	public WebElement active;
	@FindBy(xpath = "//div[normalize-space()='Help Videos']")
	public WebElement helpvideos;
	@FindBy(xpath = "(//div[text()='Performance Reports'])[1]")
	public WebElement performancereports;
	@FindBy(xpath = "//div[text()='Import / Export Leads']")
	public WebElement ImportExportLeads;
	@FindBy(xpath = "//div[text()='Pull API']")
	public WebElement pullAPI;
	@FindBy(xpath = "//div[text()='Push API']")
	public WebElement pushAPI;
	@FindBy(xpath = "//div[text()='Book Transport with IM']")
	public WebElement BookTransport;
	@FindBy(className = "exitBtnIcon")
	public WebElement BookTransportexit;// Assuming this is the element for Book Transport with IM;

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
		Thread.sleep(1000);
		actions.moveToElement(contacts).perform();
		actions.contextClick(contacts).perform();
		waitUtils.waitForClickability(unhidecontacts).click();

	}

	public void BlockContact() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);
		LMS1.click();
		waitUtils.waitForVisibility(Hamburger).click();
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(toblock);

		Actions actions = new Actions(driver);
		actions.moveToElement(toblock).contextClick().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", block);

		waitUtils.waitForClickability(blockconf).click();

		Thread.sleep(2000);

		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(managecontacts).click();
		waitUtils.waitForClickability(blockedcontacts).click();

		waitUtils.waitForClickability(toblock);
		actions.moveToElement(toblock).perform();
		Thread.sleep(1000);

		waitUtils.waitForClickability(unblock).click();

		waitUtils.waitForClickability(LMS);
		LMS1.click();

	}

	public void SupportandInformation() throws InterruptedException {
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(SupportandInfo).click();
		waitUtils.waitForClickability(AllAlerts).click();
		waitUtils.waitForClickability(past).click();
		waitUtils.waitForClickability(active).click();
		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);

	}

	public void HelpVideos() throws InterruptedException {
		LMS1.click();
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(SupportandInfo).click();
		waitUtils.waitForClickability(helpvideos).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindow);

		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);

	}

	public void PerformanceReports() throws InterruptedException {
		waitUtils.waitForClickability(LMS1).click();
		waitUtils.waitForClickability(performancereports).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindow);
		waitUtils.waitForClickability(LMS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", LMS);

	}

	public void ImportExportLeads() throws InterruptedException {
		LMS1.click();
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(ImportExportLeads).click();
		waitUtils.waitForClickability(pullAPI).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				Thread.sleep(1000);
				String pageBody = driver.getPageSource();
				Assert.assertTrue(pageBody.contains("paid service"), "Text 'paid service' not found in page body");
				break;
			}
		}
		driver.switchTo().window(parentWindow);
		waitUtils.waitForClickability(ImportExportLeads).click();
		waitUtils.waitForClickability(pushAPI).click();
		String parentWindow1 = driver.getWindowHandle();
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
			if (!window.equals(parentWindow1)) {
				driver.switchTo().window(window);
				Thread.sleep(1000);
				String pageBody = driver.getPageSource();
				Assert.assertTrue(pageBody.contains("paid service"), "Text 'paid service' not found in page body");
				break;
			}
		}
		driver.switchTo().window(parentWindow);

	}

	public void ShipwithIM() throws InterruptedException {
		waitUtils.waitForClickability(BookTransport).click();
		waitUtils.waitForClickability(BookTransportexit).click();

	}
}
