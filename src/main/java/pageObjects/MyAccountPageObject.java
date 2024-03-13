package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.DashBoardPageUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoginSuccessfully(){
        return isElementDisplayed(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
    }
}
