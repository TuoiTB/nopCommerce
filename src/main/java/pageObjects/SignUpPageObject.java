package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.SignUpPageUI;

public class SignUpPageObject extends BasePage {
    WebDriver driver;

    public SignUpPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSignUpButton() {
        waitForElementClickable(driver, SignUpPageUI.SIGN_UP_BUTTON);
        clickToElement(driver, SignUpPageUI.SIGN_UP_BUTTON);
    }
    public void clickToSignUpLink() {
        waitForElementClickable(driver, SignUpPageUI.REGISTER_LINK);
        clickToElement(driver, SignUpPageUI.REGISTER_LINK);
    }

    public boolean isMessageRequiredDisplayedByText(String text) {
        return isElementDisplayed(driver, SignUpPageUI.MSG_REQUIRED_BY_TEXT, text);
    }
    public void inputEmailAddress(String valueToSend){
        waitForElementVisible(driver, SignUpPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, SignUpPageUI.EMAIL_ADDRESS_TEXTBOX, valueToSend);
    }
    public void inputToFullName(String valueToSend){
        waitForElementVisible(driver, SignUpPageUI.FULL_NAME_TEXTBOX);
        sendkeyToElement(driver, SignUpPageUI.FULL_NAME_TEXTBOX, valueToSend);
    }
    public void inputToPhoneNumber(String valueToSend){
        waitForElementVisible(driver, SignUpPageUI.PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, SignUpPageUI.PHONE_NUMBER_TEXTBOX, valueToSend);
    }
    public void inputToPassword(String valueToSend){
        waitForElementVisible(driver, SignUpPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, SignUpPageUI.PASSWORD_TEXTBOX, valueToSend);
    }
    public void inputToConfirmPassword(String valueToSend){
        waitForElementVisible(driver, SignUpPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, SignUpPageUI.CONFIRM_PASSWORD_TEXTBOX, valueToSend);
    }
    public boolean isSignUpSuccessfullyMessageDisplayed(){
        return isElementDisplayed(driver, SignUpPageUI.SIGN_UP_MESSAGE_SUCCESSFULLY);
    }
    public boolean isEmailWrongMessageDisplayed(){
        return isElementDisplayed(driver, SignUpPageUI.EMAIL_WRONG_MESSAGE);
    }
    public boolean isEmailExistedMessageDisplayed(){
        return isElementDisplayed(driver, SignUpPageUI.EMAIL_EXISTED_MESSAGE);
    }

    public boolean isPasswordLessThanSixCharactersMessageDisplayed() {
        return isElementDisplayed(driver, SignUpPageUI.PASSWORD_ERROR_MESSAGE);
    }
    public boolean isConfirmPasswordErrorMessageDisplayed() {
        return isElementDisplayed(driver, SignUpPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }
}
