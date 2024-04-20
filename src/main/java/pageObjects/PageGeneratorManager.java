package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return  new LoginPageObject(driver);
    }
    public static DashBoardPageObject getDashBoardPage(WebDriver driver) {
        return  new DashBoardPageObject(driver);
    }
    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return  new MyAccountPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver) {
        return  new SearchPageObject(driver);
    }
    public static WishlistPageObject getWishlistPage(WebDriver driver) {
        return  new WishlistPageObject(driver);
    }
    public static ShoppingCartPageObject getShoppingCart(WebDriver driver) {
        return  new ShoppingCartPageObject(driver);
    }
    public static CheckOutPageObject getCheckOutPage(WebDriver driver) {
        return  new CheckOutPageObject(driver);
    }
}
