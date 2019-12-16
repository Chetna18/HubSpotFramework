package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage {
	
	//1 page factory
	
	@FindBy(xpath = "//h1[@class='private-page__title']")
	WebElement homepageHeader;
	
	@FindBy(xpath="//span[@class='private-truncated-string__inner']")
	WebElement TeamActivity;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement parentContactMenu;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement childContactMenu;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//page action
	
	public String getHomePageTilte(){
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText(){
		return homepageHeader.getText();
	}
	public boolean verifyHomePageHeader(){
		return homepageHeader.isDisplayed();
	}
	
	public String verifyHomepageTeamActivityText(){
		return TeamActivity.getText();
	}
	
	public boolean verifyHomepageTeamActivity(){
		return TeamActivity.isDisplayed();
	}
	public void clickonContacts(){
		parentContactMenu.click();
		TimeUtil.mediumwait();
		childContactMenu.click();
	}
	public ContactsPage goToContactPage(){
		clickonContacts();
		return new ContactsPage(driver);
		
	}

}
