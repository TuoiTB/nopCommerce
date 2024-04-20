package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.CheckOutPageUI;

public class CheckOutPageObject extends BasePage {
    WebDriver driver;

    public CheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToBillingContinueButton() {
        waitForElementClickable(driver, CheckOutPageUI.BILLING_CONTINUE_BUTTON);
        clickToElement(driver, CheckOutPageUI.BILLING_CONTINUE_BUTTON);
    }
    public void clickToShippingContinueButton() {
        waitForElementClickable(driver, CheckOutPageUI.SHIPPING_CONTINUE_BUTTON);
        clickToElement(driver, CheckOutPageUI.SHIPPING_CONTINUE_BUTTON);
    }

    public void clickToPaymentMethodContinueButton() {
        waitForElementClickable(driver, CheckOutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
        clickToElement(driver, CheckOutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    public void clickToPaymentInformationContinueButton() {
        waitForElementClickable(driver, CheckOutPageUI.PAYMENT_INFORMATION_CONTINUE_BUTTON);
        clickToElement(driver, CheckOutPageUI.PAYMENT_INFORMATION_CONTINUE_BUTTON);
    }
}
