package Account;

import Register.Register_01_Main_Flow;
import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

@Epic("Customer")
@Feature("Create Customer")
public class Account extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    MyAccountPageObject myAccountPage;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputToEmail(Register_01_Main_Flow.email);
        loginPage.inputToPassword(Register_01_Main_Flow.password);
        loginPage.clickToLoginButton();
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.clickMyAccount();
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
    }
    @Test(priority = 1)
    public void Customer_information() {
        String firstName = "Automation";
        String lastName = "FC";
        String day = "1";
        String month = "January";
        String year = "1999";
        String email = getEmailRandom();
        String company = "automationfc";



        log.info("Step 01: Choose gender: female ");
        myAccountPage.chooseGenderRadioButton();

        log.info("Step 02: Input to First name");
        myAccountPage.inputToFirstName(firstName);

        log.info("Step 03: Input to Last name");
        myAccountPage.inputToLastName(lastName);

        log.info("Step 04: Select Date of birth");
        myAccountPage.selectDayDropdown(day);
        myAccountPage.selectMonthDropdown(month);
        myAccountPage.selectYearDropdown(year);

        log.info("Step 05: Input to Email");
        myAccountPage.inputToEmail(email);

        log.info("Step 06: Input to Company");
        myAccountPage.inputToCompany(company);

        log.info("Step 07: Click to Save button");
        myAccountPage.clickToSaveButton();

        log.info("Step 08: Verify infor updated successfully message");
        verifyTrue(myAccountPage.isUpdatedSuccessfullyMessageDisplayed());

        log.info("Step 09: Verify infor updated successfully");
        log.info("Step 09_01: Verify first name");
        verifyEquals(myAccountPage.getFirstnameText("value"), firstName);

        log.info("Step 09_02: Verify last name");
        verifyEquals(myAccountPage.getLastnameText("value"), lastName);

        log.info("Step 09_03: Verify email");
        verifyEquals(myAccountPage.getEmailText("value"), email);

        log.info("Step 09_04: Verify company");
        verifyEquals(myAccountPage.getCompanyText("value"), company);

        log.info("Step 09_05: Verify Gender Selected");
        verifyTrue(myAccountPage.isGenderSelected());

        log.info("Step 09_06: Verify Day Selected");
        verifyEquals(myAccountPage.getDayText(), day);

        log.info("Step 09_07: Verify Month Selected");
        verifyEquals(myAccountPage.getMonthText(), month);

        log.info("Step 09_08: Verify Year Selected");
        verifyEquals(myAccountPage.getYearText(), year);

    }
    @Test(priority = 2)
    public void Addresses() {


    }
    @Test(priority = 3)
    public void Change_password() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
    // quitBrowserDriver();
    }
}
