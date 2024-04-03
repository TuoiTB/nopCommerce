package pageUI;

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
    public static final String PRODUCT_NAME = "CSS=.product-title>a";
    public static final String PRODUCT_PRICE = "css=div.prices>span";
    public static final String PRODUCT_ORDER_BY_DROPDOWN = "CSS=select#products-orderby" ;
    public static final String PRODUCT_PAGE_SIZE_DROPDOWN = "CSS=select#products-pagesize" ;
}
