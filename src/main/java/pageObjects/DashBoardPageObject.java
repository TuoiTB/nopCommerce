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
}
