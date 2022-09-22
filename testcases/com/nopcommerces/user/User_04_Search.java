package com.nopcommerces.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyHomePageObject;
import pageObjects.RegisterPageObject;

public class User_04_Search {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname,lastname, day,month,year, email,password;
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
		registerPage.inputEmail(email);
		registerPage.inputPass(password);
		registerPage.inputConfirmPass(password);
		registerPage.clickRegisterButton();
					
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
				
	}
	@Test
	public void TC_02_Login_Success() {
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickLogoutLink();
		
		myHomePage = new MyHomePageObject(driver);
		
		myHomePage.clickLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(email);
		loginPage.inputPasswordTextbox(password);
		loginPage.clickLoginButton();
		
		
		myHomePage = new MyHomePageObject(driver);
		Assert.assertTrue(myHomePage.isLogoutButtonDisplayed());
	}
	public void TC_01_Search_with_empty_data() {
		
	}
	
	public void TC_02_Search_with_data_not_exist() {
		
	}
	public void TC_03_Search_with_product_name_tuong_doi(){
		
	}
	public void TC_04_Search_with_product_name_tuyet_doi() {
		
	}

	public void TC_05_Advanced_Search_with_Parent_categories() {
		
	}
	public void TC_06_Advanced_Search_with_sub_categories() {
		
	}
	public void TC_07_Advanced_Search_Incorrect_manufacturer() {
		
	}
	public void TC_08_Advanced_Search_correct_manufacturer() {

	}
	public void afterClass() {
		
	}
	public String generateEmail() {
	Random rand = new Random();
	return "dobaba" + rand.nextInt(9999) + "@gmail.com";
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;	
	MyHomePageObject myHomePage;
	MyAccountPageObject myAccountPage;
}
