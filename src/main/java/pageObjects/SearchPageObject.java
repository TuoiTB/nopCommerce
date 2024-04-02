package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.SearchPageUI;

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
}
