package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUI.DashBoardPageUI;
import pageUI.HomePageUI;
import pageUI.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNameProducDisplayedInShoppingCart(String dynamicNameProduct) {
        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_NAME_PRODUCT_BY_TEXT, dynamicNameProduct);
        return isElementDisplayed(driver, ShoppingCartPageUI.DYNAMIC_NAME_PRODUCT_BY_TEXT, dynamicNameProduct);
    }
    public String getTextInforProductInShoppingCart(){
        waitForListElementVisible(driver, ShoppingCartPageUI.INFOR_PRODUCT_IN_CART);
        return getElementText(driver, ShoppingCartPageUI.INFOR_PRODUCT_IN_CART);
    }
    public boolean isInforProductDisplayeInShoppingCart(String inforProducts){
        return getTextInforProductInShoppingCart().contains(inforProducts);
    }
    public float unitPriceInShoppingCart(String nameProduct){
        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_UNIT_PRICE_BY_NAME_PRODUCT, nameProduct);
        String unitPriceText = getElementText(driver, ShoppingCartPageUI.DYNAMIC_UNIT_PRICE_BY_NAME_PRODUCT, nameProduct);
        String unit = unitPriceText.substring(unitPriceText.indexOf("$")+1);
        return Float.parseFloat(unit.replace(",", ""));
    }
    public float quantityInShoppingCart(String attributeName, String nameProduct){
        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_QTY_BY_NAME_PRODUCT, nameProduct);
        String quantityText = getElementAttribute(driver, ShoppingCartPageUI.DYNAMIC_QTY_BY_NAME_PRODUCT, attributeName, nameProduct);
        return Float.parseFloat(quantityText);
    }
    public float SubTotalInShoppingCart(String nameProduct){
        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_SUBTOTAL_BY_NAME_PRODUCT, nameProduct);
        String subTotalText = getElementText(driver, ShoppingCartPageUI.DYNAMIC_SUBTOTAL_BY_NAME_PRODUCT, nameProduct);
        String subTotal = subTotalText.substring(subTotalText.indexOf("$")+1);
        return Float.parseFloat(subTotal.replace(",", ""));
    }

    public void clickToEditLink() {
        waitForElementClickable(driver, ShoppingCartPageUI.EDIT_LINK);
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK);
    }
}
