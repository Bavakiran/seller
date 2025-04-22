package Testrun;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.LandonDashboard;
import Pageobject.Dashboard;
import Pageobject.Landings;
import Utilities.WaitUtils;

public class Landingrun extends LandonDashboard {

	Landings landing;
	Dashboard dashboard;

	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		setUp(browser);
		landing = new Landings(driver, waitUtils);
		dashboard = new Dashboard(driver, waitUtils);
	}

	@Test
	public void verifyLandingFlow() throws InterruptedException {
		landing.enterMobileNumber("8610237001");
		landing.clickOnStartSelling();
		landing.clickPassword();
		landing.enterPassword("261520");
		landing.submitPassword();
		dashboard.popup();
		dashboard.LMSclick();
	}
}   