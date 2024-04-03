package Search;

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

@Epic("Customer")
@Feature("Create Customer")
public class Sort_Paging extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    SearchPageObject searchPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.loginToSystem(Register_01_Main_Flow.email, Register_01_Main_Flow.password);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.openSubmenu("Notebooks ");
    }

    @Test(priority = 1)
    public void Sort_with_name_A_to_Z() {
        log.info("Step 01: Sort with name A to Z");
        dashBoardPage.sortByPosition("Name: A to Z");

        log.info("Step 02: Verify product name is sorted A to Z");
        verifyTrue(dashBoardPage.isProductNameSortAscending());
    }
    @Test(priority = 2)
    public void Sort_with_name_Z_to_A() {
        log.info("Step 01: Sort with name A to Z");
        dashBoardPage.sortByPosition("Name: Z to A");

        log.info("Step 02: Verify product name is sorted Z to A");
        verifyTrue(dashBoardPage.isProductNameSortDescending());
    }
    @Test(priority = 3)
    public void Sort_with_price_low_to_high() {
        log.info("Step 01: Sort with name A to Z");
        dashBoardPage.sortByPosition("Price: Low to High");

        log.info("Step 02: Verify product price is sorted Low to High");
        verifyTrue(dashBoardPage.isProductPriceSortLowToHigh());
    }
    @Test(priority = 4)
    public void Sort_with_price_high_to_low() {
        log.info("Step 01: Sort with name A to Z");
        dashBoardPage.sortByPosition("Price: High to Low");

        log.info("Step 02: Verify product price is sorted High to Low");
        verifyTrue(dashBoardPage.isProductPriceSortHighToLow());
    }
    @Test(priority = 5)
    public void Displayed_3products_1page() {
        log.info("Step 01: ");
        dashBoardPage.;

        log.info("Step 02: Verify ");
        verifyTrue();
    }
    @Test(priority = 6)
    public void Displayed_6products_1page() {
        log.info("Step 01: ");
        dashBoardPage.;

        log.info("Step 02: Verify ");
        verifyTrue();
    }
    @Test(priority = 7)
    public void Displayed_9products_1page() {
        log.info("Step 01: ");
        dashBoardPage.;

        log.info("Step 02: Verify ");
        verifyTrue();
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
