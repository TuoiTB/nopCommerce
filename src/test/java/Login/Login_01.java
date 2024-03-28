package Login;

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
import utitlities.DataFaker;

@Epic("Customer")
@Feature("Create Customer")
public class Login_01 extends BaseTest {
    private WebDriver driver;
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
    }
    @Test(priority = 1)
    public void Login_With_Empty_Data() {
        log.info("Step 01: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 02: Verify error message displayed");
        verifyTrue(loginPage.isEmailErrorMessageDisplayed());
    }
    @Test(priority = 2)
    public void Login_With_Invalid_Email() {
        log.info("Step 01: Input to Email");
        loginPage.refreshCurrentPage(driver);
        loginPage.inputToEmail("email.test");
        log.info("Step 02: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 03: Verify error message displayed");
        verifyTrue(loginPage.isEmailErrorMessageDisplayed());
    }
    @Test(priority = 3)
    public void Login_With_Email_Not_Register() {
        log.info("Step 01: Input to Email");
        loginPage.refreshCurrentPage(driver);
        loginPage.inputToEmail("email@test.com");
        log.info("Step 02: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 03: Verify error message displayed");
        verifyTrue(loginPage.isEmailNotRegisterErrorMessageDisplayed());
    }
    @Test(priority = 4)
    public void Login_With_Exist_Email_And_Blank_Password() {
        log.info("Step 01: Input to Email");
        loginPage.refreshCurrentPage(driver);
        loginPage.inputToEmail(Register_01_Main_Flow.email);
        log.info("Step 02: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 03: Verify error message displayed");
        verifyTrue(loginPage.isEmailNotRegisterErrorMessageDisplayed());
    }
    @Test(priority = 5)
    public void Login_With_Exist_Email_And_Invalid_Password() {
        log.info("Step 01: Input to Email");
        loginPage.refreshCurrentPage(driver);
        loginPage.inputToEmail(Register_01_Main_Flow.email);
        log.info("Step 02: Input to Password");
        loginPage.inputToPassword("1233");
        log.info("Step 03: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 04: Verify error message displayed");
        verifyTrue(loginPage.isEmailNotRegisterErrorMessageDisplayed());
    }
    @Test(priority = 6)
    public void Login_With_Valid_Email_And_Password() {
        log.info("Step 01: Input to Email");
        loginPage.refreshCurrentPage(driver);
        loginPage.inputToEmail(Register_01_Main_Flow.email);
        log.info("Step 02: Input to Password");
        loginPage.inputToPassword(Register_01_Main_Flow.password);
        log.info("Step 03: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 04: Verify login successfully");
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        verifyTrue(dashBoardPage.isLoginSuccessfully());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
