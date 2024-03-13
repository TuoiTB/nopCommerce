package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    public void clickToRegisterLink() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
        clickToElement(driver, RegisterPageUI.REGISTER_LINK);
    }

    public boolean isMessageRequiredDisplayedByText(String text) {
        return isElementDisplayed(driver, RegisterPageUI.MSG_REQUIRED_BY_TEXT, text);
    }
    public void inputToFirstName(String valueToSend){
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, valueToSend);
    }
    public void inputToLastName(String valueToSend){
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, valueToSend);
    }
    public void inputToEmail(String valueToSend){
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, valueToSend);
    }
    public void inputToPassword(String valueToSend){
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, valueToSend);
    }
    public void inputToConfirmPassword(String valueToSend){
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, valueToSend);
    }
    public boolean isMessageRegisterSuccessfullyDisplayed(){
        return isElementDisplayed(driver, RegisterPageUI.MESSAGE_SUCCESSFULLY);
    }
    public boolean isEmailWrongMessageDisplayed(){
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_WRONG_MESSAGE);
    }
    public boolean isEmailExistedMessageDisplayed(){
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_EXISTED_MESSAGE);
    }

    public boolean isPasswordLessThanSixCharactersMessageDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }
    public boolean isConfirmPasswordErrorMessageDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }
}
