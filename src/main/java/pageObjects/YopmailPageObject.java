package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.YopmaiPageUI;

public class YopmailPageObject extends BasePage {
    WebDriver driver;

    public YopmailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputToEmail(String email) {
        waitForElementVisible(driver, YopmaiPageUI.INPUT_EMAIL_TEXTBOX);
        sendkeyToElement(driver, YopmaiPageUI.INPUT_EMAIL_TEXTBOX, email);
    }
    public void switchToIframeInbox(){
        switchToFrame(driver, YopmaiPageUI.IFRAME_INBOX);
    }
    public void switchToIframeMail(){
        switchToFrame(driver, YopmaiPageUI.IFRAME_MAIL);
    }
    public void clickToForwardButton() {
        waitForElementClickable(driver, YopmaiPageUI.FORWARD_BUTTON);
        clickToElement(driver, YopmaiPageUI.FORWARD_BUTTON);
    }
    public void clickToRefreshButton() {
        waitForElementClickable(driver, YopmaiPageUI.REFRESH_BUTTON);
        clickToElement(driver, YopmaiPageUI.REFRESH_BUTTON);
    }
    public String getEmailFromYopmail(){
        return getElementText(driver, YopmaiPageUI.EMAIL);
    }
    public boolean isIigRegistrationDisplayed(){
        switchToIframeInbox();
        return isElementDisplayed(driver, YopmaiPageUI.IIG_REGISTRATION_SPAN);
    }
    public void clickToConfirmDiv() {
        switchToIframeInbox();
        waitForElementClickable(driver, YopmaiPageUI.BUTTON);
        clickToElementByJS(driver, YopmaiPageUI.BUTTON);
    }
    public boolean isAccountConfirmationDisplayed(){
        switchToIframeMail();
        return isElementDisplayed(driver, YopmaiPageUI.ACCOUNT_CONFIRMATION);
    }
    public void clickToConfirmAccountButton(String email) {
        sleepInSecond(5);
        switchToIframeMail();
        waitForElementClickable(driver, YopmaiPageUI.CONFIRM_ACCOUNT_BUTTON, email);
        clickToElement(driver, YopmaiPageUI.CONFIRM_ACCOUNT_BUTTON, email);
    }
}
