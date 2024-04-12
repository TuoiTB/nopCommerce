package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;

public class WishlistPageObject extends BasePage {
    WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToRegisterLink(){
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }
    public void clickToLoginLink(){
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }
}
