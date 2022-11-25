package com.nopcommerces.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class User_06_Wishlist_Compare_RecentView {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname,lastname, day,month,year, email,password ;
	  
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	public void TC_02_Add_To_Wishlist() {
		myHomePage = new MyHomePageObject(driver);
		
		myHomePage.clickToComputerLink();
		myHomePage.clickToDesktopLink();
		myHomePage.clickDetailProductLenovoIdeaCentre600AllinOnePC();
		myHomePage.clickToAddToWishlistButton();
		
		Assert.assertTrue(myHomePage.isMessageAddedToYourWishlistSuccessDisplayed());
		
		myHomePage.clickToWishlistLink();
		
		Assert.assertTrue(myHomePage.isProductNameLenovoIdeaCentre600AllinOnePCDisplayed());
		
		myHomePage.clickToYourWishlistURLForSharingLink();
		Assert.assertTrue(myHomePage.isTitleWishlistDisplayed());
	}
	@Test
	public void TC_03_Add_Product_To_Cart_From_Wishlist_Page() {
	
		myHomePage.clickToAddToCartCheckbox();
		myHomePage.clickToAddToCartButton();
		
		Assert.assertTrue(myHomePage.isProductShoppingCartDisplayed());
	}
	@Test
	public void TC_04_Remove_product_in_Wishlist_page() {
		myHomePage.clickToWishlistLabel();
		myHomePage.clickToRemoveButton();		
		Assert.assertTrue(myHomePage.isMessageTheWishlistIsEmptyDisplayed());
	}
	@Test
	public void TC_05_Add_product_To_Compare() {
		
		myHomePage.clickToComputerLink();
		myHomePage.clickToDesktopLink();
		
		myHomePage.clickToCompareBuildYourOwnComputerButton();
		Assert.assertTrue(myHomePage.isMessageProductCompareSuccessDisplayed());
		myHomePage.clickToCompareLenovoIdeaCentre600AllInOnePCButton();
		Assert.assertTrue(myHomePage.isMessageProductCompareSuccessDisplayed());
		
		myHomePage.clickToProductCompareLink();
		
		Assert.assertTrue(myHomePage.isRemoveButtonOnProductComparePageDisplayed());
		Assert.assertTrue(myHomePage.isNameProductOnProductComparePageDisplayed());
		Assert.assertTrue(myHomePage.isPriceProductOnProductComparePageDisplayed());
		
		myHomePage.clickToClearListButton();
		Assert.assertTrue(myHomePage.isMessageNoDataCompareProductDisplayed());
		Assert.assertTrue(myHomePage.isRemoveButtonOnProductComparePageUnDisplayed());
		Assert.assertTrue(myHomePage.isNameProductOnProductComparePageUnDisplayed());
		Assert.assertTrue(myHomePage.isPriceProductOnProductComparePageUnDisplayed());
		
		}
	@Test
	public void TC_06_Recently_Viewed_Products() {
	
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
