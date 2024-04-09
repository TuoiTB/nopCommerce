package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.DashBoardPageUI;
import pageUI.SearchPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPageObject extends BasePage {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public boolean isMessageWarningDisplayed() {
        return isElementDisplayed(driver, SearchPageUI.MESSAGE_WARNING);
    }

    public void inputToSearchTextbox(String searchKeyword) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKeyword);
    }

    public boolean isMessageNoResultDisplayed() {
        return isElementDisplayed(driver, SearchPageUI.MESSAGE_NO_RESULT);
    }

    public boolean isProductSearchResultsRelativeDisplayed(String searchKey) {
        List<WebElement> allPrudctResult = getListElement(driver, SearchPageUI.PRODUCT_SEARCH);
        int size = allPrudctResult.size();
        int result = 0;
        for (WebElement element : allPrudctResult) {
            if (element.getText().contains(searchKey)) {
                result += 1;
            }
        }
        return size == result;
    }
    public boolean isProductSearchResultsAbsoluteDisplayed(String searchKey) {
        return getElementText(driver, SearchPageUI.PRODUCT_SEARCH).equals(searchKey);
    }
    public boolean isProductSearchResultDisplayed() {
        return isElementDisplayed(driver, SearchPageUI.PRODUCT_ADVANCED_SEARCH);
    }

    public void checkToAdvancedSearchCheckbox() {
        waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckboxOrRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }
    public void selectItemInCategoryDropdown(String itemText) {
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, itemText);
    }
    public void checkSubCategoryCheckbox() {
        waitForElementVisible(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
        checkToCheckboxOrRadio(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
    }

    public void selectItemInManufacturerDropdown(String itemText) {
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, itemText);
    }

    public void chooseNumberProductInDisplayPerPageByText(String text) {
        waitForElementVisible(driver, SearchPageUI.NUMBER_PRODUCT_DROPDOWN);
        selectDropdown(driver, SearchPageUI.NUMBER_PRODUCT_DROPDOWN, text);
    }

    public boolean isNextPageIconDisplayed() {
        return isElementDisplayed(driver, SearchPageUI.ICON_NEXT_PAGE);
    }


    public void clickToNextPageIcon() {
        waitForElementClickable(driver, SearchPageUI.ICON_NEXT_PAGE);
        clickToElement(driver, SearchPageUI.ICON_NEXT_PAGE);
    }

    public boolean isPreviousPageIconDisplayed() {
        return isElementDisplayed(driver, SearchPageUI.ICON_PREVIOUS_PAGE);
    }
    public int getNumberProduct(){
        return getListElementSize(driver, SearchPageUI.NUMBER_OF_PRODUCT_IN_PER_PAGE);
    }
    public boolean isNumberProductLessThan9(){
        int numberProduct = getListElementSize(driver, SearchPageUI.NUMBER_OF_PRODUCT_IN_PER_PAGE);
        return numberProduct <= 9;
    }
    public boolean isPagingNotDisplayed(){
        return isElementUndisplayed(driver, SearchPageUI.PAGING);
    }

    public void sortByPosition(String expectedText){
        waitForElementVisible(driver, SearchPageUI.PRODUCT_ORDER_BY_DROPDOWN);
        selectDropdown(driver, SearchPageUI.PRODUCT_ORDER_BY_DROPDOWN, expectedText);
    }
    public boolean isProductNameSortAscending() {
        waitForListElementVisible(driver, SearchPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, SearchPageUI.PRODUCT_NAME);

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
        waitForListElementVisible(driver, SearchPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, SearchPageUI.PRODUCT_NAME);

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
        waitForListElementVisible(driver, SearchPageUI.PRODUCT_PRICE);

        List<WebElement> productName = getListElement(driver, SearchPageUI.PRODUCT_PRICE);

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
        waitForListElementVisible(driver, SearchPageUI.PRODUCT_PRICE);

        List<WebElement> productName = getListElement(driver, SearchPageUI.PRODUCT_PRICE);

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
