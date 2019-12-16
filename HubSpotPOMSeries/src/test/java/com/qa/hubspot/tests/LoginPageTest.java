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
import com.qa.hubspot.pages.LoginPage;

@Listeners(pdfListener.class)
public class LoginPageTest {
	
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.initalize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		
		}
	
	@Test(priority=1)
	public void verifyLoginpageTitleTest(){
		String title =loginpage.getLoginPageTitle();
		System.out.println("The login page title is:"+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginpage.verifySignuoLinkDisplayed()); 
	}
	
	@Test(priority=3)
	public void loginTestWithCorrectCredentials(){
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=4)
	public void verifyprivacyPolicy(){
		Assert.assertTrue(loginpage.verifyPrivacyPolicy());
	}
	
	@Test(priority=5)
	public void loginTestWithInCorrectCredentials(){
		loginpage.doLogin("test@123.com", "test123");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
