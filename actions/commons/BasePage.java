package commons;

import java.util.Collections;
import java.util.List;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
//là tầng dành riêng để build ra common function nào đó(class hay package nào đó)
	//Action:click /open/ sendkey/select/.. -->void
	public void openPageUrl(WebDriver driver,String pageUrl) {
		driver.get(pageUrl);
	}
	//Verify: getTitle/ getUrl/text/attribute/css/displayed -->String
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
		}
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver,longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}
	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}
	public void sendkeyToAlert(WebDriver driver,String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}
	public String getTextAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}
	public void switchToWindowByID(WebDriver driver,String parentID) {
		Set<String> allWindows= driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows: allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if(currentWin.equals(title)) {
				break;
			}
		}
	}
	public void closeAllWindowsWithoutParent(WebDriver driver,String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if(!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	
	
	
	
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getListWebElements(WebDriver driver,String locator){
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) { 
		waitForElementClickAble(driver, locator).click();
		
	}

	public void sendkeyToElement(WebDriver driver,String locator,String value) {
		getWebElement(driver,locator).clear();
		getWebElement(driver,locator).sendKeys(value);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		select = new Select(getWebElement(driver,locator));
		select.selectByVisibleText(itemText);
		
	}
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver,locator));
		return select.isMultiple();
	}
	
	public String getFisrtSelectedItemDefaultDropdown(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver,locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectItemInCustomDropdown(WebDriver driver,String parentLocator,String childItemLocator,String expectedItem) {
		getWebElement(driver,parentLocator).click();
		sleepInSecond(1);
		
		explicitWait = new WebDriverWait(driver,longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		
		for (WebElement item : allItems) {
			if(item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[].scrollIntoView(true);",item);
				sleepInSecond(1);
				
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getAttributeValue(WebDriver driver,String locator, String attributeName) {
		return getWebElement(driver,locator).getAttribute(attributeName);
		}
	public String getElementText(WebDriver driver,String locator) {
		return getWebElement(driver,locator).getText();
		}
	public String getElementCssValue(WebDriver driver, String locator, String value) {
		return getWebElement(driver,locator).getCssValue(value);
	}
	public int getElementSize(WebDriver driver, String locator) {
		return getListWebElements(driver,locator).size();
	}
	public void checkToCheckboxRadio(WebDriver driver, String locator) {
		if(!getWebElement(driver,locator).isSelected()) {
			waitForElementClickAble(driver,locator).click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver,String locator) {
		if(getWebElement(driver,locator).isSelected()) {
			waitForElementClickAble(driver,locator).click();
		}
	}
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return waitForElementVisible(driver,locator).isDisplayed();
	}			
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return waitForElementVisible(driver,locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver,locator).isSelected();
	}
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver,locator));
	}
	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getWebElement(driver,locator)).perform();
	}
	public void moveMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getWebElement(driver,locator)).perform();
	}
	public void rightClickToElement(WebDriver driver, String sourceLocator,String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver,sourceLocator),getWebElement(driver,targetLocator)).perform();
	}
	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getWebElement(driver,locator),key).perform();
	}
	public String convertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public void uploadToElement(WebDriver driver, String locator,String filePath) {
		getWebElement(driver,locator).sendKeys(filePath);
	}
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}
	
	
	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof "
				+ "arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public WebElement waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public WebElement waitForElementClickAble(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator) {
		try {
			overideTimeout(shortTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			overideTimeout(longTimeout);
		}
	}
	public void overideTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);	
	}
	
	public boolean isElementInvisible(WebDriver driver, String locator) {
		overideTimeout(shortTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		overideTimeout(longTimeout);
		if(elements.size() == 0) {
			System.out.print("3: element không có trong DOM = không có trên UI");
			return true;
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("2: Element có trong DOM nhưng không có trên UI");
			return true;
		} else {
			System.out.println("1: Element có trong DOM và có trên UI");
			return false;
		}
	}
	public boolean isElementDisplayed(String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			return element.isDisplayed();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	
	
	
	
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private long shortTimeout = 5;
	private long longTimeout = 10;
	private Actions action;
	private Alert alert;
	private Select select;
}