package pageObjects;

import org.openqa.selenium.WebDriver;


import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	

	public void clickRadioButtonGenderMale() {
		
		waitForElementClickAble(driver,RegisterPageUI.GENDER_MALE);
		clickToElement(driver,RegisterPageUI.GENDER_MALE);
		
	}

	public void inputFirstName(String firstname) {
		waitForElementVisible(driver,RegisterPageUI.FIRST_NAME);
		sendkeyToElement(driver,RegisterPageUI.FIRST_NAME,firstname);
		
	}
	
	public void inputLastName( String lastname) {
		waitForElementVisible(driver,RegisterPageUI.LAST_NAME);
		sendkeyToElement(driver,RegisterPageUI.LAST_NAME,lastname);
	}

	public void selectDayOfBirth(String day) {
		waitForElementVisible(driver,RegisterPageUI.DAY_OF_BIRTH);
		selectItemInDefaultDropdown(driver,RegisterPageUI.DAY_OF_BIRTH,day);
		
		
	}
	public void selectMonthOfBirth(String month) {
		waitForElementVisible(driver,RegisterPageUI.MONTH_OF_BIRTH);
		selectItemInDefaultDropdown(driver,RegisterPageUI.MONTH_OF_BIRTH,month);
	}

	public void selectYearOfBirth(String year) {
		waitForElementVisible(driver,RegisterPageUI.YEAR_OF_BIRTH);
		selectItemInDefaultDropdown(driver,RegisterPageUI.YEAR_OF_BIRTH,year);
	}

	
	public void inputEmail(String email) {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
		
	}


	public void inputPass(String password) {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
	}

	public void inputConfirmPass(String password) {
		waitForElementVisible(driver,RegisterPageUI.CONFIRMPASS_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRMPASS_TEXTBOX,password);
	}

	public void clickRegisterButton() {
		waitForElementClickAble(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
		
	}

	public boolean isFirstNameEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.FIRST_NAME_EMPTY_MESSAGE);
	}


	public boolean isLastNameEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.LAST_NAME_EMPTY_MESSAGE);
	}


	public boolean isEmailEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EMPTY_MESSAGE);
	}



	public boolean isPasswordEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASS_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.PASS_EMPTY_MESSAGE);
	}
	
	public boolean isConfirmPasswordEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASS_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASS_EMPTY_MESSAGE);
	}



	public boolean isEmailInvalidMessageDisplayed() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_INVALID_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.EMAIL_INVALID_MESSAGE);
	}



	public boolean isPassErrorMessageDisplayed() {
		waitForElementVisible(driver,RegisterPageUI.PASS_ERROR_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.PASS_ERROR_MESSAGE);
	}



	public boolean isConfirmPassErrorMessageDisplayed() {
		waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
	}



	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}



	public boolean isRegisterEmailExistMessageDisplayed() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_EXIST_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.EMAIL_EXIST_MESSAGE);
	}



	public void clickLogoutLink() {
		waitForElementClickAble(driver,RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver,RegisterPageUI.LOGOUT_LINK);
		
	}






}
