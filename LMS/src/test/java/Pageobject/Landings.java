package Pageobject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landings {

	WebDriver driver;

	public Landings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="mobNo")public WebElement MobileNumber;
	@FindBy(className="login_btn") public WebElement StartSelling;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]") public WebElement Siginpassword;
	@FindBy(id="usr_password") public WebElement password;
	@FindBy(id="signWP") public WebElement Submit;
//	By MobileNumber = By.id("mobNo");
//	By StartSelling = By.className("login_btn");
//	By Siginpassword = By.xpath("(//span[text()='Sign in with Password'])[2]");
//	By password = By.id("usr_password");
//	By Submit = By.id("signWP");
//	
	public void EnterMobileNumber(String num) {

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(MobileNumber));
		MobileNumber.sendKeys(num);
	}

	public void ClickonStartselling() {
		StartSelling.click();

	}

	public void clickpassword() throws InterruptedException {
		WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(Siginpassword));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);

	}

	public void enterpassword(String pass) {
		password.sendKeys(pass);
		Submit.click();
	}

	public void submitpassword() {
		Submit.click();
	}

}


//	public void EnterMobileNumber(String num) {
//		new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOfElementLocated(MobileNumber));
//		driver.findElement(MobileNumber).sendKeys(num);
//
//	}
//
//	public void ClickonStartselling() {
//		driver.findElement(StartSelling).click();
//
//	}
//
//	public void clickpassword() throws InterruptedException {
//		WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.elementToBeClickable(Siginpassword));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
//		
//	}
//
//	public void enterpassword(String pass) {
//		driver.findElement(password).sendKeys(pass);
//		driver.findElement(Submit).click();
//	}
//
//	public void submitpassword() {
//		driver.findElement(Submit).click();
//	}
//	
//	
//
//}
