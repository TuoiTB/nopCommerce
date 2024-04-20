package pageUI;

import org.openqa.selenium.WebElement;

public class ShoppingCartPageUI {
    public static final String DYNAMIC_NAME_PRODUCT_BY_TEXT = "XPATH=//td[@class='product']//a[text()='%s']";
    public static final String INFOR_PRODUCT_IN_CART = "css=td.product>div.attributes";
    public static final String DYNAMIC_UNIT_PRICE_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='unit-price']/span";
    public static final String DYNAMIC_QTY_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
    public static final String DYNAMIC_SUBTOTAL_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span";
    public static final String EDIT_LINK = "CSS=div.edit-item a";
    public static final String REMOVE_BUTTON = "CSS=button.remove-btn";

    public static final String UPDATE_CART_BUTTON = "css=button#updatecart";
    public static final String EMPTY_MESSAGE = "xpath=//div[contains(text(),'Your Shopping Cart is empty!')]";
    public static final String CHECKOUT_BUTTON = "CSS=button#checkout";
    public static final String TERM_OF_SERVICE_CHECK_BOX = "CSS=input#termsofservice";
}
