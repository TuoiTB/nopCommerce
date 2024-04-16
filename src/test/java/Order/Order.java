package Wishlist_Compare_RecentView;

import Register.Register_01_Main_Flow;
import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

@Epic("Wishlist_Compare_RecentView")
@Feature("Wishlist_Compare_RecentView")
public class Wishlist_Compare_RecentView extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    ShoppingCartPageObject shoppingCartPage;
    String product;
    String processor, ram, hdd, os, software;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.loginToSystem(Register_01_Main_Flow.email, Register_01_Main_Flow.password);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.openDesktop();
        product = "Build your own computer";
    }

    @Test(priority = 1)
    public void Add_product_to_cart() {
        log.info("Step 01: Click to any product");
        dashBoardPage.clickToProduct(product);

        log.info("Step 02: Choose some info about product");
        log.info("Step 2.1");
        dashBoardPage.selectProcessorDropdown();
        log.info("Step 2.2");
        dashBoardPage.selectRAMDropdown();
        log.info("Step 2.3");
        dashBoardPage.selectHDDRadioButton();
        log.info("Step 2.4");
        dashBoardPage.selectOSRadioButton();
        log.info("Step 2.5");
        dashBoardPage.selectSoftwareCheckbox();

        log.info("Step 03: Click to Add to cart button");
        dashBoardPage.clickToAddToCartButton();

        log.info("Step 4: Verify message added to cart is displayed ");
        verifyTrue(dashBoardPage.isMessageAddedToCartDisplayed());

        log.info("Step 05: Verify product added to cart successfully");
        dashBoardPage.clickToShoppingCartLink();
        shoppingCartPage = PageGeneratorManager.getShoppingCart(driver);

        log.info("Step 5.1: Verify Name Product is Displayed In Shopping Cart");
        verifyTrue(shoppingCartPage.isNameProducDisplayedInShoppingCart());

        log.info("Step 5.2: Verify Processor is selected In Shopping Cart");

        log.info("Step 5.3: Verify RAM is selected In Shopping Cart");

        log.info("Step 5.4: Verify HDD is selected In Shopping Cart");

        log.info("Step 5.5: Verify OS is selected In Shopping Cart");

        log.info("Step 5.6: Verify Software is selected In Shopping Cart");

        log.info("Step 5.7: Verify Unit price");

        log.info("Step 5.8: Quantity");

    }
    @Test(priority = 2)
    public void Edit_product_in_shopping_cart() {
        log.info("Step 00: ");
        dashBoardPage.backToPage();
    }
    @Test(priority = 3)
    public void Remove_from_cart() {
        log.info("Step 01: ");

    }
    @Test(priority = 4)
    public void Update_shopping_cart() {
        log.info("Step 00: Add product in cart");

        log.info("Step 01: Update quantity = 5");

        log.info("Step 02: Click update shopping cart button");

        log.info("Step 03: Verify total = $2,500.00 ");

    }
    @Test(priority = 5)
    public void Checkout_with_cheque_method() {
        log.info("Step 01: Add any product to shopping cart");
        dashBoardPage.clickToHomeImage();
        dashBoardPage.clickToProduct(product);

        log.info("Step 02: Access Recently viewed products page");
        dashBoardPage.clickToRecentViewProductsLinkInFooter();

        log.info("Step 03: Input valid information");

        log.info("Step 04: Click Checkout button");

        log.info("Step 05: Input valid information to Billing address");
        log.info("Step 5.1: Check to Ship to the same address checkbox");

        log.info("Step 5.2: Selected New Address dropdown");

        log.info("Step 5.3: Input First name textbox");

        log.info("Step 5.4: Input Last name textbox");

        log.info("Step 5.5: Input Email textbox");

        log.info("Step 5.6: Selected Country dropdown");

        log.info("Step 5.7: Selected State/province dropdown");

        log.info("Step 5.8: Input City textbox");

        log.info("Step 5.9: Input Address 1 textbox");

        log.info("Step 5.10: Input Address 2 textbox");

        log.info("Step 5.11: Input Zip/postal code textbox");

        log.info("Step 5.12: Input Phone number textbox");

        log.info("Step 5.13: Click to Continue button");

        log.info("Step 06: Input valid information to Shipping address");
        log.info("Step 6.1: Check to Ship to the same address checkbox");

        log.info("Step 6.2: Selected New Address dropdown");

        log.info("Step 6.3: Input First name textbox");

        log.info("Step 6.4: Input Last name textbox");

        log.info("Step 6.5: Input Email textbox");

        log.info("Step 6.6: Selected Country dropdown");

        log.info("Step 6.7: Selected State/province dropdown");

        log.info("Step 6.8: Input City textbox");

        log.info("Step 6.9: Input Address 1 textbox");

        log.info("Step 6.10: Input Address 2 textbox");

        log.info("Step 6.11: Input Zip/postal code textbox");

        log.info("Step 6.12: Input Phone number textbox");

        log.info("Step 6.13: Click to Continue button");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
