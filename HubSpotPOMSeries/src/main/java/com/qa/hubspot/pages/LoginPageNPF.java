package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;

public class LoginPageNPF extends BasePage {
	ElementActions elementActions;
	
	//1. define locator; page Objects but without page factory
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	
	public  LoginPageNPF (WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);//this is from elementaction class
		}
	//page actions
	public String getLoginPageTitle(){
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
	}
		
	public boolean verifySignuoLinkDisplayed(){
		return elementActions.elementIsDisplayed(signUpLink);
			}
	public HomePage doLogin(String username, String Password){
		System.out.println("credetials:"+ username+"/"+password);
		elementActions.elementSendKeys(emailID,username );
		elementActions.elementSendKeys(password, Password);
		elementActions.elementClick(loginButton);
		return new HomePage(driver);
	}
	
	
	
	
	
	

}
