package pageUI;

import org.openqa.selenium.WebElement;

public class DashBoardPageUI {
    public static final String MY_ACCOUNT_LINK = "css=a.ico-account";
    public static final String PRODUCT_LINK = "XPATH=//a[text()='Apple MacBook Pro 13-inch']";
    public static final String ADD_REVIEW_LINK = "XPATH=//a[text()='Add your review']";
    public static final String REVIEW_TITLE_TEXTBOX = "CSS=input#AddProductReview_Title";
    public static final String REVIEW_TEXT_TEXTAREA = "CSS=textarea#AddProductReview_ReviewText";
    public static final String SUBMIT_REVIEW_BUTTON = "XPATH=//button[text()='Submit review']";
    public static final String ADD_REVIEW_SUCCESSFULLY_MESSAGE = "XPATH=//div[contains(text(),'Product review is successfully added.')]";

    public static final String SEARCH_LINK_IN_FOOTER = "xpath=//div[@class='footer-block customer-service']//a[text()='Search']";
    public static final String COMPUTER_TOP_MENU = "xpath=//ul[@class='top-menu notmobile']/li/a[text()='Computers ']";
    public static final String NOTEBOOK_SUB_FIRST_LEVEL = "xpath=//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a";
    public static final String NOTEBOOK = "xpath=//ul[@class='sublist']//a[text()='Notebooks ']";
    public static final String WISHLIST_BUTTON = "css=div.add-to-wishlist";
    public static final String ADD_WISHLIST_SUCCESSFULLY_MESSAGE = "XPATH=//p[text()='The product has been added to your ']";
    public static final String WISHLIST_LINK = "XPATH=//a[@class='ico-wishlist']";
    public static final String CLOSE_BUTTON = "CSS=span.close";
    public static final String SHARING_LINK = "XPATH=//span[@class='share-label']/following-sibling::a";
    public static final String TITLE_IN_SHARING_LINK = "XPATH=//div[@class='page-title']/h1";
    public static final String CHECKBOX_ADD_TO_CART = "XPATH=//input[@name='addtocart']";
    public static final String ADD_TO_CART_BUTTON = "XPATH=//button[@name='addtocartbutton']";
    public static final String HOME_IMAGE = "//img[@alt='nopCommerce demo store']";
    public static final String REMOVE_BUTTON = "css=button.remove-btn";
    public static final String REMOVE_MESSAGE = "css=div.no-data";
    public static final String ADD_TO_COMPARE_BUTTON = "css=button.add-to-compare-list-button";

}
