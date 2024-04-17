package pageUI;
public class ShoppingCartPageUI {
    public static final String DYNAMIC_NAME_PRODUCT_BY_TEXT = "XPATH=//td[@class='product']//a[text()='%s']";
    public static final String INFOR_PRODUCT_IN_CART = "css=td.product>div.attributes";
    public static final String DYNAMIC_UNIT_PRICE_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='unit-price']/span";
    public static final String DYNAMIC_QTY_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
    public static final String DYNAMIC_SUBTOTAL_BY_NAME_PRODUCT = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span";
    public static final String EDIT_LINK = "CSS=div.edit-item a";

}
