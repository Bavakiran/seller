package Testrun;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.LandonDashboard;
import Pageobject.Dashboard;
import Pageobject.Landings;

public class Landingrun extends LandonDashboard {

	Landings landing;
	Dashboard dashboard;

	@BeforeMethod
	public void launchBrowser() {
		setUp();
		landing = new Landings(driver);
		dashboard = new Dashboard(driver);
	}

	@Test
	public void verifyLandingFlow() throws InterruptedException {
		landing.EnterMobileNumber("8610237001");
		landing.ClickonStartselling();
		landing.clickpassword();
		landing.enterpassword("261520");
		landing.submitpassword();
		dashboard.popup();
		dashboard.LandingonLMS();

	}
}