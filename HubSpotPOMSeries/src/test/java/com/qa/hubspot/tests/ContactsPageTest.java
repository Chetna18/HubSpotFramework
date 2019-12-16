package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ExcelUtil;

@Listeners(pdfListener.class)
public class ContactsPageTest {
	
	

	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.initalize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactspage = homepage.goToContactPage();
		}
	@DataProvider(name="getContactsDate")
	public Object[][] getContactsTestData(){
		Object contactsData[][] = ExcelUtil.getTestDate("Contacts");
		return contactsData;
		
	}
	
	@Test(dataProvider="getContactsDate")
	public void createNewContactTest(String Emailid, String FirstName, String LastName, String JobTitle){
	contactspage.createNewContact(Emailid,FirstName,LastName,JobTitle);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
