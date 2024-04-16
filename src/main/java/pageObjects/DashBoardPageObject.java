package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.DashBoardPageUI;

import java.time.Duration;
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
    public void clickToProduct(String nameProduct){
        waitForElementClickable(driver, DashBoardPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME, nameProduct);
        clickToElement(driver, DashBoardPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME, nameProduct);
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
    public void openDesktop() {
        waitForElementClickable(driver, DashBoardPageUI.COMPUTER_TOP_MENU);
        clickToElement(driver, DashBoardPageUI.COMPUTER_TOP_MENU);
        waitForElementClickable(driver, DashBoardPageUI.DESKTOP);
        clickToElement(driver, DashBoardPageUI.DESKTOP);
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
    public boolean isProductDisplayedInWishlist(){
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_LINK_IN_WISHLIST);
        return isElementDisplayed(driver, DashBoardPageUI.PRODUCT_LINK_IN_WISHLIST);
    }
    public boolean isProductDisplayedInShoppingCart(){
        waitForListElementVisible(driver, DashBoardPageUI.PRODUCT_LINK_IN_SHOPPING_CART);
        return isElementDisplayed(driver, DashBoardPageUI.PRODUCT_LINK_IN_SHOPPING_CART);
    }
    public boolean isMessageProductEmptyDisplayed(){
        waitForListElementVisible(driver, DashBoardPageUI.WISHLIST_MESSAGE);
        return isElementDisplayed(driver, DashBoardPageUI.WISHLIST_MESSAGE);
    }
    public boolean isProductUnDisplayed(){
        return isElementUndisplayed(driver, DashBoardPageUI.PRODUCT_LINK_IN_WISHLIST);
    }
    public void clickToSharingLink(){
        waitForElementClickable(driver, DashBoardPageUI.SHARING_LINK);
        clickToElement(driver, DashBoardPageUI.SHARING_LINK);
    }
    public void clickToWishlistInHeader(){
        waitForElementClickable(driver, DashBoardPageUI.WISHLIST_LINK_IN_HEADER);
        clickToElement(driver, DashBoardPageUI.WISHLIST_LINK_IN_HEADER);
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
    public void addProductToComparisionByName(String nameProduct){
        waitForElementClickable(driver, DashBoardPageUI.ADD_TO_COMPARE_BUTTON_BY_NAME, nameProduct);
        clickToElement(driver, DashBoardPageUI.ADD_TO_COMPARE_BUTTON_BY_NAME, nameProduct);
    }
    public void clickToCompareLink(){
        waitForElementClickable(driver, DashBoardPageUI.COMPARE_LINK);
        clickToElement(driver, DashBoardPageUI.COMPARE_LINK);
    }
    public boolean isComparisionMessageDisplayed(){
        waitForElementVisible(driver, DashBoardPageUI.COMPARISON_MESSAGE);
        return isElementDisplayed(driver, DashBoardPageUI.COMPARISON_MESSAGE);
    }
    public boolean isProductInComparisionDisplayedByName(String nameProduct){
        waitForElementVisible(driver, DashBoardPageUI.PRODUCT_IN_COMPARISION_PAGE_BY_NAME, nameProduct);
        return isElementDisplayed(driver, DashBoardPageUI.PRODUCT_IN_COMPARISION_PAGE_BY_NAME, nameProduct);
    }
    public void clickToClearButton(){
        waitForElementClickable(driver, DashBoardPageUI.CLEAR_BUTTON);
        clickToElement(driver, DashBoardPageUI.CLEAR_BUTTON);
    }
    public boolean isClearComparisionMessageDisplayed(){
        waitForElementVisible(driver, DashBoardPageUI.CLEAR_MESSAGE);
        return isElementDisplayed(driver, DashBoardPageUI.CLEAR_MESSAGE);
    }
    public boolean isProductInComparisionUnDisplayedByName(String nameProduct){
        return isElementUndisplayed(driver, DashBoardPageUI.PRODUCT_IN_COMPARISION_PAGE_BY_NAME, nameProduct);
    }
    public void clickToRecentViewProductsLinkInFooter(){
        waitForElementClickable(driver, DashBoardPageUI.RECENT_VIEW_PRODUCTS_LINK_IN_FOOTER);
        clickToElement(driver, DashBoardPageUI.RECENT_VIEW_PRODUCTS_LINK_IN_FOOTER);
    }

    public boolean isProductInRecentViewDisplayedByName(String nameProduct) {
        waitForElementVisible(driver, DashBoardPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME, nameProduct);
        return isElementDisplayed(driver, DashBoardPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME, nameProduct);
    }
    public void backToPage(){
        backToPage(driver);
        isPageLoadedSuccess(driver);
    }

    public void selectProcessorDropdown() {
    }

    public void selectRAMDropdown() {
    }

    public void selectHDDRadioButton() {
    }

    public void selectOSRadioButton() {
    }

    public void selectSoftwareCheckbox() {
    }

    public boolean isMessageAddedToCartDisplayed() {
    }

    public void clickToShoppingCartLink() {
    }
}
