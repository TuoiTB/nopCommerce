package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.DashBoardPageUI;
import pageUI.HomePageUI;

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
}
