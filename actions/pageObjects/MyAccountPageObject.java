package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commons.BasePage;
import pageUIs.MyAccountPageUI;


public class MyAccountPageObject extends BasePage {
	private WebDriver driver;
	public MyAccountPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
	public void clickToFemale() {
		waitForElementClickAble(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
	}
		
	
	public boolean isTitleMyAccountDisplayed() {
		waitForElementVisible(driver,MyAccountPageUI.TITLE_MY_ACCOUNT);
		return isElementDisplayed(driver,MyAccountPageUI.TITLE_MY_ACCOUNT);
 }
	public void inputUpdateFirstnameTextbox(String updatefirstname) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,MyAccountPageUI.UPDATE_FIRSTNAME_TEXTBOX,updatefirstname);
		
	}
	public void inputUpdateLastnameTextbox(String updatelastname) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_LASTNAME_TEXTBOX);
		sendkeyToElement(driver,MyAccountPageUI.UPDATE_LASTNAME_TEXTBOX,updatelastname);
		
	}
	public void selectUpdateDayOfBirth(String updateday) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_DAY);
		selectItemInDefaultDropdown(driver,MyAccountPageUI.UPDATE_DAY,updateday);
	}
	public void selectUpdateMonthOfBirth(String updatemonth) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_MONTH);
		selectItemInDefaultDropdown(driver,MyAccountPageUI.UPDATE_MONTH,updatemonth);
	}
	public void selectUpdateYearOfBirth(String updateyear) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_YEAR);
		selectItemInDefaultDropdown(driver,MyAccountPageUI.UPDATE_YEAR,updateyear);
	}
	public void inputUpdateEmail(String updateemail) {
		waitForElementVisible(driver,MyAccountPageUI.UPDATE_EMAIL);
		sendkeyToElement(driver, MyAccountPageUI.UPDATE_EMAIL,updateemail);
		
	}
	public void clickSaveButton() {
		waitForElementClickAble(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}
	public String getValueUpdateFirstnameSuccess(String updatefirstname) {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.UPDATE_FIRSTNAME_TEXTBOX, updatefirstname);
	}

	public String getValueUpdateLastnameSuccess(String updatelastname) {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_LASTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.UPDATE_LASTNAME_TEXTBOX, updatelastname);
	}
	public String getSelectUpdateDaySuccess() {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_DAY);
		return getFisrtSelectedItemDefaultDropdown(driver, MyAccountPageUI.UPDATE_DAY);
	}
	public String getSelectUpdateMonthSuccess() {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_MONTH);
		return getFisrtSelectedItemDefaultDropdown(driver, MyAccountPageUI.UPDATE_MONTH);
	}
	public String getSelectUpdateYearSuccess() {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_YEAR);
		return getFisrtSelectedItemDefaultDropdown(driver, MyAccountPageUI.UPDATE_YEAR);
	}
	public String getValueUpdateEmailSuccess(String updateemail) {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_EMAIL);
		return getAttributeValue(driver, MyAccountPageUI.UPDATE_EMAIL,updateemail);
	}
	public void clickLogoutLink() {
		waitForElementClickAble(driver,MyAccountPageUI.LOGOUT_LINK);
		clickToElementByJS(driver,MyAccountPageUI.LOGOUT_LINK);
		
	}
	public void clickAddressesLink() {
		waitForElementClickAble(driver, MyAccountPageUI.ADDRESSES_LINK);
		clickToElement(driver,MyAccountPageUI.ADDRESSES_LINK);
		
	}
	public boolean isTitleMyAccountAddressesDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.TITLE_ADDRESSES);
		return isElementDisplayed(driver,MyAccountPageUI.TITLE_ADDRESSES);
		
	}
	public void clickAddNewButton() {
		waitForElementClickAble(driver, MyAccountPageUI.ADD_NEW_BUTTON);
		clickToElement(driver,MyAccountPageUI.ADD_NEW_BUTTON);
		
	}
	public void inputFirstNameAddress(String addressFirstname) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_FIRSTNAME);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_FIRSTNAME,addressFirstname);
		
	}
	public void inputLastNameAddress(String addressLastname) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_LASTNAME);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_LASTNAME,addressLastname);
		
	}
	public void inputEmailAddress(String addressEmail) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_EMAIL);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_EMAIL,addressEmail);
		
	}
	public void selectCountry(String addressCountry) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_COUNTRY);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.ADDRESSES_COUNTRY, addressCountry);
	}

	public void selectProvince(String addressProvince) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_PROVINCE);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.ADDRESSES_PROVINCE, addressProvince);
		
	}
	public void inputCityTextbox(String addressCity) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_CITY);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_CITY,addressCity);
		
	}
	public void inputAddress01(String addressAddress01) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_ADDRESS01);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_ADDRESS01,addressAddress01);
		
	}
	public void inputAddress02(String addressAddress02) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_ADDRESS02);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_ADDRESS02,addressAddress02);
		
	}
	public void inputZip(String addressZip) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_ZIP_TEXTBOX);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_ZIP_TEXTBOX,addressZip);
		
	}
	public void inputPhoneNumberTextbox(String addressPhonenumber) {
		waitForElementVisible(driver,MyAccountPageUI.ADDRESSES_PHONE_NUMBER);
		sendkeyToElement(driver,MyAccountPageUI.ADDRESSES_PHONE_NUMBER, addressPhonenumber);
		
	}
	public void clickSaveNewAddressButton() {
		waitForElementClickAble(driver, MyAccountPageUI.SAVE_NEW_ADDRESS_BUTTON);
		clickToElement(driver,MyAccountPageUI.SAVE_NEW_ADDRESS_BUTTON);
		
	}
	public String getEmailAddress() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_ADDRESSES);
		return getElementText(driver, MyAccountPageUI.EMAIL_ADDRESSES);
}
	public String getPhoneAddress() {
		waitForElementVisible(driver, MyAccountPageUI.PHONE_ADDRESSES);
		return getElementText(driver, MyAccountPageUI.PHONE_ADDRESSES);
	}
	public String getAddress01Address() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS01_ADDRESSES);
		return getElementText(driver, MyAccountPageUI.ADDRESS01_ADDRESSES);
	}
	public String getAddress02Address() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS02_ADDRESSES);
		return getElementText(driver, MyAccountPageUI.ADDRESS02_ADDRESSES);
	}
	public String getCountryAddress() {
		waitForElementVisible(driver, MyAccountPageUI.COUNTRY_ADDRESSES);
		return getElementText(driver, MyAccountPageUI.COUNTRY_ADDRESSES);
	}
	public void clickChangePasswordLink() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		
	}
	public boolean isTitleMyAccountChangePasswordDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.TITLE_CHANGE_PASS);
		return isElementDisplayed(driver, MyAccountPageUI.TITLE_CHANGE_PASS);
		
		
	}
	public void inputOldPasswordTextbox(String password) {
		waitForElementVisible(driver, MyAccountPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public void inputNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newPassword);		
	}
	public void imputConfirmPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);
		
	}
	public void clickCloseMessageButton() {
		waitForElementVisible(driver, MyAccountPageUI.CLOSE_MESSAGE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CLOSE_MESSAGE_BUTTON);
		
	}
	public boolean isChangePasswordMessageSuccessDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASS_MESSAGE_SUCCESS);
		return isElementDisplayed(driver, MyAccountPageUI.CHANGE_PASS_MESSAGE_SUCCESS);
		
	}
	public void clickChangePasswordButton() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		
	}}
