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
        dashBoardPage.clickToCloseButton();
        log.info("Step 02: Verify message is displayed ");
        verifyTrue(dashBoardPage.isAddProductToWishlistSuccessfullyMessageDisplayed());

        log.info("Step 03: Access wishlist page");
        dashBoardPage.clickToWishlistLink();

        log.info("Step 04: Verify product is added to wishlist successfully");
        verifyTrue(dashBoardPage.isProductDisplayed());

        log.info("Step 05: Click to sharing link");
        dashBoardPage.clickToSharingLink();

        log.info("Step 06: Verify sharing link is viewed");
        verifyEquals(dashBoardPage.getTextOfTitleInSharingLink(), "Wishlist of " + Register_01_Main_Flow.firstName + " " + Register_01_Main_Flow.lastName);
    }
    @Test(priority = 2)
    public void Add_product_to_cart_from_wishlist() {
        log.info("Step 01: Add product to cart");
        dashBoardPage.checkToAddToCartCheckbox();

        log.info("Step 02: Verify product is added to cart");
        dashBoardPage.clickToAddToCartButton();

        log.info("Step 03: Verify product is added to cart");
        verifyTrue(dashBoardPage.isProductDisplayed());

        log.info("Step 04: Verify product is deleted in wishlist");
        verifyFalse(dashBoardPage.isProductDisplayed());
    }
    @Test(priority = 3)
    public void Remove_product_in_wishlist_page() {
        log.info("Step 01: Choose any product and add to wishlist");
        dashBoardPage.clickToHomeImage();
        dashBoardPage.clickToProduct();
        dashBoardPage.clickToWishlistButton();

        log.info("Step 02: Verify message is displayed ");
        verifyTrue(dashBoardPage.isAddProductToWishlistSuccessfullyMessageDisplayed());
        dashBoardPage.clickToCloseButton();

        log.info("Step 03: Access wishlist page");
        dashBoardPage.clickToWishlistLink();

        log.info("Step 04: Remove product in witshlist");
        dashBoardPage.clickToRemoveButton();

        log.info("Step 05: Verify message is displayed");
        verifyEquals(dashBoardPage.getTextRemoveMessage(), "The wishlist is empty!");

        log.info("Step 06: Verify product is undisplayed in wishlist");
        verifyFalse(dashBoardPage.isProductDisplayed());
    }
    @Test(priority = 4)
    public void Add_product_to_compare() {
        log.info("Step 01: Add two products to compare");


        log.info("Step 02: Verify message is displayed");


        log.info("Step 03: Access to compare wishlist");


        log.info("Step 04: Verify all information is displayed");


        log.info("Step 05: Click 'CLEAR LIST' button");


        log.info("Step 06: Verify message is displayed");


        log.info("Step 07: Verify two products at step 1 is undisplayed in compare page");

    }
    @Test(priority = 5)
    public void Recently_viewed_products() {
        String product_1 = "";
        String product_2 = "";
        String product_3 = "";
        String product_4 = "";
        String product_5 = "";
        log.info("Step 01: View detail of any 5 products");
        log.info("Step 02: Access Recently viewed products page");
        log.info("Step 03: Verify that only the last 3 viewed products are displayed");

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
