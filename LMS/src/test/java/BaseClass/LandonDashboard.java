package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandonDashboard {
	

	    protected WebDriver driver;
	    protected WebDriverWait wait;

	    
	    public void setUp() {
	        
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\bavak\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("https://seller.indiamart.com/");
	    }
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  
	        }
	    }


	

}
