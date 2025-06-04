package Pageobject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class listView {
	WebDriver driver;
	WaitUtils waitUtils;

	@FindBy(id = "threedotId")
	public WebElement Hamburger;
	@FindBy(id = "messageCount")
	public WebElement LMS1;
	@FindBy(xpath = "//div[contains(text(),\"List View\")]")
	public WebElement listview;
	@FindBy(id = "lv_hdr_drpdwn")
	public WebElement dropDown;
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div[6]/div/div/section/div/div/div[1]/div[2]")
	public WebElement dropDownOptionLocator;
	@FindBy(xpath = "//li[normalize-space()='All Contacts']")
	public WebElement finalclick;
	String liXpath = "//*[@id='root']/div[6]/div/div/section/div/div/div[1]/div[2]//li";
	@FindBy(id = "searchauto")
	public WebElement search;

	
	public listView(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);

	}

	public void clickListView() {
		LMS1.click();
		waitUtils.waitForClickability(Hamburger).click();
		waitUtils.waitForClickability(listview).click();
	}

	public void dropdown() throws InterruptedException {
		    dropDown.click();
		    Thread.sleep(400);

		    List<String> allTexts = driver.findElements(By.xpath(liXpath)).stream()
		        .map(e -> e.getText().trim())
		        .collect(Collectors.toList());

		    dropDown.click();
		    Thread.sleep(300);

		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    for (String text : allTexts) {
		        dropDown.click();
		        Thread.sleep(400);

		        // Scroll until the element is visible
		        while (driver.findElements(By.xpath(liXpath + "[normalize-space()='" + text + "']")).isEmpty()) {
		            js.executeScript("arguments[0].scrollTop += 60;", dropDownOptionLocator);
		            Thread.sleep(150);
		        }

		        WebElement li = driver.findElement(By.xpath(liXpath + "[normalize-space()='" + text + "']"));
		        js.executeScript("arguments[0].click();", li);
		        System.out.println("Clicked: " + text);
		        Thread.sleep(800);
		    }
		    dropDown.click();
		    finalclick.click();
		}

	public void searchbox(String nam, String prod, String cit, String comp, String mob) throws InterruptedException {
		search.sendKeys(nam);
		Thread.sleep(2000);
		search.clear();
		search.sendKeys(prod);
		Thread.sleep(2000);
		search.clear();
		search.sendKeys(cit);
		Thread.sleep(2000);
		search.clear();
		search.sendKeys(comp);
		Thread.sleep(2000);
		search.clear();
		search.sendKeys(mob);
		
		
		
	}
	}
		
	

