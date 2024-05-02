package pageUI;


public class CheckOutPageUI {
    public static final String  BILLING_CONTINUE_BUTTON = "xpath=//div[@id='billing-buttons-container']//button[@name='save']";
    public static final String  SHIPPING_CONTINUE_BUTTON = "xpath=//div[@id='shipping-method-buttons-container']//button";
    public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "xpath=//div[@id='payment-method-buttons-container']//button";
    public static final String PAYMENT_INFORMATION_CONTINUE_BUTTON = "xpath=//div[@id='payment-info-buttons-container']//button";
    public static final String CONFIRM_CONTINUE_BUTTON = "CSS=button.confirm-order-next-step-button";
    public static final String MESSAGE_SUCCESSFUL_ORDER = "xpath=//strong[text()='Your order has been successfully processed!']";
    public static final String THANKYOU_MESSAGE_ORDER = "xpath=//h1[text()='Thank you']";
    public static final String ORDER_NUMBER = "xpath=//strong[text()='Order number: 1032']";
    public static final String ORDER_DETAIL_LINK = "xpath=//a[text()='Click here for order details.']";
    public static final String MY_ACCOUNT_LINK = "CSS=div.header-links a.ico-account";
    public static final String ORDER_LINK = "CSS=div.listbox li.customer-orders a";
    public static final String ORDER_NUMBER_IN_MY_ACCOUNT = "CSS=div.order-item div.title strong";
    public static final String DETAIL_BUTTON = "xpath=//button[text()='Details']";
    public static final String RE_ORDER_BUTTON = "css=button.re-order-button";
    public static final String QTY_TEXTBOX = "css=input.qty-input";
}
