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
        waitForElementClickable(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
    }
    public void clickToLoginButton(){
        waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.LOGIN_BUTTON);
    }
}
