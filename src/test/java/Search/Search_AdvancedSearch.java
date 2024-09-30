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
@Feature("SearchByInputKey")
public class Search_AdvancedSearch extends BaseTest {
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
        dashBoardPage.clickToSearchLinkInFooter();
        searchPage = PageGeneratorManager.getSearchPage(driver);
    }

    @Test(priority = 1)
    public void Search_with_empty_data() {
        log.info("Step 01: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 02: Verify message Search term minimum length is 3 characters is displayed");
        verifyTrue(searchPage.isMessageWarningDisplayed());
    }
    @Test(priority = 2)
    public void Search_with_data_not_exist() {
        String searchKeyword = "Macbook Pro 2050";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 03: Verify message No products were found that matched your criteria. is displayed");
        verifyTrue(searchPage.isMessageNoResultDisplayed());
    }
    @Test(priority = 3)
    public void Search_with_product_name_relative() {
        String searchKeyword = "Lenovo";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 03: Verify product is displayed");
        verifyTrue(searchPage.isProductSearchResultsRelativeDisplayed(searchKeyword));
    }
    @Test(priority = 4)
    public void Search_with_product_name_absolute() {
        String searchKeyword = "Asus N551JK-XO076H Laptop";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 03: Verify product is displayed");
        verifyTrue(searchPage.isProductSearchResultsAbsoluteDisplayed(searchKeyword));
    }
    @Test(priority = 5)
    public void Advanced_search_with_parent_category() {
        String searchKeyword = "Apple Macbook Pro";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Check to Advanced Search checkbox");
        searchPage.checkToAdvancedSearchCheckbox();

        log.info("Step 03: Select item in category dropdown");
        searchPage.selectItemInCategoryDropdown("Computers");

        log.info("Step 04: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 05: Verify message No products were found that matched your criteria. is displayed");
        verifyTrue(searchPage.isMessageNoResultDisplayed());
    }
    @Test(priority = 6)
    public void Advanced_search_with_sub_category() {
        String searchKeyword = "Apple Macbook Pro";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Check to Advanced Search checkbox");
        searchPage.checkToAdvancedSearchCheckbox();

        log.info("Step 03: Select item in category dropdown");
        searchPage.selectItemInCategoryDropdown("Computers");

        log.info("Step 04: Check to Sub Category checkbox");
        searchPage.checkSubCategoryCheckbox();

        log.info("Step 05: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 06: Verify product is displayed");
        verifyTrue(searchPage.isProductSearchResultDisplayed());
    }
    @Test(priority = 7)
    public void Advanced_search_with_incorrect_manufacturer() {
        String searchKeyword = "Apple Macbook Pro";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Check to Advanced Search checkbox");
        searchPage.checkToAdvancedSearchCheckbox();

        log.info("Step 03: Select item in category dropdown");
        searchPage.selectItemInCategoryDropdown("Computers");

        log.info("Step 04: Check to Sub Category checkbox");
        searchPage.checkSubCategoryCheckbox();

        log.info("Step 05: Select item in manufacturer");
        searchPage.selectItemInManufacturerDropdown("HP");

        log.info("Step 06: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 07: Verify message No products were found that matched your criteria. is displayed");
        verifyTrue(searchPage.isMessageNoResultDisplayed());
    }
    @Test(priority = 8)
    public void Advanced_search_with_correct_manufacturer() {
        String searchKeyword = "Apple Macbook Pro";
        log.info("Step 01: Input search keyword to Search textbox");
        searchPage.inputToSearchTextbox(searchKeyword);

        log.info("Step 02: Check to Advanced Search checkbox");
        searchPage.checkToAdvancedSearchCheckbox();

        log.info("Step 03: Select item in category dropdown");
        searchPage.selectItemInCategoryDropdown("Computers");

        log.info("Step 04: Check to Sub Category checkbox");
        searchPage.checkSubCategoryCheckbox();

        log.info("Step 05: Select item in manufacturer");
        searchPage.selectItemInManufacturerDropdown("Apple");

        log.info("Step 06: Click to Search button");
        searchPage.clickToSearchButton();

        log.info("Step 07: Verify product is displayed");
        verifyTrue(searchPage.isProductSearchResultDisplayed());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
