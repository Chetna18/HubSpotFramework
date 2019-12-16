package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage{
	
	// page factory annotations / page object
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText = "Sign up")
	WebElement signUpLink;

	@FindBy(linkText = "Privacy Policy")
	WebElement privacyPolicy;
	
	//2. create the constructor of Loginpage class and initialize your page objects
	//we are creating a constructor because we need object of this in our test class, to call the const we need driver 
	//we did page factory annotation above, now we will give driver to it
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	//here you can write (driver, this or LoginPage.class). this line says intielments with help of driver and above class ele
		
	}
	//3. page actions/ page library:
	public String getLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifySignuoLinkDisplayed(){
		return signUpLink.isDisplayed();//i got the signuplink element from above
		
	}
	public boolean verifyPrivacyPolicy(){
		return privacyPolicy.isDisplayed();
	}
	
	public HomePage doLogin(String username, String pwd){
		System.out.println("credetials:"+ username+"/"+pwd);
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		TimeUtil.mediumwait();
		return new HomePage(driver);
	}
	
	
	
	

}
