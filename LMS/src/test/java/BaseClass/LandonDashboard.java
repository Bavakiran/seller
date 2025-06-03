package BaseClass;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.WaitUtils;

public class LandonDashboard {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WaitUtils waitUtils;

    public void setUp() {
       {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\bavak\\Downloads\\chromedriver-win64 (6)\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-notifications");
            driver = new ChromeDriver(options);
     

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUtils = new WaitUtils(driver);
        driver.get("https://seller.indiamart.com/");
    }
       }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
