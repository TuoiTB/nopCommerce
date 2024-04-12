package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.DashBoardPageUI;

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
        waitForElementVisible(driver, DashBoardPageUI.ADD_REVIEW_SUCCESSFULLY_MESSAGE);
        return isElementDisplayed(driver, DashBoardPageUI.ADD_REVIEW_SUCCESSFULLY_MESSAGE);
    }

    public void clickToSearchLinkInFooter() {
        waitForElementClickable(driver, DashBoardPageUI.SEARCH_LINK_IN_FOOTER);
        clickToElement(driver, DashBoardPageUI.SEARCH_LINK_IN_FOOTER);
    }

    public void openNotebooks() {
        waitForElementClickable(driver, DashBoardPageUI.COMPUTER_TOP_MENU);
        clickToElement(driver, DashBoardPageUI.COMPUTER_TOP_MENU);
        waitForElementClickable(driver, DashBoardPageUI.NOTEBOOK);
        clickToElement(driver, DashBoardPageUI.NOTEBOOK);
    }
    public void clickToWishlistButton(){
        waitForElementClickable(driver, DashBoardPageUI.WISHLIST_BUTTON);
        clickToElement(driver, DashBoardPageUI.WISHLIST_BUTTON);
    }
    public void clickToWishlistLink(){
        waitForElementClickable(driver, DashBoardPageUI.WISHLIST_LINK);
        clickToElement(driver, DashBoardPageUI.WISHLIST_LINK);
    }
    public void clickToCloseButton(){
        waitForElementClickable(driver, DashBoardPageUI.CLOSE_BUTTON);
        clickToElement(driver, DashBoardPageUI.CLOSE_BUTTON);
    }
    public boolean isAddProductToWishlistSuccessfullyMessageDisplayed(){
        waitForListElementVisible(driver, DashBoardPageUI.ADD_WISHLIST_SUCCESSFULLY_MESSAGE);
        return isElementDisplayed(driver, DashBoardPageUI.ADD_WISHLIST_SUCCESSFULLY_MESSAGE);
    }
    public boolean isProductDisplayed(){
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_LINK);
        return isElementDisplayed(driver, DashBoardPageUI.PRODUCT_LINK);
    }
    public void clickToSharingLink(){
        waitForElementClickable(driver, DashBoardPageUI.SHARING_LINK);
        clickToElement(driver, DashBoardPageUI.SHARING_LINK);
    }
    public String getTextOfTitleInSharingLink(){
        waitForElementVisible(driver, DashBoardPageUI.TITLE_IN_SHARING_LINK);
        return getElementText(driver, DashBoardPageUI.TITLE_IN_SHARING_LINK);
    }
    public void checkToAddToCartCheckbox(){
        waitForElementClickable(driver, DashBoardPageUI.CHECKBOX_ADD_TO_CART);
        checkToCheckboxOrRadio(driver, DashBoardPageUI.CHECKBOX_ADD_TO_CART);
    }
    public void clickToAddToCartButton(){
        waitForElementClickable(driver, DashBoardPageUI.ADD_TO_CART_BUTTON);
        checkToCheckboxOrRadio(driver, DashBoardPageUI.ADD_TO_CART_BUTTON);
    }

    public void clickToHomeImage() {
        waitForElementClickable(driver, DashBoardPageUI.HOME_IMAGE);
        clickToElement(driver, DashBoardPageUI.HOME_IMAGE);
    }

    public void clickToRemoveButton() {
        waitForElementClickable(driver, DashBoardPageUI.REMOVE_BUTTON);
        clickToElement(driver, DashBoardPageUI.REMOVE_BUTTON);
    }
    public String getTextRemoveMessage() {
        waitForElementVisible(driver, DashBoardPageUI.REMOVE_MESSAGE);
        return getElementText(driver, DashBoardPageUI.REMOVE_MESSAGE);
    }
    public void clickToAddCompareButton(){
        List<WebElement> addCompareButton = getListElement(driver, DashBoardPageUI.ADD_TO_COMPARE_BUTTON);
        waitForElementClickable(driver, DashBoardPageUI.ADD_TO_COMPARE_BUTTON);
        for (WebElement compare: addCompareButton) {
            if (compare == null) {
                compare.click();
            }
        }
    }
}
