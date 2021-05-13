package com.nopcommerces.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
	}
	@Test
	public void TC_01_Register_Empty_Data() {
		
	}
	@Test
	public void TC_02_Invalid_Email() {
		
	}
	@Test
	public void TC_03_Register_() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
