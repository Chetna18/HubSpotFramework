package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
@Listeners(pdfListener.class)

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.initalize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title =homepage.getHomePageTilte();
		System.out.println("home page title is :"+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		Assert.assertTrue(homepage.verifyHomePageHeader());
		Assert.assertEquals(homepage.getHomePageHeaderText(),Constants.HOME_PAGE_HEAER);
	}
	@Test(priority=3)
	public void verifyHomepageTeamActivityTest(){
		Assert.assertTrue(homepage.verifyHomepageTeamActivity());
		Assert.assertEquals(homepage.verifyHomepageTeamActivityText(),Constants.HOME_PAGE_LINK);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
