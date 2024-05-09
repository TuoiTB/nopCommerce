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

@Epic("Search")
@Feature("Sort_Paging")
public class Sort_Paging extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    SearchPageObject searchPage;

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        driver = getBrowserEnvironment(browserName, serverName);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.loginToSystem(Register_01_Main_Flow.email, Register_01_Main_Flow.password);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.openNotebooks();
        searchPage = PageGeneratorManager.getSearchPage(driver);
    }

    @Test(priority = 1)
    public void Sort_with_name_A_to_Z() {
        log.info("Step 01: Sort with name A to Z");
        searchPage.sortByPosition("Name: A to Z");

        log.info("Step 02: Verify product name is sorted A to Z");
        verifyTrue(searchPage.isProductNameSortAscending());
    }
    @Test(priority = 2)
    public void Sort_with_name_Z_to_A() {
        log.info("Step 01: Sort with name A to Z");
        searchPage.sortByPosition("Name: Z to A");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify product name is sorted Z to A");
        verifyTrue(searchPage.isProductNameSortDescending());
    }
    @Test(priority = 3)
    public void Sort_with_price_low_to_high() {
        log.info("Step 01: Sort with name A to Z");
        searchPage.sortByPosition("Price: Low to High");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify product price is sorted Low to High");
        verifyTrue(searchPage.isProductPriceSortLowToHigh());
    }
    @Test(priority = 4)
    public void Sort_with_price_high_to_low() {
        log.info("Step 01: Sort with name A to Z");
        searchPage.sortByPosition("Price: High to Low");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify product price is sorted High to Low");
        verifyTrue(searchPage.isProductPriceSortHighToLow());
    }
    @Test(priority = 5)
    public void Displayed_3products_1page() {
        log.info("Step 01: Choose 3 products per page");
        searchPage.chooseNumberProductInDisplayPerPageByText("3");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify 3 product in per page");
        verifyEquals(searchPage.getNumberProduct(), 3);

        log.info("Step 03: Verify next page icon in the first page");
        verifyTrue(searchPage.isNextPageIconDisplayed());

        log.info("Step 04: Click to next page icon");
        searchPage.clickToNextPageIcon();

        log.info("Step 05: Verify previous page icon in the second page");
        verifyTrue(searchPage.isPreviousPageIconDisplayed());
    }
    @Test(priority = 6)
    public void Displayed_6products_1page() {
        log.info("Step 01: Choose 6 products per page");
        searchPage.chooseNumberProductInDisplayPerPageByText("6");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify 6 product in per page");
        verifyEquals(searchPage.getNumberProduct(), 6);

        log.info("Step 03: Verify Paging Not Displayed");
        verifyTrue(searchPage.isPagingNotDisplayed());
    }
    @Test(priority = 7)
    public void Displayed_9products_1page() {
        log.info("Step 01: Choose 9 products per page");
        searchPage.chooseNumberProductInDisplayPerPageByText("9");
        searchPage.sleepInSecond(3);
        log.info("Step 02: Verify 9 product in per page");
        verifyTrue(searchPage.isNumberProductLessThan9());

        log.info("Step 03: Verify Paging Not Displayed");
        verifyTrue(searchPage.isPagingNotDisplayed());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
