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
import pageObjects.MyAccountPageObject;
import pageObjects.MyHomePageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;

public class User_04_Search {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname,lastname, day,month,year, email,password,category,manufacturer;
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
		category ="Computers";
		manufacturer ="HP";
		
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
	@Test
	public void TC_03_Search_with_empty_data() {
		myHomePage.clickToSearchLink();
		
		searchPage = new SearchPageObject(driver);
		Assert.assertTrue(searchPage.isTitleSearchDisplayed());
		
		searchPage.clickSearchButton(); 
		Assert.assertTrue(searchPage.isEmptyDataErrorMessageDisplayed());
		
		
	}
	@Test
	public void TC_04_Search_with_data_not_exist() {
		searchPage.inputSearchTextbox("xyz");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isDataNotExistErrorMessageDisplayed());
	}
	@Test
	public void TC_05_Search_with_product_name_tuong_doi(){
		searchPage.inputSearchTextbox("Lenovo");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isLenovoThinkpadX1CarbonLaptopDisplayed());
		Assert.assertTrue(searchPage.isLenovoIdeaCentre600AllInOnePCDisplayed());
	}
	@Test
	public void TC_06_Search_with_product_name_tuyet_doi() {
		searchPage.inputSearchTextbox("ThinkPad X1 Carbon");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isLenovoThinkpadX1CarbonLaptopDisplayed());
		
	}
	@Test
	public void TC_07_Advanced_Search_with_Parent_categories() {
		searchPage.inputSearchTextbox("Apple Macbook Pro");
		searchPage.clickAdvancedSearchCheckbox();
		searchPage.selectCategory(category);
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isDataNotExistErrorMessageDisplayed());
		
	}
	@Test
	public void TC_08_Advanced_Search_with_sub_categories() {
		
//		searchPage.inputSearchTextbox("Apple Macbook Pro");
//		
//		searchPage.clickAdvancedSearchCheckbox();
//		searchPage.selectCategory(category);
		searchPage.clickAutomaticallySearchSubCategoriesCheckbox();
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isAppleMacbookPro13inchDisplayed());
	
	}
	@Test
	public void TC_09_Advanced_Search_Incorrect_manufacturer() {
//		searchPage.inputSearchTextbox("Apple Macbook Pro");
//		searchPage.clickAdvancedSearchCheckbox();
//		searchPage.selectCategory(category);
//		searchPage.clickAutomaticallySearchSubCategoriesCheckbox();
		searchPage.selectManufacturer(manufacturer);
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isDataNotExistErrorMessageDisplayed());
	}
	@Test
	public void TC_10_Advanced_Search_correct_manufacturer() {
//		searchPage.inputSearchTextbox("Apple Macbook Pro");
//		searchPage.clickAdvancedSearchCheckbox();
//		searchPage.selectCategory(category);
//		searchPage.clickAutomaticallySearchSubCategoriesCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isAppleMacbookPro13inchDisplayed());
		
	}
	@AfterClass
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
	SearchPageObject searchPage;
}
