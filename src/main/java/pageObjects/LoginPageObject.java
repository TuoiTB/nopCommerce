package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
        clickToElement(driver, LoginPageUI.LOGIN_LINK);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void inputToEmail(String valueToSend) {
        waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX, valueToSend);
    }

    public void inputToPassword(String valueToSend) {
        waitForListElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, valueToSend);
    }

    public boolean isEmailErrorMessageDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }
    public boolean isErrorLoginMessageDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
    }
    public void loginToSystem(String userName, String password){
        inputToEmail(userName);
        inputToPassword(password);
        clickToLoginButton();
    }
/*    public DashBoardPageObject loginToSystem(String userNameLogin, String passwordLogin) {
        waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userNameLogin);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordLogin);
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return new DashBoardPageObject(driver);
    }*/

}
