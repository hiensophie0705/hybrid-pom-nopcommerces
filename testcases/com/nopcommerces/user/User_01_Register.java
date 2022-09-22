package com.nopcommerces.user;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class User_01_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname,lastname, day,month,year, email,password ;
	  
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		firstname = "do";
		lastname = "hien";
		day = "7";
		month = "May";
		year = "1997";
		email = generateEmail();
		password = "123456";
	}
	@Test
	public void TC_01_Register_Empty_Data() {
		
		homePage.clickRegisterLink();	
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName("");
		registerPage.inputLastName("");
		registerPage.inputEmail("");
		registerPage.inputPass("");
		registerPage.inputConfirmPass("");
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isFirstNameEmptyMessageDisplayed());
		Assert.assertTrue(registerPage.isLastNameEmptyMessageDisplayed());
		Assert.assertTrue(registerPage.isEmailEmptyMessageDisplayed());
		Assert.assertTrue(registerPage.isPasswordEmptyMessageDisplayed());
		
		
		
	}
	@Test
	public void TC_02_Invalid_Email() {
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName(firstname);
		registerPage.inputLastName(lastname);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.inputEmail("dadada");
		registerPage.inputPass(password);
		registerPage.inputConfirmPass(password);
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.isEmailInvalidMessageDisplayed(),"");
		
	}
	
	@Test
	public void TC_03_Register_Pass_at_least_6_characters() {
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName(firstname);
		registerPage.inputLastName(lastname);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.inputEmail(email);
		registerPage.inputPass("12345");
		registerPage.inputConfirmPass("12345");
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isPassErrorMessageDisplayed());
		
		
	}
	@Test
	public void TC_04_Register_Pass_And_ConfirmPass_Do_Not_Match() {
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName(firstname);
		registerPage.inputLastName(lastname);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.inputEmail(email);
		registerPage.inputPass("123456");
		registerPage.inputConfirmPass("1234567");
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isConfirmPassErrorMessageDisplayed());
	
		
	}
	
	@Test
	public void TC_05_Register_Email_Existed() {
		
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName(firstname);
		registerPage.inputLastName(lastname);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.inputEmail("dobaba@gmail.com");
		registerPage.inputPass(password);
		registerPage.inputConfirmPass(password);
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isRegisterEmailExistMessageDisplayed());	
	}
	@Test
	public void TC_06_Register_Completed() {
		registerPage.clickRadioButtonGenderMale();
		registerPage.inputFirstName(firstname);
		registerPage.inputLastName(lastname);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.inputEmail(email);
		registerPage.inputPass(password);
		registerPage.inputConfirmPass(password);
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public String generateEmail() {
		Random rand = new Random();
		return "dobaba" + rand.nextInt(9999) + "@gmail.com";
	}
	HomePageObject homePage;
	RegisterPageObject registerPage;
}
