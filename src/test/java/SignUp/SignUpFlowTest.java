package SignUp;

import commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import utilities.DataFaker;

@Epic("Account")
@Feature("Register account")
public class SignUpFlowTest extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    SignUpPageObject signUpPage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    YopmailPageObject yopmailPage;
    public static String fullName;
    public static String prefixEmail;
    public static String email;
    public static String password = "Tt@12345678";
    public static String phoneNumber;
    private String yopmail;
    private String productLink;
    private String product ;
    private static final String randomEmail = generateRandomEmail();
    private static final String randomEmail_1 = generateRandomEmail();
    private static final String randomEmail_2 = generateRandomEmail();
    private static final String randomEmail_3 = generateRandomEmail();

    DataFaker dataFaker = new DataFaker();
    @Parameters({"browser", "server", "yopmail", "productLink"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName, String yopmail, String productLink) {
        driver = getBrowserEnvironment(browserName, serverName);
        fullName = dataFaker.getFirstName() + " " + dataFaker.getLastName();
        //prefixEmail = "auto-ui-" + getNumberRandom();
        phoneNumber = getPhoneNumberRandom();
        this.yopmail = yopmail ;
        this.productLink = productLink;
        product = "https://online.iigvietnam.com/";
    }
    @DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
                {randomEmail_1, password},
                {randomEmail_2, password},
                {randomEmail_3, password}
        };
    }
    @Description("Account 01 - Register account successfully")
    @Story("Register to system")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "testData")
    public void registerWithAllValidRequiredData(String randomEmail, String password) {
        log.info("Step 01: Get email in yopmail");
        yopmailPage = PageGeneratorManager.getYopmailPage(driver);
        yopmailPage.openUrl(driver, yopmail);
        yopmailPage.inputToEmail(randomEmail);
        yopmailPage.clickToForwardButton();

        log.info("Step 02: Switch to homepage");
        yopmailPage.openUrl(driver, productLink);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToCreateAccountButton();
        signUpPage = PageGeneratorManager.getSignUpPage(driver);

        log.info("Step 03: Input to Email");
        signUpPage.inputEmailAddress(randomEmail);

        log.info("Step 04: Input to Full Name");
        signUpPage.inputToFullName(fullName);

        log.info("Step 05: Input to phone number");
        signUpPage.inputToPhoneNumber(phoneNumber);

        log.info("Step 06: Input to Password");
        signUpPage.inputToPassword(password);

        log.info("Step 07: Input to Confirm Password");
        signUpPage.inputToConfirmPassword(password);

        log.info("Step 08: Click to Register button");
        signUpPage.clickToSignUpButton();

        log.info("Step 09: Verify message register successfully");
        verifyTrue(signUpPage.isSignUpSuccessfullyMessageDisplayed());

        log.info("Step 10: Switch to yopmail");
        signUpPage.openUrl(driver, yopmail);
        yopmailPage = PageGeneratorManager.getYopmailPage(driver);

        log.info("Step 11: Click to refresh button");
        yopmailPage.clickToForwardButton();
        yopmailPage.sleepInSecond(5);
        yopmailPage.clickToRefreshButton();

        log.info("Step 12: Click to confirm account button");
        yopmailPage.sleepInSecond(5);
        yopmailPage.clickToConfirmAccountButton(randomEmail);
        yopmailPage.sleepInSecond(2);

        log.info("Step 13: Switch window tab");
        yopmailPage.switchToWindowByTitle(driver, product);

        log.info("Step 14: Verify current url");
        verifyEquals(yopmailPage.getPageUrl(driver), product);
        //verifyEquals(yopmailPage.getPageUrl(driver), "https://topik.iigvietnam.com/registration/lichthi");
        System.out.println(yopmailPage.getPageUrl(driver));
        System.out.println(randomEmail);

    }
    @Test(priority = 2,dataProvider = "testData")
    public void loginSuccessfully(String email, String password) {
        log.info("Step 01: Click Login Link");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.openUrl(driver, productLink);
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
        verifyEquals(dashBoardPage.getTextAccount(), email);
    }

    // @Test()
    public void loginUnsuccessfullyWithEmailHaveNotVerified() {
        log.info("Step 01: Click Login Link");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.clickToLoginLink();
        log.info("Step 02: Input to Email");
        loginPage.inputToEmail(randomEmail);
        log.info("Step 03: Input to Password");
        loginPage.inputToPassword(password);
        log.info("Step 04: Click Login Button");
        loginPage.clickToLoginButton();
        log.info("Step 05: Verify login unsuccessfully");
        verifyTrue(loginPage.isEmailHaveNotVerifiedMessage());
    }
    //@Test(dependsOnMethods = "registerWithAllValidRequiredData")
    public void verifyEmail() {
        log.info("Step 01: Click Login Link");
        loginPage.openUrl(driver, yopmail);
        yopmailPage = PageGeneratorManager.getYopmailPage(driver);
        log.info("Step 02: Input to Email");
        yopmailPage.inputToEmail(randomEmail);
        log.info("Step 03: Click to refresh button");
        yopmailPage.clickToForwardButton();
        log.info("Step 04: ");

        log.info("Step 05: Verify login unsuccessfully");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //quitBrowserDriver();
    }
}
