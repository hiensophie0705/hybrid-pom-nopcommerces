package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;


public class LoginPageObject  extends BasePage {

		WebDriver driver;
		
		public LoginPageObject(WebDriver _driver) {
			driver = _driver;
		}


	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,email);
		
	}		
	

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
		
	}	



	public void clickLoginButton() {
		waitForElementClickAble(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		
	}


	public boolean isEmailValidateErrorMessageDisplayed() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_VALIDATE_ERROR_MESSAGE);
		return isElementDisplayed(driver,LoginPageUI.EMAIL_VALIDATE_ERROR_MESSAGE);
	}


	public boolean isEmailInvalidErrorMessageDisplayed() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		return isElementDisplayed(driver,LoginPageUI.EMAIL_INVALID_ERROR_MESSAGE);
	}


	public boolean isNoAccountFoundErrorMessageDisplayed() {
		waitForElementVisible(driver,LoginPageUI.NO_ACCOUNT_FOUND_ERROR_MESSAGE);
		return isElementDisplayed(driver,LoginPageUI.NO_ACCOUNT_FOUND_ERROR_MESSAGE);
	}


	public boolean isPassEmptyErrorMessageDisplayed() {
		waitForElementVisible(driver,LoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver,LoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
	}


	public boolean isPassIncorrectErrorMessageDisplayed() {
		waitForElementVisible(driver,LoginPageUI.PASS_INCORRECT_ERROR_MESSAGE);
		return isElementDisplayed(driver,LoginPageUI.PASS_INCORRECT_ERROR_MESSAGE);
	}


	


	
}
