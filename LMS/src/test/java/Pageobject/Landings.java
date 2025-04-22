package Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.WaitUtils;

public class Landings {

	WebDriver driver;
	WaitUtils waitUtils;

	public Landings(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mobNo")
	public WebElement MobileNumber;
	@FindBy(className = "login_btn")
	public WebElement StartSelling;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")
	public WebElement Siginpassword;
	@FindBy(id = "usr_password")
	public WebElement password;
	@FindBy(id = "signWP")
	public WebElement Submit;

	public void enterMobileNumber(String num) {
		waitUtils.waitForVisibility(MobileNumber).sendKeys(num);
	}

	public void clickOnStartSelling() {
		waitUtils.waitForClickability(StartSelling).click();
	}

	public void clickPassword() {
		WebElement ele = waitUtils.waitForClickability(Siginpassword);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void submitPassword() {
		waitUtils.waitForClickability(Submit).click();
	}
}