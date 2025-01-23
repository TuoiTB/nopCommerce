package SignUp;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.ExcelConfig;

@Epic("Customer")
@Feature("Create Customer")
public class SignUpWithDataDrivenTest extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    SignUpPageObject registerPage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    ExcelConfig excelConfig;
    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        driver = getBrowserEnvironment(browserName, serverName);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToCreateAccountButton();
        registerPage = PageGeneratorManager.getSignUpPage(driver);
        firstName = excelConfig.getCellData("FirstName",0);
        lastName = excelConfig.getCellData("LastName",0);
        email = excelConfig.getCellData("Email",0);
        password = excelConfig.getCellData("Password",0);
    }
    @Test(priority = 0)
    public void signUpWithDataDriven() {

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitBrowserDriver();
    }
}
