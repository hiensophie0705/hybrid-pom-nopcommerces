package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;
import pageUIs.MyHomePageUI;

public class MyHomePageObject extends BasePage {
	WebDriver driver;
	
	public MyHomePageObject(WebDriver _driver) {
		driver = _driver;
	}

	public boolean isLogoutButtonDisplayed() {
		waitForElementVisible(driver,MyHomePageUI.LOGOUT_BUTTON);
		return isElementDisplayed(driver,MyHomePageUI.LOGOUT_BUTTON);
 }

	public void clickMyAccountLink() {
		waitForElementClickAble(driver, MyHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, MyHomePageUI.MY_ACCOUNT_LINK);
	}

	public void clickLoginLink() {
		waitForElementClickAble(driver, MyHomePageUI.LOGIN_LINK);
		clickToElement(driver, MyHomePageUI.LOGIN_LINK);
	}
	public void clickToComputerLink() {
		waitForElementClickAble(driver, MyHomePageUI.COMPUTER_LINK);
		clickToElement(driver, MyHomePageUI.COMPUTER_LINK);
	}
	public void clickToDesktopLink() {
		waitForElementVisible(driver, MyHomePageUI.DESKTOP_LINK);
		clickToElement(driver, MyHomePageUI.DESKTOP_LINK);
			
	}

	public void clickDetailProductBuildYourOwnComputer() {
		waitForElementClickAble(driver, MyHomePageUI.PICTURE_PRODUCT);
		clickToElement(driver, MyHomePageUI.PICTURE_PRODUCT);
		
	}

	public void clickAddYourReviewLink() {
		waitForElementClickAble(driver, MyHomePageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver,MyHomePageUI.ADD_YOUR_REVIEW_LINK);
		
	}

	public void inputReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, MyHomePageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, MyHomePageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
		
	}

	public void inputReviewTextTextbox(String reviewText) {
		waitForElementVisible(driver, MyHomePageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, MyHomePageUI.REVIEW_TEXT_TEXTBOX, reviewText);
		
	}

	public void clickRatingRadioButton() {
		waitForElementClickAble(driver, MyHomePageUI.RATING_RADIO_BUTTON);
		clickToElement(driver, MyHomePageUI.RATING_RADIO_BUTTON);
		
	}

	public void clickSubmitReviewButton() {
		waitForElementClickAble(driver, MyHomePageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, MyHomePageUI.SUBMIT_REVIEW_BUTTON);
		
	}

	public boolean isSuccessfullyAddedMessageDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.SUCCESSFULLY_ADDED_MESSAGE);
		return isElementDisplayed(driver, MyHomePageUI.SUCCESSFULLY_ADDED_MESSAGE);
	}

	public void clickMyProductReviewsLink() {
		waitForElementClickAble(driver, MyHomePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyHomePageUI.MY_PRODUCT_REVIEW_LINK);
		
	}

	public boolean isMyProductReviewsTitleDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.MY_PRODUCT_REVIEW_TITLE);
		return isElementDisplayed(driver,MyHomePageUI.MY_PRODUCT_REVIEW_TITLE);
	}

	public boolean isReviewTextDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.REVIEW_TEXT);
		return isElementDisplayed(driver,MyHomePageUI.REVIEW_TEXT);
	}

	public boolean isReviewInforDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.REVIEW_INFOR);
		return isElementDisplayed(driver,MyHomePageUI.REVIEW_INFOR);
	}

	public boolean isReviewRatingDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.REVIEW_RATING);
		return isElementDisplayed(driver,MyHomePageUI.REVIEW_RATING);
		
	}

	
}
