package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageNPF;

public class LoginPageTestNPF {
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPageNPF loginpageNPF;
	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.initalize_properties();
		driver = basepage.initialize_driver(prop);
		loginpageNPF = new LoginPageNPF(driver);
		
		}
	
	@Test(priority=1)
	public void verifySingUpLinkTest(){
		Assert.assertTrue(loginpageNPF.verifySignuoLinkDisplayed());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
