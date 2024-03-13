package Login;

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
    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    DataFaker dataFaker = new DataFaker();
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        email = dataFaker.getEmailAddress();
        password = dataFaker.getPassword();
    }
    @Test(priority = 0)
    public void Login_With_Empty_Data() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterButton();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(lastName);
        log.info("Step 04: Input to Email");
        registerPage.inputToEmail(email);
        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(password);
        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(password);
        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();
        log.info("Step 08: Verify message register successfully");
        verifyTrue(registerPage.isMessageRegisterSuccessfullyDisplayed());
    }
    @Test(priority = 1)
    public void Login() {
        log.info("Step 01: Click Login Link");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.clickToLoginLink();
        log.info("Step 02: Input to Email");
        loginPage.inputToEmail(email);
        log.info("Step 03: Input to Password");
        loginPage.inputToPassword(password);
        log.info("Step 04: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 05: Verify login successfully");
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        verifyTrue(dashBoardPage.isLoginSuccessfully());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
