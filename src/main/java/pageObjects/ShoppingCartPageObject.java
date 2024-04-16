package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNameProducDisplayedInShoppingCart() {
    }
}
