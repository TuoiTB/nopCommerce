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
    public void clickToConfirmContinueButton() {
        waitForElementClickable(driver, CheckOutPageUI.CONFIRM_CONTINUE_BUTTON);
        clickToElement(driver, CheckOutPageUI.CONFIRM_CONTINUE_BUTTON);
    }
    public void clickToOrderDetailLink() {
        waitForElementClickable(driver, CheckOutPageUI.ORDER_DETAIL_LINK);
        clickToElement(driver, CheckOutPageUI.ORDER_DETAIL_LINK);
    }

    public boolean isMessageSuccessfullyDisplayed() {
        waitForElementVisible(driver, CheckOutPageUI.MESSAGE_SUCCESSFUL_ORDER);
        return isElementDisplayed(driver, CheckOutPageUI.MESSAGE_SUCCESSFUL_ORDER);
    }
    public boolean isThankYouMessageDisplayed() {
        waitForElementVisible(driver, CheckOutPageUI.THANKYOU_MESSAGE_ORDER);
        return isElementDisplayed(driver, CheckOutPageUI.THANKYOU_MESSAGE_ORDER);
    }

    public String getOrderNumber() {
        return getElementText(driver, CheckOutPageUI.ORDER_NUMBER);
    }

    public void clickMyAccountInHeader() {
        waitForElementClickable(driver, CheckOutPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, CheckOutPageUI.MY_ACCOUNT_LINK);
    }
    public void clickOrderLink() {
        waitForElementClickable(driver, CheckOutPageUI.ORDER_LINK);
        clickToElement(driver, CheckOutPageUI.ORDER_LINK);
    }

    public String getTextOrderNumber() {
        return getElementText(driver, CheckOutPageUI.ORDER_NUMBER_IN_MY_ACCOUNT);
    }

    public void clickToDetailButton() {
        waitForElementClickable(driver, CheckOutPageUI.DETAIL_BUTTON);
        clickToElement(driver, CheckOutPageUI.DETAIL_BUTTON);
    }

    public void clickReOrderButton() {
        waitForElementClickable(driver, CheckOutPageUI.DETAIL_BUTTON);
        clickToElement(driver, CheckOutPageUI.DETAIL_BUTTON);
    }

    public void inputQty(String qty) {
        waitForElementVisible(driver, CheckOutPageUI.QTY_TEXTBOX);
        sendkeyToElement(driver, CheckOutPageUI.QTY_TEXTBOX, qty);
    }
}
