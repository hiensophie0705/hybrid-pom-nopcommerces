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

public class User_03_My_Account {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstname,lastname, day,month,year, email,password,newPassword,
	updatefirstname,updatelastname,updateday,updatemonth,updateyear,updateemail ;
	String addressFirstname,addressLastname, addressEmail, addressCountry ,addressProvince, addressCity,addressAddress01,addressAddress02,addressZip,addressPhonenumber;
	String reviewTitle, reviewText,desktopItem;
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
		newPassword = "1234567";
		updatefirstname ="dobaba";
		updatelastname="do";
		updateday ="4";
		updatemonth ="March";
		updateyear ="1997";
		updateemail = generateEmail2();
		addressFirstname ="sam sam";
		addressLastname ="tu trinh";
		addressEmail = generateEmail3();
		addressCountry = "United States";
		addressProvince = "Alaska";
		addressCity ="Hà nội";
		addressAddress01 ="Phú Diễn- Bắc Từ Liêm_HN";
		addressAddress02 ="Hồ Tùng Mậu- Cầu Giấy- HN";
		addressZip ="000000";
		addressPhonenumber ="3895676764";
		reviewTitle ="review product";
		reviewText ="good";
		desktopItem ="Desktops ";
				
		
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
	public void TC_03_Update_CustomerInfo() {
		myHomePage.clickMyAccountLink();
		
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.isTitleMyAccountDisplayed();
		myAccountPage.clickToFemale();
		
		myAccountPage.inputUpdateFirstnameTextbox(updatefirstname);
		myAccountPage.inputUpdateLastnameTextbox(updatelastname);
		myAccountPage.selectUpdateDayOfBirth(updateday);
		myAccountPage.selectUpdateMonthOfBirth(updatemonth);
		myAccountPage.selectUpdateYearOfBirth(updateyear);
		myAccountPage.inputUpdateEmail(updateemail);
		myAccountPage.clickSaveButton();
		
		//Assert.assertEquals(myAccountPage.getValueUpdateFirstnameSuccess("dobaba"), updatefirstname);
		//Assert.assertEquals(myAccountPage.getValueUpdateLastnameSuccess("do"), updatelastname);
		Assert.assertEquals(myAccountPage.getSelectUpdateDaySuccess(), updateday);
		Assert.assertEquals(myAccountPage.getSelectUpdateMonthSuccess(), updatemonth);
		Assert.assertEquals(myAccountPage.getSelectUpdateYearSuccess(), updateyear);
		//Assert.assertEquals(myAccountPage.getValueUpdateEmailSuccess("updateemail"), updateemail);
	}
	

	@Test
	public void TC_04_Update_Addresses() {
		myAccountPage.clickAddressesLink();
		myAccountPage.isTitleMyAccountAddressesDisplayed();
		myAccountPage.clickAddNewButton();
		myAccountPage.inputFirstNameAddress(addressFirstname);
		myAccountPage.inputLastNameAddress(addressLastname);
		myAccountPage.inputEmailAddress(addressEmail);
		myAccountPage.selectCountry(addressCountry);
		myAccountPage.selectProvince(addressProvince);
		myAccountPage.inputCityTextbox(addressCity);
		myAccountPage.inputAddress01(addressAddress01);
		myAccountPage.inputAddress02(addressAddress02);
		myAccountPage.inputZip(addressZip);
		myAccountPage.inputPhoneNumberTextbox(addressPhonenumber);
		myAccountPage.clickSaveNewAddressButton();
		
		
 		Assert.assertEquals(myAccountPage.getEmailAddress(), "Email: " + addressEmail);
		Assert.assertEquals(myAccountPage.getPhoneAddress(), "Phone number: " + addressPhonenumber);
		Assert.assertEquals(myAccountPage.getAddress01Address(), addressAddress01);
		Assert.assertEquals(myAccountPage.getAddress02Address(), addressAddress02);
		Assert.assertEquals(myAccountPage.getCountryAddress(), addressCountry);
		
		
	}
	
	
	@Test
	public void TC_05_Change_Password() {
		myAccountPage.clickChangePasswordLink();
		myAccountPage.isTitleMyAccountChangePasswordDisplayed();
	
		myAccountPage.inputOldPasswordTextbox(password);
		myAccountPage.inputNewPasswordTextbox(newPassword);
		myAccountPage.imputConfirmPasswordTextbox(newPassword);
		
		myAccountPage.clickChangePasswordButton();
		
		myAccountPage.isChangePasswordMessageSuccessDisplayed();
		myAccountPage.clickCloseMessageButton();	
		myAccountPage.clickLogoutLink();
		
		myHomePage = new MyHomePageObject(driver);
		myHomePage.clickLoginLink();
	
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(updateemail);
		loginPage.inputPasswordTextbox(password);
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isPassIncorrectErrorMessageDisplayed());

		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(updateemail);
		loginPage.inputPasswordTextbox(newPassword);
		loginPage.clickLoginButton();
		myHomePage = new MyHomePageObject(driver);
		Assert.assertTrue(myHomePage.isLogoutButtonDisplayed());
		
		
	}
	@Test
	public void TC_06_My_Product_Review() {
		myHomePage.clickToComputerLink();
		myHomePage.clickToDesktopLink();
		myHomePage.clickDetailProductBuildYourOwnComputer();
		myHomePage.clickAddYourReviewLink();
		myHomePage.inputReviewTitleTextbox(reviewTitle);
		myHomePage.inputReviewTextTextbox(reviewText);
		myHomePage.clickRatingRadioButton();
		myHomePage.clickSubmitReviewButton();
		
		Assert.assertTrue(myHomePage.isSuccessfullyAddedMessageDisplayed());
		
		myHomePage.clickMyAccountLink();
		myHomePage.clickMyProductReviewsLink();
		
		Assert.assertTrue(myHomePage.isMyProductReviewsTitleDisplayed());
		Assert.assertTrue(myHomePage.isReviewTextDisplayed());
		Assert.assertTrue(myHomePage.isReviewInforDisplayed());
		Assert.assertTrue(myHomePage.isReviewRatingDisplayed());


		
	}
	@AfterClass
	public void afterClass() {
		
	}
	public String generateEmail() {
	Random rand = new Random();
	return "dobaba" + rand.nextInt(9999) + "@gmail.com";
	}
	
	public String generateEmail2() {
		Random rand = new Random();
		return "dohien" + rand.nextInt(9999) + "@gmail.com";
	}
	public String generateEmail3() {
		Random rand = new Random();
		return "samsam" + rand.nextInt(9999) + "@gmail.com";
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;	
	MyHomePageObject myHomePage;
	MyAccountPageObject myAccountPage;
}
	
	