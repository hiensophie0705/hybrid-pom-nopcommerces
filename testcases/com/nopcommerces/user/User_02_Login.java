package com.nopcommerces.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyHomePageObject;
import pageObjects.RegisterPageObject;

public class User_02_Login {
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
		password ="123456";
	}
	@Test
	public void TC_01_Register_Completed() {
		homePage.clickRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
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
					
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
				
	}
	
	@Test
	public void TC_02_Login_With_Empty_Data() {
		registerPage.clickLogoutLink();
		homePage = new HomePageObject(driver);
		
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputEmailTextbox("");
		loginPage.inputPasswordTextbox("");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isEmailValidateErrorMessageDisplayed());
	}
	
	@Test
	public void TC_03_Login_With_Invalid_Email() {
		loginPage.inputEmailTextbox("adda");
		loginPage.inputPasswordTextbox(password);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isEmailInvalidErrorMessageDisplayed());
		
	}
	
	@Test
	public void TC_04_Login_With_No_Account_Found() {
		loginPage.inputEmailTextbox("abc@gmail.com");
		loginPage.inputPasswordTextbox(password);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isNoAccountFoundErrorMessageDisplayed());
	}
	  
	@Test
	public void TC_05_Login_With_Email_Registed_And_Pass_Empty() {
		loginPage.inputEmailTextbox("dobaba@gmail.com");
		loginPage.inputPasswordTextbox("");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isPassEmptyErrorMessageDisplayed());
		
	}
	
	@Test
	public void TC_06_Login_With_Email_Registed_And_Pass_Incorrect() {
		loginPage.inputEmailTextbox("dobaba@gmail.com");
		loginPage.inputPasswordTextbox("1231313131");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isPassIncorrectErrorMessageDisplayed());
		
		}
	@Test
	public void TC_07_Login_Success() {
		loginPage.inputEmailTextbox("dobaba@gmail.com");
		loginPage.inputPasswordTextbox(password);
		loginPage.clickLoginButton();
		
		
		myHomePage = new MyHomePageObject(driver);
		Assert.assertTrue(myHomePage.isLogoutButtonDisplayed());
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
	LoginPageObject loginPage;	
	MyHomePageObject myHomePage;
}
