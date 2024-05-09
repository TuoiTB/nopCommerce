package Register;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.DataFaker;

@Epic("Customer")
@Feature("Create Customer")
public class Register_02_Validation extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    //Register_01_Main_Flow register01MainFlow = new Register_01_Main_Flow();
    /*private String firstName;
    private String lastName;
    private String email;
    private String password;*/
    DataFaker dataFaker = new DataFaker();
    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        driver = getBrowserEnvironment(browserName, serverName);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToRegisterLink();
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        /*firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        email = dataFaker.getEmailAddress();
        password = dataFaker.getPassword();*/
    }

    @Test(priority = 0)
    public void Register_with_empty_data() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterButton();

        log.info("Step 02: Verify messages is required");
        verifyTrue(registerPage.isMessageRequiredDisplayedByText("First name"));
        verifyTrue(registerPage.isMessageRequiredDisplayedByText("Last name"));
        verifyTrue(registerPage.isMessageRequiredDisplayedByText("Email"));
        verifyTrue(registerPage.isMessageRequiredDisplayedByText("Password"));
        verifyTrue(registerPage.isMessageRequiredDisplayedByText("Password"));
    }
    @Test(priority = 1)
    public void Register_with_invalid_email() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(Register_01_Main_Flow.firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(Register_01_Main_Flow.lastName);

        log.info("Step 04: Input to Email");
        registerPage.inputToEmail("Tuoi.mail");

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(Register_01_Main_Flow.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(Register_01_Main_Flow.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Step 08: Verify messages is displayed");
        verifyTrue(registerPage.isEmailWrongMessageDisplayed());
    }
    @Test(priority = 2)
    public void Register_with_all_valid_required_data() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(Register_01_Main_Flow.firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(Register_01_Main_Flow.lastName);

        log.info("Step 04: Input to Email");
        registerPage.inputToEmail(Register_01_Main_Flow.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(Register_01_Main_Flow.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(Register_01_Main_Flow.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();
    }
    @Test(priority = 3)
    public void Register_with_existed_email() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(Register_01_Main_Flow.firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(Register_01_Main_Flow.lastName);

        log.info("Step 04: Input to Email");
        registerPage.inputToEmail("Tuoitb@mail.com");

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(Register_01_Main_Flow.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(Register_01_Main_Flow.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isEmailExistedMessageDisplayed());
    }
    @Test(priority = 4)
    public void Register_with_password_less_than_6_characters() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(Register_01_Main_Flow.firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(Register_01_Main_Flow.lastName);

        log.info("Step 04: Input to Email");
        registerPage.inputToEmail(Register_01_Main_Flow.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword("1234");

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword("1234");

        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isPasswordLessThanSixCharactersMessageDisplayed());
    }

    @Test(priority = 5)
    public void Register_with_password_and_confirm_password_not_match() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToRegisterLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputToFirstName(Register_01_Main_Flow.firstName);

        log.info("Step 03: Input to Last Name");
        registerPage.inputToLastName(Register_01_Main_Flow.lastName);

        log.info("Step 04: Input to Email");
        registerPage.inputToEmail(Register_01_Main_Flow.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(Register_01_Main_Flow.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword("1234");

        log.info("Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
