package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.DashBoardPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashBoardPageObject extends BasePage {
    WebDriver driver;

    public DashBoardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoginSuccessfully(){
        return isElementDisplayed(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
    }
    public void clickMyAccount(){
        waitForElementClickable(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
    }
    public void clickToProduct(){
        waitForElementClickable(driver, DashBoardPageUI.PRODUCT_LINK);
        clickToElement(driver, DashBoardPageUI.PRODUCT_LINK);
    }
    public void clickToAddReviewLink(){
        waitForElementClickable(driver, DashBoardPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, DashBoardPageUI.ADD_REVIEW_LINK);
    }
    public void clickToSubmitReviewButton(){
        waitForElementClickable(driver, DashBoardPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, DashBoardPageUI.SUBMIT_REVIEW_BUTTON);
    }
    public void inputToReviewTitleTextbox(String valueToSend){
        waitForElementVisible(driver, DashBoardPageUI.REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, DashBoardPageUI.REVIEW_TITLE_TEXTBOX, valueToSend);
    }
    public void inputToReviewTextTextarea(String valueToSend){
        waitForElementVisible(driver, DashBoardPageUI.REVIEW_TEXT_TEXTAREA);
        sendkeyToElement(driver, DashBoardPageUI.REVIEW_TEXT_TEXTAREA, valueToSend);
    }
    public boolean isAddReviewSuccessfullyMessageDisplayed(){
        return isElementDisplayed(driver, DashBoardPageUI.ADD_REVIEW_SUCCESSFULLY_MESSAGE);
    }

    public void clickToSearchLinkInFooter() {
        waitForElementClickable(driver, DashBoardPageUI.SEARCH_LINK_IN_FOOTER);
        clickToElement(driver, DashBoardPageUI.SEARCH_LINK_IN_FOOTER);
    }

    public void openSubmenu(String expectedText) {
        waitForElementVisible(driver, DashBoardPageUI.COMPUTER_TOP_MENU);
        selectItemInCustomDropdown_hover(driver, DashBoardPageUI.COMPUTER_TOP_MENU, DashBoardPageUI.NOTEBOOK_SUB_FIRST_LEVEL, expectedText);
    }
    public void sortByPosition(String expectedText){
        waitForElementVisible(driver, DashBoardPageUI.PRODUCT_ORDER_BY_DROPDOWN);
        selectDropdown(driver, DashBoardPageUI.PRODUCT_ORDER_BY_DROPDOWN, expectedText);
    }
    public boolean isProductNameSortAscending() {
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, DashBoardPageUI.PRODUCT_NAME);

        //Lưu tất cả các text trên UI vào list
        List<String> productNameTextUI = new ArrayList<String>();
        for (WebElement product : productName) {
            productNameTextUI.add(product.getText());
        }

        //Sort Data
        List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Collection sort
        Collections.sort(productNameTextSort);

        return productNameTextUI.equals(productNameTextSort);
    }
    public boolean isProductNameSortDescending() {
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, DashBoardPageUI.PRODUCT_NAME);

        //Lưu tất cả các text trên UI vào list
        List<String> productNameTextUI = new ArrayList<String>();
        for (WebElement product : productName) {
            productNameTextUI.add(product.getText());
        }

        //Sort Data
        List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Collection sort
        Collections.sort(productNameTextSort);

        //Reverse data
        Collections.reverse(productNameTextSort);

        return productNameTextUI.equals(productNameTextSort);
    }
    public boolean isProductPriceSortLowToHigh() {
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_PRICE);

        List<WebElement> productName = getListElement(driver, DashBoardPageUI.PRODUCT_PRICE);

        //Lưu tất cả các text trên UI vào list
        List<String> productNameTextUI = new ArrayList<String>();
        for (WebElement product : productName) {
            productNameTextUI.add(product.getText());
        }

        //Sort Data
        List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Collection sort
        Collections.sort(productNameTextSort);

        return productNameTextUI.equals(productNameTextSort);
    }
    public boolean isProductPriceSortHighToLow() {
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_PRICE);

        List<WebElement> productName = getListElement(driver, DashBoardPageUI.PRODUCT_PRICE);

        //Lưu tất cả các text trên UI vào list
        List<String> productNameTextUI = new ArrayList<String>();
        for (WebElement product : productName) {
            productNameTextUI.add(product.getText());
        }

        //Sort Data
        List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Collection sort
        Collections.sort(productNameTextSort);

        //Reverse data
        Collections.reverse(productNameTextSort);

        return productNameTextUI.equals(productNameTextSort);
    }


}
