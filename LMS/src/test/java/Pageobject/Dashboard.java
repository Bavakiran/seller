package Pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
	By popup1 = By.xpath("//span[text()='Later']");
	By headerlms = By.id("messageWid");
	By LMS = By.id("messageCount");
	
	public void popup() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    try {
		        WebElement laterBtn = wait.until(ExpectedConditions.elementToBeClickable(popup1));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", laterBtn);
		    } catch (Exception e) {
		        System.out.println("Popup not displayed or already handled.");
		    }
	}


	public void LandingonLMS() throws InterruptedException {
		driver.findElement(headerlms).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(LMS).click();
	}

}
