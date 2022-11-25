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

public class User_05_Order_Product {
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
		registerPage.inputEmail(email);
		registerPage.inputPass(password);
		registerPage.inputConfirmPass(password);
		registerPage.clickRegisterButton();
					
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	@Test
	public void TC_02_Sort_With_Name_A_To_Z() {
		myHomePage = new MyHomePageObject(driver);
		myHomePage.clickToComputerLink();
		myHomePage.clickToNotebookslink();
		
		myHomePage.selectItemInProductSortDropdown("Name: A to Z");
		myHomePage.sleepInSecond(3);
		
		Assert.assertTrue(myHomePage.isProductNameSortByAscending());
		
	}
	@Test
	public void TC_03_Sort_With_Name_Z_To_A() {
		myHomePage.selectItemInProductSortDropdown("Name: Z to A");
		myHomePage.sleepInSecond(3);
		
		Assert.assertTrue(myHomePage.isProductNameSortByDescending());
	}
	@Test
	public void TC_04_Sort_With_Price_Low_To_High() {
		myHomePage.selectItemInProductSortDropdown("Price: Low to High");
		myHomePage.sleepInSecond(3);
		
		Assert.assertTrue(myHomePage.isProductPriceSortByAscending());
	}
	@Test
	public void TC_05_Sort_With_Price_High_To_Low() {
		myHomePage.selectItemInProductSortDropdown("Price: High to Low");
		myHomePage.sleepInSecond(3);
		
		Assert.assertTrue(myHomePage.isProductPriceSortByDescending());
	}
	
	@Test
	public void TC_06_Displayed_With_3_Products_A_Page() {
		myHomePage.selectItemInProductPageSizeDropdown("3");
		Assert.assertTrue(myHomePage.isThreeProductsWithAPageDisplayed());
		
		
		
	}
	@Test
	public void TC_07_Displayed_With_6_Products_A_Page() {
		
		//myHomePage.selectItemInProductPageSizeDropdown("6");
		
		//Verify chỉ có đúng 6 hoặc nhỏ hơn 6 sản phẩm
		
		//Verify không xuất hiện paging
	}
	@Test
	public void TC_08_Displayed_With_9_Products_A_Page() {
		
		//Verify chỉ có đúng 9 hoặc nhỏ hơn 9 sản phẩm
		
		//Verify không xuất hiện paging'
		
		
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
}
