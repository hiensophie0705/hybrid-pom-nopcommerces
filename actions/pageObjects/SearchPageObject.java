package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage {
	
		private WebDriver driver;
		public SearchPageObject(WebDriver _driver) {
			driver = _driver;
			
		}
		public boolean isTitleSearchDisplayed() {
			waitForElementVisible(driver, SearchPageUI.TITLE_SEARCH);
			return isElementDisplayed(driver, SearchPageUI.TITLE_SEARCH);
		}
		public void clickSearchButton() {
			waitForElementClickAble(driver, SearchPageUI.SEARCH_BUTTON);
			clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
			
		}
		public boolean isEmptyDataErrorMessageDisplayed() {
			waitForElementVisible(driver, SearchPageUI.EMTY_DATA_ERROR_MESSAGE);
			return isElementDisplayed(driver, SearchPageUI.EMTY_DATA_ERROR_MESSAGE);
		}
		public void inputSearchTextbox(String keySearch) {
			waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
			sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, keySearch);
			
		}
		public boolean isDataNotExistErrorMessageDisplayed() {
			waitForElementVisible(driver, SearchPageUI.DATA_NOT_EXIST_ERROR_MESSAGE);
			return isElementDisplayed(driver, SearchPageUI.DATA_NOT_EXIST_ERROR_MESSAGE);
		}
		public boolean isLenovoThinkpadX1CarbonLaptopDisplayed() {
			waitForElementVisible(driver, SearchPageUI.LENOVO_THINKPADX1_CARBON_LAPTOP);
			return isElementDisplayed(driver, SearchPageUI.LENOVO_THINKPADX1_CARBON_LAPTOP);
		}
		public boolean isLenovoIdeaCentre600AllInOnePCDisplayed() {
			waitForElementVisible(driver, SearchPageUI.LENOVO_IDEA_CENTRE600_ALL_IN_ONE_PC);
			return isElementDisplayed(driver, SearchPageUI.LENOVO_IDEA_CENTRE600_ALL_IN_ONE_PC);
		}
		public void clickAdvancedSearchCheckbox() {
			waitForElementClickAble(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
			clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
			
		}
		public void selectCategory(String category) {
			waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
			selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN,category);
		}
		public void clickAutomaticallySearchSubCategoriesCheckbox() {
			waitForElementVisible(driver, SearchPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
			clickToElement(driver, SearchPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
		}
		public boolean isAppleMacbookPro13inchDisplayed() {
			waitForElementVisible(driver, SearchPageUI.APPLE_MACBOOK_PRO_13iNCH);
			return isElementDisplayed(driver, SearchPageUI.APPLE_MACBOOK_PRO_13iNCH);
		}
		public void selectManufacturer(String manufacturer) {
			waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
			selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
		}
		}

