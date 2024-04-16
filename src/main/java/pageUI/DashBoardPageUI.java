package pageUI;

import org.openqa.selenium.WebElement;

public class DashBoardPageUI {
    public static final String MY_ACCOUNT_LINK = "css=a.ico-account";
    public static final String PRODUCT_LINK = "XPATH=//strong[text()='Featured products']/parent::div/following-sibling::div//a[text()='Apple MacBook Pro 13-inch']";
    public static final String DYNAMIC_PRODUCT_LINK_BY_NAME = "XPATH=//h2[@class='product-title']/a[text()='%s']";
    public static final String PRODUCT_LINK_IN_WISHLIST = "XPATH=//h1[text()='Wishlist']/parent::div/following-sibling::div//a[text()='Apple MacBook Pro 13-inch']";
    public static final String PRODUCT_LINK_IN_SHOPPING_CART = "XPATH=//h1[text()='Shopping cart']/parent::div/following-sibling::div//a[text()='Apple MacBook Pro 13-inch']";
    public static final String ADD_REVIEW_LINK = "XPATH=//a[text()='Add your review']";
    public static final String REVIEW_TITLE_TEXTBOX = "CSS=input#AddProductReview_Title";
    public static final String REVIEW_TEXT_TEXTAREA = "CSS=textarea#AddProductReview_ReviewText";
    public static final String SUBMIT_REVIEW_BUTTON = "XPATH=//button[text()='Submit review']";
    public static final String ADD_REVIEW_SUCCESSFULLY_MESSAGE = "XPATH=//div[contains(text(),'Product review is successfully added.')]";

    public static final String SEARCH_LINK_IN_FOOTER = "xpath=//div[@class='footer-block customer-service']//a[text()='Search']";
    public static final String COMPUTER_TOP_MENU = "xpath=//ul[@class='top-menu notmobile']/li/a[text()='Computers ']";
    public static final String NOTEBOOK_SUB_FIRST_LEVEL = "xpath=//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a";
    public static final String NOTEBOOK = "xpath=//ul[@class='sublist']//a[text()='Notebooks ']";
    public static final String DESKTOP = "xpath=//ul[@class='sublist']//a[text()='Desktops ']";
    public static final String WISHLIST_BUTTON = "css=div.add-to-wishlist";
    public static final String ADD_WISHLIST_SUCCESSFULLY_MESSAGE = "XPATH=//p[text()='The product has been added to your ']";
    public static final String WISHLIST_LINK = "XPATH=//a[text()='wishlist']";
    public static final String WISHLIST_LINK_IN_HEADER = "css=span.wishlist-label";
    public static final String WISHLIST_MESSAGE = "XPATH=//div[text()='The wishlist is empty!']";
    public static final String CLOSE_BUTTON = "CSS=span.close";
    public static final String SHARING_LINK = "XPATH=//span[@class='share-label']/following-sibling::a";
    public static final String TITLE_IN_SHARING_LINK = "XPATH=//div[@class='page-title']/h1";
    public static final String CHECKBOX_ADD_TO_CART = "XPATH=//input[@name='addtocart']";
    public static final String ADD_TO_CART_BUTTON = "XPATH=//button[text()='Add to cart']";
    public static final String HOME_IMAGE = "xpath=//img[@alt='nopCommerce demo store']";
    public static final String REMOVE_BUTTON = "css=button.remove-btn";
    public static final String REMOVE_MESSAGE = "css=div.no-data";
    public static final String ADD_TO_COMPARE_BUTTON_BY_NAME = "xpath=//a[text()='%s']/parent::h2//following-sibling::div[@class='add-info']//button[@title='Add to compare list']";
    public static final String COMPARE_LINK = "XPATH=//a[text()='product comparison']";
    public static final String COMPARISON_MESSAGE = "XPATH=//p[text()='The product has been added to your ']";
    public static final String PRODUCT_IN_COMPARISION_PAGE_BY_NAME = "XPATH=//h1[text()='Compare products']/parent::div/following-sibling::div//a[text()='%s']";
    public static final String CLEAR_BUTTON = "CSS=a.clear-list";
    public static final String CLEAR_MESSAGE = "XPATH=//div[text()='You have no items to compare.']";
    public static final String RECENT_VIEW_PRODUCTS_LINK_IN_FOOTER = "XPATH=//a[text()='Recently viewed products']";
    public static final String DYNAMIC_ADD_TO_CART_BUTTON_BY_NAME = "XPATH=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to cart']";



}
