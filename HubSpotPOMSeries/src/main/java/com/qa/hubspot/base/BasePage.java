package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author chetn
 *
 */

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method is used to is used to initialize the Webdriver
	 * @param prop
	 * @return driver
	 */
	
	public WebDriver initialize_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			System.out.println("Browser"+browserName+"is not defined in properties file, please give the correct browser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumwait();
		return driver;
		
			
		}
	/**
	 * This method is used to initialize the properties and it will return properties reference
	 * @return prop
	 */
	
	public Properties initalize_properties(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream ("C:\\Users\\chetn\\workspace\\HubSpotPOMSeries\\"
					+ "src\\main\\java\\com\\qa\\hubspot\\configration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
		
		
	}
	
	
	
	
	
	
	
	
	

}
