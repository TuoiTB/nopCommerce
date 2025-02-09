package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToCreateAccountButton(){
        if (isElementDisplayed(driver, HomePageUI.POPUP_TOPIK)) {
            sleepInSecond(3);
            waitForElementClickable(driver, HomePageUI.POPUP_TOPIK);
            clickToElement(driver, HomePageUI.POPUP_TOPIK);
            waitForElementInvisible(driver, HomePageUI.POPUP_TOPIK);
        }
        waitForElementClickable(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
    }
    public void clickToLoginButton(){
        if (isElementDisplayed(driver, HomePageUI.POPUP_TOPIK)) {
            sleepInSecond(3);
            waitForElementClickable(driver, HomePageUI.POPUP_TOPIK);
            clickToElement(driver, HomePageUI.POPUP_TOPIK);
            waitForElementInvisible(driver, HomePageUI.POPUP_TOPIK);
        }
        waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.LOGIN_BUTTON);
    }
}
