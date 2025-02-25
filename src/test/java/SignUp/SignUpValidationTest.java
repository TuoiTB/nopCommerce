package SignUp;

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
import pageObjects.SignUpPageObject;
import utilities.DataFaker;

@Epic("Customer")
@Feature("Create Customer")
public class SignUpValidationTest extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    SignUpPageObject registerPage;
    //SignUpFlowTest register01MainFlow = new SignUpFlowTest();
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
        homePage.clickToCreateAccountButton();
        registerPage = PageGeneratorManager.getSignUpPage(driver);
        /*firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        email = dataFaker.getEmailAddress();
        password = dataFaker.getPassword();*/
    }

    @Test(priority = 0)
    public void Register_with_empty_data() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToSignUpButton();

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
        registerPage.clickToSignUpLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputEmailAddress(SignUpFlowTest.fullName);

        log.info("Step 04: Input to Email");
        registerPage.inputEmailAddress("Tuoi.mail");

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(SignUpFlowTest.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(SignUpFlowTest.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToSignUpButton();

        log.info("Step 08: Verify messages is displayed");
        verifyTrue(registerPage.isEmailWrongMessageDisplayed());
    }
    @Test(priority = 2)
    public void Register_with_all_valid_required_data() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToSignUpLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputEmailAddress(SignUpFlowTest.fullName);

        log.info("Step 04: Input to Email");
        registerPage.inputEmailAddress(SignUpFlowTest.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(SignUpFlowTest.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(SignUpFlowTest.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToSignUpButton();
    }
    @Test(priority = 3)
    public void Register_with_existed_email() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToSignUpLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputEmailAddress(SignUpFlowTest.fullName);

        log.info("Step 04: Input to Email");
        registerPage.inputEmailAddress("Tuoitb@mail.com");

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(SignUpFlowTest.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword(SignUpFlowTest.password);

        log.info("Step 07: Click to Register button");
        registerPage.clickToSignUpButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isEmailExistedMessageDisplayed());
    }
    @Test(priority = 4)
    public void Register_with_password_less_than_6_characters() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToSignUpLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputEmailAddress(SignUpFlowTest.fullName);

        log.info("Step 04: Input to Email");
        registerPage.inputEmailAddress(SignUpFlowTest.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword("1234");

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword("1234");

        log.info("Step 07: Click to Register button");
        registerPage.clickToSignUpButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isPasswordLessThanSixCharactersMessageDisplayed());
    }

    @Test(priority = 5)
    public void Register_with_password_and_confirm_password_not_match() {
        log.info("Step 01: Click Register Button");
        registerPage.clickToSignUpLink();

        log.info("Step 02: Input to First Name");
        registerPage.inputEmailAddress(SignUpFlowTest.fullName);

        log.info("Step 04: Input to Email");
        registerPage.inputEmailAddress(SignUpFlowTest.email);

        log.info("Step 05: Input to Password");
        registerPage.inputToPassword(SignUpFlowTest.password);

        log.info("Step 06: Input to Confirm Password");
        registerPage.inputToConfirmPassword("1234");

        log.info("Step 07: Click to Register button");
        registerPage.clickToSignUpButton();

        log.info("Step 08: Verify message is displayed");
        verifyTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
