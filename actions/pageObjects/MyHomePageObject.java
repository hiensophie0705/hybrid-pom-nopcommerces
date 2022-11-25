package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
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

	public void clickToSearchLink() {
		waitForElementVisible(driver, MyHomePageUI.SEARCH_LINK);
		clickToElement(driver, MyHomePageUI.SEARCH_LINK);
		
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickAble(driver, MyHomePageUI.PRODUCT_ORDER_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver,MyHomePageUI.PRODUCT_ORDER_BY_DROPDOWN, textItem);	
	}

	public boolean isProductNameSortByAscending() {
		//khai báo ra 1 arraylist để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();
		
		//Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElements(driver, MyHomePageUI.PRODUCT_NAME_TEXT);
		
		//dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName: productNameText) {
			productUIList.add(productName.getText());
		}
		
		//Tạo ra 1 arraylist mới để sort dữ liệu trong ArrayList cũ xem có đúng hay không		
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		//Sort cái productSortList
		Collections.sort(productSortList);
		
		//So sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
				//khai báo ra 1 arraylist để chứa các product name trên UI
				ArrayList<String> productUIList = new ArrayList<String>();
				
				//Lấy ra hết tất cả các text product name
				List<WebElement> productNameText = getListWebElements(driver, MyHomePageUI.PRODUCT_NAME_TEXT);
				
				//dùng vòng lặp để getText và add vào ArrayList trên
				for (WebElement productName: productNameText) {
					productUIList.add(productName.getText());
					System.out.println("Product Name ở trên UI: " + productName.getText());
				}
				
				//Tạo ra 1 arraylist mới để sort dữ liệu trong ArrayList cũ xem có đúng hay không		
				ArrayList<String> productSortList = new ArrayList<String>();
				for (String product : productUIList) {
					productSortList.add(product);
				}
				
				//Sort cái productSortList
				Collections.sort(productSortList);
				
				for (String productName : productSortList) {
					System.out.println("Product Name sau khi sort ASC: " + productName);
				}
				
				//Reverse cái ProductSortList
				Collections.reverse(productSortList);
				
				for(String productName: productSortList) {
					System.out.println("Product Name sau khi sort DESC: " + productName);
				}
				
				//So sánh 2 list đã bằng nhau
				return productSortList.equals(productUIList);
			}

	public void clickToNotebookslink() {
		waitForElementClickAble(driver, MyHomePageUI.NOTE_BOOK_LINK);
		clickToElement(driver, MyHomePageUI.NOTE_BOOK_LINK);
		
	}

	public boolean isProductPriceSortByAscending() {
		//Khai báo 1 array list
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//Tìm tất cả element matching với điều kiện (Name/Price...)
		List<WebElement> productPriceText = getListWebElements(driver, MyHomePageUI.PRODUCT_PRICE_TEXT);
		
		// dùng vòng lặp để getText và add vào Array list trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$","").replace(",", "")));
			
			System.out.println("Product Name ở trên UI: " + productPrice.getText());
		}
		
		
		//Tạo ra 1 Array list mới để sort dữ liệu trong Arraylist cũ xem đúng hay không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for(Float product : productUIList) {
			productSortList.add(product);
		}
		 //Thực hiện sort cái ProductSortList
		Collections.sort(productSortList);
		
		for (Float productName : productSortList) {
			System.out.println("Product Name sau khi sort ASC: " + productName);
		}
		
		//verify 2 array bằng nhau - nếu dữ liệu sort trên UI không chính xác thì kết quả trả về sai
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		//Khai báo 1 array list
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//Tìm tất cả element matching với điều kiện (Name/Price...)
		List<WebElement> productPriceText = getListWebElements(driver, MyHomePageUI.PRODUCT_PRICE_TEXT);
		
		// dùng vòng lặp để getText và add vào Array list trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",","")));
			System.out.println("Product Name ở trên UI: " + productPrice.getText());
		}
		
		
		//Tạo ra 1 Array list mới để sort dữ liệu trong Arraylist cũ xem đúng hay không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for(Float product : productUIList) {
			productSortList.add(product);
		}
		 //Thực hiện sort cái ProductSortList
		Collections.sort(productSortList);
		
		//Reverse cái productSortList
		Collections.reverse(productSortList);
		for (Float productName : productSortList) {
			System.out.println("Product Name sau khi sort DESC: " + productName);
		}
		
		//verify 2 array bằng nhau - nếu dữ liệu sort trên UI không chính xác thì kết quả trả về sai
		return productSortList.equals(productUIList);
	}

	public void selectItemInProductPageSizeDropdown(String textItem) {
		waitForElementClickAble(driver, MyHomePageUI.PRODUCT_DISPLAY_DROPDOWN);
		selectItemInDefaultDropdown(driver,MyHomePageUI.PRODUCT_DISPLAY_DROPDOWN, textItem);	

	}

	public boolean isThreeProductsWithAPageDisplayed() {
		//Khai báo 1 arraylist chứa các name product trên UI
		List<String> namesList = new ArrayList<String>();
		
		//Lấy ra sizeOfPagination
		int sizeOfPagination = getListWebElements(driver, MyHomePageUI.PAGER).size();

		System.out.println(sizeOfPagination);
		if (sizeOfPagination > 0) {
			List<WebElement> listOfNames = getListWebElements(driver,MyHomePageUI.ITEM_BOXES);
			
			for (WebElement name : listOfNames) {
				namesList.add(name.getText());
			}
			do {
				 WebElement nextButton = getWebElement(driver, MyHomePageUI.NEXT_BUTTON);
				String nextClassName = nextButton.getAttribute("class");
				
				if(!nextClassName.contains("disabled")) {
					nextButton.click();
				}else {
					break;
				}
			}
			while(true);
		}else {
			System.out.println("No pagination in this page");
		}
		for(String allNames : namesList) {
			System.out.println(allNames);
		}
		return false;
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickAble(driver, MyHomePageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, MyHomePageUI.ADD_TO_WISHLIST_BUTTON);		
	}

	public void clickDetailProductLenovoIdeaCentre600AllinOnePC() {
		waitForElementClickAble(driver, MyHomePageUI.LENOVO_IDEACENTRE600_ALL_IN_ONE_PC);
		clickToElement(driver, MyHomePageUI.LENOVO_IDEACENTRE600_ALL_IN_ONE_PC);	
		
	}

	public boolean isMessageAddedToYourWishlistSuccessDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.MESSAGE_ADDED_TO_WISHLIST_SUCCESS);
		return isElementDisplayed(driver, MyHomePageUI.MESSAGE_ADDED_TO_WISHLIST_SUCCESS);
	}

	public void clickToWishlistLink() {
		waitForElementClickAble(driver, MyHomePageUI.WISHLIST_LINK);
		clickToElement(driver, MyHomePageUI.WISHLIST_LINK);	
	}

	public boolean isProductNameLenovoIdeaCentre600AllinOnePCDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.PRODUCT_NAME_LENOVO_IDEA_CENTRE600_ALL_IN_ONE_PC);
		return isElementDisplayed(driver, MyHomePageUI.PRODUCT_NAME_LENOVO_IDEA_CENTRE600_ALL_IN_ONE_PC);
	}

	public void clickToYourWishlistURLForSharingLink() {
		waitForElementClickAble(driver, MyHomePageUI.YOUR_WISHLIST_URL_FOR_SHARING_LINK);
		clickToElement(driver, MyHomePageUI.YOUR_WISHLIST_URL_FOR_SHARING_LINK);	
	
	}

	public boolean isTitleWishlistDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.TITLE_WISHLIST);
		return isElementDisplayed(driver, MyHomePageUI.TITLE_WISHLIST);
	}

	public void clickToAddToCartCheckbox() {
		waitForElementClickAble(driver, MyHomePageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, MyHomePageUI.ADD_TO_CART_CHECKBOX);
		
	}

	public void clickToAddToCartButton() {
		waitForElementClickAble(driver, MyHomePageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, MyHomePageUI.ADD_TO_CART_BUTTON);
		
	}

	public boolean isProductShoppingCartDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.PRODUCT_SHOPPING_CART_NUMBER);
		return isElementDisplayed(driver, MyHomePageUI.PRODUCT_SHOPPING_CART_NUMBER);
	}

	public void clickToWishlistLabel() {
		waitForElementClickAble(driver, MyHomePageUI.WISHLIST_LABEL);
		clickToElement(driver, MyHomePageUI.WISHLIST_LABEL);
		
	}

	public void clickToRemoveButton() {
		waitForElementClickAble(driver, MyHomePageUI.REMOVE_BUTTON);
		clickToElement(driver, MyHomePageUI.REMOVE_BUTTON);
		
		
	}

	public void clickToUpdateWishlistButton() {
		waitForElementClickAble(driver, MyHomePageUI.UPDATE_WISHLIST_BUTTON);
		clickToElement(driver, MyHomePageUI.UPDATE_WISHLIST_BUTTON);
		
	}

	public boolean isMessageTheWishlistIsEmptyDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.THE_WISHLIST_IS_EMPTY_MESSAGE);
		return isElementDisplayed(driver, MyHomePageUI.THE_WISHLIST_IS_EMPTY_MESSAGE);
	}

	public void clickToCompareBuildYourOwnComputerButton() {
		waitForElementClickAble(driver, MyHomePageUI.COMPARE_BUTTON_BUILD_YOUR_OWN_COMPUTER);
		clickToElement(driver, MyHomePageUI.COMPARE_BUTTON_BUILD_YOUR_OWN_COMPUTER);
		
		
	}

	public void clickToCompareLenovoIdeaCentre600AllInOnePCButton() {
		waitForElementClickAble(driver, MyHomePageUI.LENOVO_IDEA_CENTRE600_ALLINONE_PC_BUTTON);
		clickToElement(driver, MyHomePageUI.LENOVO_IDEA_CENTRE600_ALLINONE_PC_BUTTON);
		
	}

	public boolean isMessageProductCompareSuccessDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.PRODUCT_COMPARE_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, MyHomePageUI.PRODUCT_COMPARE_SUCCESS_MESSAGE);
	}

	public void clickToProductCompareLink() {
		waitForElementClickAble(driver, MyHomePageUI.PRODUCT_COMPARE_LINK);
		clickToElement(driver, MyHomePageUI.PRODUCT_COMPARE_LINK);
		
	}

	public boolean isNameProductOnProductComparePageDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.NAME_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
		return isElementDisplayed(driver, MyHomePageUI.NAME_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
	}

	public boolean isRemoveButtonOnProductComparePageDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.REMOVE_BUTTON_ON_PRODUCT_COMPARE_PAGE);
		return isElementDisplayed(driver, MyHomePageUI.REMOVE_BUTTON_ON_PRODUCT_COMPARE_PAGE);
	}


	public boolean isPriceProductOnProductComparePageDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.PRICE_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
		return isElementDisplayed(driver, MyHomePageUI.PRICE_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
	}

	public void clickToClearListButton() {
		waitForElementClickAble(driver, MyHomePageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, MyHomePageUI.CLEAR_LIST_BUTTON);	
	}

	public boolean isMessageNoDataCompareProductDisplayed() {
		waitForElementVisible(driver, MyHomePageUI.NO_DATA_COMPARE_PRODUCT_MESSAGE);
		return isElementDisplayed(driver, MyHomePageUI.NO_DATA_COMPARE_PRODUCT_MESSAGE);
	}

	public boolean isRemoveButtonOnProductComparePageUnDisplayed() {
		waitForElementInvisible(driver, MyHomePageUI.REMOVE_BUTTON_ON_PRODUCT_COMPARE_PAGE);
		return isElementInvisible(driver, MyHomePageUI.REMOVE_BUTTON_ON_PRODUCT_COMPARE_PAGE);
	}
	

	public boolean isNameProductOnProductComparePageUnDisplayed() {
		waitForElementInvisible(driver, MyHomePageUI.NAME_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
		return isElementInvisible(driver, MyHomePageUI.NAME_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
	}

	public boolean isPriceProductOnProductComparePageUnDisplayed() {
		waitForElementInvisible(driver, MyHomePageUI.PRICE_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
		return isElementInvisible(driver, MyHomePageUI.PRICE_PRODUCT_ON_PRODUCT_COMPARE_PAGE);
	}	
	}
	


	

