package Testrun;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LandonDashboard;
import Pageobject.Dashboard;
import Pageobject.LMS;
import Pageobject.Landings;
import Pageobject.Menu;

public class Landingrun extends LandonDashboard {

	Landings landing;
	Dashboard dashboard;
	LMS lms;
	Menu menu;
	

	@BeforeClass
	public void launchBrowser() {
		setUp();
		landing = new Landings(driver, waitUtils);
		dashboard = new Dashboard(driver, waitUtils);
		lms = new LMS(driver, waitUtils);
		menu = new Menu(driver, waitUtils);
		
	}

	@Test(priority = 1)
	public void verifyLandingFlow() throws InterruptedException {
		landing.enterMobileNumber("8610237001");
		landing.clickOnStartSelling();
		landing.clickPassword();
		landing.enterPassword("261520");
		landing.submitPassword();

	}

	@Test(priority = 2)
	public void LMS() throws InterruptedException {
		dashboard.LMSclick();
	}

	@Test(priority = 3)
	public void Menu() throws InterruptedException {
		//menu.AddContact("Kiran", "9876543210", "QA Engineer");
		menu.HideContact();
		menu.BlockContact();
		menu.SupportandInformation();
		menu.HelpVideos();
		menu.PerformanceReports();
		menu.ImportExportLeads();
		

	}
	
	

	//@AfterClass
	//public void closebrowser() {
		//tearDown();

	}

