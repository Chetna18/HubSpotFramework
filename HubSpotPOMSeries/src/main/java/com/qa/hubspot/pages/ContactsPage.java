package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage  {
	
	@FindBy(xpath="//span//span[text()='Create contact']")
	WebElement CreateContactBtn;
	
	@FindBy(xpath="//html/body/div[5]/div/div/div/div/footer/div/div/div/div/ul/li[1]/button")
	WebElement createContactSecondBtn;
	
	@FindBy(xpath="//*[@id='UIFormControl-7']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='UIFormControl-8']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='UIFormControl-10']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='UIFormControl-14']")
	WebElement jobtitle;
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void createNewContact(String Emailid, String FirstName, String LastName, String JobTitle){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(CreateContactBtn));
		CreateContactBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(Emailid);
	
		wait.until(ExpectedConditions.elementToBeClickable(firstname));
		firstname.sendKeys(FirstName);
	
		wait.until(ExpectedConditions.elementToBeClickable(lastname));
		lastname.sendKeys(LastName);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobtitle));
		jobtitle.sendKeys(JobTitle);
																		

		//wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		//createContactSecondBtn.click();
	
	
		
		
		
	}
	
	
	
	
	
	
	
	

}
