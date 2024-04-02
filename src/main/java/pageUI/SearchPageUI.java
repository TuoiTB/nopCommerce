package pageUI;

public class SearchPageUI {
    public static final String SEARCH_BUTTON = "xpath=//div[@class='buttons']//button[text()='Search']";
    public static final String MESSAGE_WARNING = "XPATH=//div[@class='warning' and text()='Search term minimum length is 3 characters']";
    public static final String MESSAGE_NO_RESULT = "xpath=//div[@class='no-result' and text()='No products were found that matched your criteria.']";
    public static final String SEARCH_TEXTBOX = "css=input.search-text";
    public static final String PRODUCT_SEARCH = "XPATH=//h2[@class='product-title']/a";
    public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//label[text()='Advanced search']//preceding-sibling::input";
    public static final String SUB_CATEGORY_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']//preceding-sibling::input";
    public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='cid']";
    public static final String MANUFACTURER_DROPDOWN = "css=select#mid";
}
