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

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.loginToSystem(Register_01_Main_Flow.email, Register_01_Main_Flow.password);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
    }

    @Test(priority = 1)
    public void Add_to_wishlist() {
        log.info("Step 01: Choose any product and add to wishlist");
        dashBoardPage.clickToProduct();
        dashBoardPage.clickToWishlistButton();
        log.info("Step 02: Verify message is displayed ");
        verifyTrue(dashBoardPage.isAddProductToWishlistSuccessfullyMessageDisplayed());
        //dashBoardPage.clickToCloseButton();

        log.info("Step 03: Access wishlist page");
        dashBoardPage.clickToWishlistLink();

        log.info("Step 04: Verify product is added to wishlist successfully");
        verifyTrue(dashBoardPage.isProductDisplayedInWishlist());

        log.info("Step 05: Click to sharing link");
        dashBoardPage.clickToSharingLink();

        log.info("Step 06: Verify sharing link is viewed");
        verifyEquals(dashBoardPage.getTextOfTitleInSharingLink(), "Wishlist of " + Register_01_Main_Flow.firstName + " " + Register_01_Main_Flow.lastName);
    }
    @Test(priority = 2)
    public void Add_product_to_cart_from_wishlist() {
        log.info("Step 00: Back to wishlist page");
        dashBoardPage.backToPage();

        log.info("Step 01: Add product to cart");
        dashBoardPage.checkToAddToCartCheckbox();

        log.info("Step 02: Add product to cart");
        dashBoardPage.clickToAddToCartButton();

        log.info("Step 03: Verify product is added to cart");
        verifyTrue(dashBoardPage.isProductDisplayedInShoppingCart());

        log.info("Step 04: Click to Wishlist in header");
        dashBoardPage.clickToWishlistInHeader();

        log.info("Step 05: Verify product is deleted in wishlist");
        verifyTrue(dashBoardPage.isMessageProductEmptyDisplayed());
    }
    @Test(priority = 3)
    public void Remove_product_in_wishlist_page() {
        log.info("Step 01: Choose any product and add to wishlist");
        dashBoardPage.clickToHomeImage();
        dashBoardPage.clickToProduct();
        dashBoardPage.clickToWishlistButton();

        log.info("Step 02: Verify message is displayed ");
        verifyTrue(dashBoardPage.isAddProductToWishlistSuccessfullyMessageDisplayed());

        log.info("Step 03: Access wishlist page");
        dashBoardPage.clickToWishlistLink();

        log.info("Step 04: Remove product in witshlist");
        dashBoardPage.clickToRemoveButton();

        log.info("Step 05: Verify message is displayed");
        verifyEquals(dashBoardPage.getTextRemoveMessage(), "The wishlist is empty!");

        log.info("Step 06: Verify product is undisplayed in wishlist");
        verifyTrue(dashBoardPage.isProductUnDisplayed());
    }
    @Test(priority = 4)
    public void Add_product_to_compare() {
        log.info("Step 00: Click to home image");
        dashBoardPage.clickToHomeImage();

        log.info("Step 01: Add two products to compare and Verify message is displayed");
        String nameProduct1 = "Build your own computer";
        String nameProduct2 = "HTC One M8 Android L 5.0 Lollipop";

        dashBoardPage.addProductToComparisionByName(nameProduct1);
        verifyTrue(dashBoardPage.isComparisionMessageDisplayed());
        dashBoardPage.sleepInSecond(2);
        dashBoardPage.addProductToComparisionByName(nameProduct2);
        verifyTrue(dashBoardPage.isComparisionMessageDisplayed());
        dashBoardPage.sleepInSecond(2);

        log.info("Step 02: Access to compare wishlist");
        dashBoardPage.clickToCompareLink();

        log.info("Step 03: Verify name product 1 is displayed");
        verifyTrue(dashBoardPage.isProductInComparisionDisplayedByName(nameProduct1));

        log.info("Step 03: Verify name product 2 is displayed");
        verifyTrue(dashBoardPage.isProductInComparisionDisplayedByName(nameProduct2));

        log.info("Step 04: Click 'CLEAR LIST' button");
        dashBoardPage.clickToClearButton();

        log.info("Step 05: Verify message is displayed");
        verifyTrue(dashBoardPage.isClearComparisionMessageDisplayed());

        log.info("Step 06: Verify two products at step 1 is undisplayed in compare page");
        verifyTrue(dashBoardPage.isProductInComparisionUnDisplayedByName(nameProduct1));
        verifyTrue(dashBoardPage.isProductInComparisionUnDisplayedByName(nameProduct2));
    }
    @Test(priority = 5)
    public void Recently_viewed_products() {
        dashBoardPage.clickToHomeImage();
        dashBoardPage.openNotebooks();
        String product_1 = "Apple MacBook Pro 13-inch";
        String product_2 = "Asus N551JK-XO076H Laptop";
        String product_3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        String product_4 = "HP Spectre XT Pro UltraBook";
        String product_5 = "Lenovo Thinkpad X1 Carbon Laptop";

        log.info("Step 01: View detail of any 5 products");
        dashBoardPage.clickToProduct(product_1);
        dashBoardPage.backToPage();
        dashBoardPage.clickToProduct(product_2);
        dashBoardPage.backToPage();
        dashBoardPage.clickToProduct(product_3);
        dashBoardPage.backToPage();
        dashBoardPage.clickToProduct(product_4);
        dashBoardPage.backToPage();
        dashBoardPage.clickToProduct(product_5);
        dashBoardPage.backToPage();

        log.info("Step 02: Access Recently viewed products page");
        dashBoardPage.clickToRecentViewProductsLinkInFooter();

        log.info("Step 03: Verify that only the last 3 viewed products are displayed");
        verifyTrue(dashBoardPage.isProductInRecentViewDisplayedByName(product_5));
        verifyTrue(dashBoardPage.isProductInRecentViewDisplayedByName(product_4));
        verifyTrue(dashBoardPage.isProductInRecentViewDisplayedByName(product_3));
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
