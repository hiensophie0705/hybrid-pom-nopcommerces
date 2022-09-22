package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;


public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
	}
	public void clickRegisterLink() {
		waitForElementClickAble(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
		
	}
	public void clickLoginLink() {
		waitForElementClickAble(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
		
	}
	
	
	
	
	
}
