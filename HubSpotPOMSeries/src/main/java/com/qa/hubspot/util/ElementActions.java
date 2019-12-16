package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementActions extends BasePage{
	
	public  ElementActions(WebDriver driver){// here i will call the constructor and pass the driver
		this.driver = driver;
		}
	/**
	 * This method is used to create the WebElement on the basis of given By locator
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator){//**how would you do error handling in Selenium framework?
		WebElement element = null;// I would use try catch block with proper notifications and write my own message 
		try{
	    element = driver.findElement(locator);
		}catch(Exception e){
			System.out.println("Some exception occured while creating webelement"+ locator);
		}
		return element;
	}
	
	public void waitForElementPresent(By locator){// this method is used on locator not on webElement
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public void waitForTitlePresent(String title){// this method is used on locator not on webElement
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public boolean elementIsDisplayed(By locator){
		waitForElementPresent(locator);
		return getElement(locator).isDisplayed();//getElement is from above method
	}
	public void elementClick(By locator){
		getElement(locator).click();// just a click, no need for return
	}
	
	public void elementSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	public String getPageTitle(){
		String title = null;
		try{
		title = driver.getTitle();
		}catch(Exception e){
			System.out.println("some exception occurred while getting the title"+ title);
		}
		return title;
	}
}
