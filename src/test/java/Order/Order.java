package Order;

import Register.Register_01_Main_Flow;
import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

@Epic("Wishlist_Compare_RecentView")
@Feature("Wishlist_Compare_RecentView")
public class Order extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoardPage;
    ShoppingCartPageObject shoppingCartPage;
    String product;
    String processor, ram, hdd, os, software, quantity;
    float priceOfProduct, bonusOfProcessor, bonusOfRam, bonusOfHdd, bonusOfOs, bonusOfSoftware, totalBonus, totalUnitPrice, subTotal, cost;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToLoginLink();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.loginToSystem(Register_01_Main_Flow.email, Register_01_Main_Flow.password);
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.openDesktop();
        product = "Build your own computer";
        cost = dashBoardPage.costOfProduct(product);
    }

    @Test(priority = 1)
    public void Add_product_to_cart() {

        processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        ram = "4GB [+$20.00]";
        hdd = "400 GB [+$100.00]";
        os = "Vista Home [+$50.00]";
        software = "Microsoft Office [+$50.00]";
        quantity = "1";

        log.info("Step 01: Click to any product");
        dashBoardPage.clickToProduct(product);

        log.info("Step 02: Choose some info about product");
        log.info("Step 2.1: processor");
        dashBoardPage.selectProcessorDropdown(processor);

        log.info("Step 2.2: ram");
        dashBoardPage.selectRAMDropdown(ram);

        log.info("Step 2.3: hdd");
        dashBoardPage.selectRadioButtonAndCheckbox(hdd);
        dashBoardPage.selectRadioButtonAndCheckbox("320 GB"); //Do web nó bị 1 vấn đề là nếu chạy auto, chọn hdd thì nó k tính vào price được, phair chọn item khác rồi chọn lại thì mới tính được
        dashBoardPage.selectRadioButtonAndCheckbox(hdd);

        log.info("Step 2.4: os");
        dashBoardPage.selectRadioButtonAndCheckbox(os);

        log.info("Step 2.5: software");
        dashBoardPage.selectRadioButtonAndCheckbox(software);

        log.info("Step 2.6: quantity");
        dashBoardPage.inputToQuantity(quantity);

        log.info("Step 2.7: convert price to float type");
        priceOfProduct = dashBoardPage.priceOfProduct();
        System.out.println(priceOfProduct);

        log.info("Step 2.8: convert bonus processor to int type");
        bonusOfProcessor = dashBoardPage.bonusWithIndex(processor);
        System.out.println(bonusOfProcessor);

        log.info("Step 2.9: convert bonus ram to int type");
        bonusOfRam = dashBoardPage.bonusWithIndex(ram);
        System.out.println(bonusOfRam);

        log.info("Step 2.10: convert bonus hdd to int type");
        bonusOfHdd = dashBoardPage.bonusWithIndex(hdd);
        System.out.println(bonusOfHdd);

        log.info("Step 2.11: convert bonus os to int type");
        bonusOfOs = dashBoardPage.bonusWithIndex(os);
        System.out.println(bonusOfOs);

        log.info("Step 2.12: convert bonus software to int type");
        bonusOfSoftware = dashBoardPage.bonusWithIndex(software);
        System.out.println(bonusOfSoftware);

        log.info("Step 2.13: total bonus");
        totalBonus = bonusOfProcessor + bonusOfRam + bonusOfHdd + bonusOfOs + bonusOfSoftware;
        System.out.println(totalBonus);

        log.info("Step 2.14: total unit price");
        totalUnitPrice = totalBonus + cost;
        System.out.println(totalUnitPrice);

        log.info("Step 2.15: verify with initial cost");
        verifyEquals(priceOfProduct,totalUnitPrice);

        log.info("Step 03: Click to Add to cart button");
        dashBoardPage.clickToAddToCartButton();

        log.info("Step 04: Verify message added to cart is displayed ");
        verifyTrue(dashBoardPage.isMessageAddedToCartDisplayed());

        log.info("Step 05: Verify product added to cart successfully");
        dashBoardPage.clickToShoppingCartLink();
        shoppingCartPage = PageGeneratorManager.getShoppingCart(driver);

        log.info("Step 5.1: Verify Name Product is Displayed In Shopping Cart");
        verifyTrue(shoppingCartPage.isNameProducDisplayedInShoppingCart(product));

        log.info("Step 5.2: Verify Processor is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(processor));

        log.info("Step 5.3: Verify RAM is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(ram));

        log.info("Step 5.4: Verify HDD is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(hdd));

        log.info("Step 5.5: Verify OS is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(os));

        log.info("Step 5.6: Verify Software is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(software));

        log.info("Step 5.7: Verify Unit price");
        verifyEquals(shoppingCartPage.unitPriceInShoppingCart(product), priceOfProduct);

        log.info("Step 5.8: Verify Quantity In Shopping Cart");
        verifyEquals(Float.parseFloat(quantity), shoppingCartPage.quantityInShoppingCart("value", product));

        log.info("Step 5.9: Verify Total In Shopping Cart");
        subTotal = priceOfProduct * shoppingCartPage.quantityInShoppingCart("value", product);
        verifyEquals(shoppingCartPage.SubTotalInShoppingCart(product), subTotal);
    }
    @Test(priority = 2)
    public void Edit_product_in_shopping_cart() {
        processor = "2.2 GHz Intel Pentium Dual-Core E2200";
        ram = "4GB [+$20.00]";
        hdd = "320 GB";
        os = "Vista Home [+$50.00]";
        software = "Microsoft Office [+$50.00]";
        quantity = "2";
        log.info("Step 01: Click to Edit link");
        shoppingCartPage.clickToEditLink();

        log.info("Step 02: Update infor");
        log.info("Step 2.1: processor");
        dashBoardPage = PageGeneratorManager.getDashBoardPage(driver);
        dashBoardPage.selectProcessorDropdown(processor);

        log.info("Step 2.2: ram");
        dashBoardPage.selectRAMDropdown(ram);

        log.info("Step 2.3: hdd");
        dashBoardPage.selectRadioButtonAndCheckbox(hdd);
        dashBoardPage.selectRadioButtonAndCheckbox("400 GB [+$100.00]"); //Do web nó bị 1 vấn đề là nếu chạy auto, chọn hdd thì nó k tính vào price được, phair chọn item khác rồi chọn lại thì mới tính được
        dashBoardPage.selectRadioButtonAndCheckbox(hdd);
        dashBoardPage.sleepInSecond(3);

        log.info("Step 2.4: os");
        dashBoardPage.selectRadioButtonAndCheckbox(os);

        log.info("Step 2.5: software");
        dashBoardPage.selectRadioButtonAndCheckbox(software);

        log.info("Step 2.6: quantity");
        dashBoardPage.inputToQuantity(quantity);

        log.info("Step 2.7: convert price to float type");
        priceOfProduct = dashBoardPage.priceOfProduct();
        System.out.println(priceOfProduct);

        log.info("Step 2.8: convert bonus processor to int type");
        bonusOfProcessor = dashBoardPage.bonusWithIndex(processor);
        System.out.println(bonusOfProcessor);

        log.info("Step 2.9: convert bonus ram to int type");
        bonusOfRam = dashBoardPage.bonusWithIndex(ram);
        System.out.println(bonusOfRam);

        log.info("Step 2.10: convert bonus hdd to int type");
        bonusOfHdd = dashBoardPage.bonusWithIndex(hdd);
        System.out.println(bonusOfHdd);

        log.info("Step 2.11: convert bonus os to int type");
        bonusOfOs = dashBoardPage.bonusWithIndex(os);
        System.out.println(bonusOfOs);

        log.info("Step 2.12: convert bonus software to int type");
        bonusOfSoftware = dashBoardPage.bonusWithIndex(software);
        System.out.println(bonusOfSoftware);

        log.info("Step 2.13: total bonus");
        totalBonus = bonusOfProcessor + bonusOfRam + bonusOfHdd + bonusOfOs + bonusOfSoftware;
        System.out.println(totalBonus);

        log.info("Step 2.14: total unit price");
        totalUnitPrice = totalBonus + cost;
        System.out.println(totalUnitPrice);

        log.info("Step 2.15: verify price");
        verifyEquals(priceOfProduct,totalUnitPrice);

        log.info("Step 03: Click to Update button");
        dashBoardPage.clickToUpdateButton();

        log.info("Step 04: Verify message added to cart is displayed ");
        verifyTrue(dashBoardPage.isMessageAddedToCartDisplayed());

        log.info("Step 05: Verify product added to cart successfully");
        dashBoardPage.clickToShoppingCartLink();
        shoppingCartPage = PageGeneratorManager.getShoppingCart(driver);

        log.info("Step 5.1: Verify Name Product is Displayed In Shopping Cart");
        verifyTrue(shoppingCartPage.isNameProducDisplayedInShoppingCart(product));

        log.info("Step 5.2: Verify Processor is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(processor));

        log.info("Step 5.3: Verify RAM is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(ram));

        log.info("Step 5.4: Verify HDD is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(hdd));

        log.info("Step 5.5: Verify OS is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(os));

        log.info("Step 5.6: Verify Software is selected In Shopping Cart");
        verifyTrue(shoppingCartPage.isInforProductDisplayeInShoppingCart(software));

        log.info("Step 5.7: Verify Unit price");
        verifyEquals(shoppingCartPage.unitPriceInShoppingCart(product), priceOfProduct);

        log.info("Step 5.8: Verify Quantity In Shopping Cart");
        verifyEquals(Float.parseFloat(quantity), shoppingCartPage.quantityInShoppingCart("value", product));

        log.info("Step 5.9: Verify Total In Shopping Cart");
        subTotal = priceOfProduct * shoppingCartPage.quantityInShoppingCart("value", product);
        verifyEquals(shoppingCartPage.SubTotalInShoppingCart(product), subTotal);
    }
    @Test(priority = 3)
    public void Remove_from_cart() {
        log.info("Step 01: ");

    }
    @Test(priority = 4)
    public void Update_shopping_cart() {
        log.info("Step 00: Add product in cart");

        log.info("Step 01: Update quantity = 5");

        log.info("Step 02: Click update shopping cart button");

        log.info("Step 03: Verify total = $2,500.00 ");

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
       quitBrowserDriver();
    }
}
