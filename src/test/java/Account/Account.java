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
    String firstName = "Automation";
    String lastName = "FC";
    String day = "1";
    String month = "January";
    String year = "1999";
    String email = getEmailRandom();
    String company = "automationfc";
    String companyCity = "Da Nang";
    String companyAddress1 = "120/23 Le Lai";
    String companyAddress2 = "45 Nguyen Dinh Chieu";
    String zipCode = "550000";
    String phoneNumber = "0127845932";
    String faxNumber = "0127845645";
    String country ="United States";
    String province ="California";

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
        log.info("Step 00: Click to Address link");
        myAccountPage.clickToAddressLink();

        log.info("Step 01: Click Add new button");
        myAccountPage.clickAddnewButton();

        log.info("Step 02: Input to First name textbox");
        myAccountPage.inputToTextboxById(firstName, "Address_FirstName");

        log.info("Step 03: Input to Last name textbox");
        myAccountPage.inputToTextboxById(lastName, "Address_LastName");

        log.info("Step 04: Input to Email textbox");
        myAccountPage.inputToTextboxById(email, "Address_Email");

        log.info("Step 05: Input to Company textbox");
        myAccountPage.inputToTextboxById(company, "Address_Company");

        log.info("Step 06: Input to Company textbox");
        myAccountPage.inputToTextboxById(companyCity, "Address_Company");

        log.info("Step 07: Input to Address1 textbox");
        myAccountPage.inputToTextboxById(companyAddress1, "Address_Address1");

        log.info("Step 08: Input to Address2 textbox");
        myAccountPage.inputToTextboxById(companyAddress2, "Address_Address2");

        log.info("Step 09: Input to ZipPostalCode textbox");
        myAccountPage.inputToTextboxById(zipCode, "Address_ZipPostalCode");

        log.info("Step 10: Input to PhoneNumber textbox");
        myAccountPage.inputToTextboxById(phoneNumber, "Address_PhoneNumber");

        log.info("Step 11: Input to FaxNumber textbox");
        myAccountPage.inputToTextboxById(faxNumber, "Address_FaxNumber");

        log.info("Step 12: Select Country dropdown");
        myAccountPage.selectedDropdownById(country, "Address_CountryId");

        log.info("Step 13: Select State/ Province dropdown");
        myAccountPage.selectedDropdownById(province, "Address_StateProvinceId");

        log.info("Step 14: Input to PhoneNumber textbox");
        myAccountPage.inputToTextboxById(companyCity, "Address_City");

        log.info("Step 15: Click Save button");
        myAccountPage.clickToSaveButton();

        log.info("Step 16: Verify add successfully message displayed");
        verifyTrue(myAccountPage.isSaveSuccessfullyMessageDisplayed());

        log.info("Step 17: Verify info address is displayed");
        verifyTrue(myAccountPage.isInforAddressDisplayed(firstName + " " + lastName));
        verifyTrue(myAccountPage.isInforAddressDisplayed(email));
        verifyTrue(myAccountPage.isInforAddressDisplayed(phoneNumber));
        verifyTrue(myAccountPage.isInforAddressDisplayed(faxNumber));
        verifyTrue(myAccountPage.isInforAddressDisplayed(companyAddress1));
        verifyTrue(myAccountPage.isInforAddressDisplayed(companyAddress2));
    }

    @Test(priority = 3)
    public void Change_password() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // quitBrowserDriver();
    }
}
