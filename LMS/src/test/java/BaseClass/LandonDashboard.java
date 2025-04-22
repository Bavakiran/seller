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

    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\bavak\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\bavak\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUtils = new WaitUtils(driver);
        driver.get("https://seller.indiamart.com/");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
