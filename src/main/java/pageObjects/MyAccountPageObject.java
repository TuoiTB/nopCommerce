package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputToFirstName(String valueToSend){
        waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, valueToSend);
    }
    public void inputToLastName(String valueToSend){
        waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, valueToSend);
    }
    public void chooseGenderRadioButton(){
        waitForElementClickable(driver, MyAccountPageUI.GENDER_CHECKBOX);
        checkToCheckboxOrRadio(driver, MyAccountPageUI.GENDER_CHECKBOX);
    }
    public void selectDayDropdown(String itemText){
        waitForElementClickable(driver, MyAccountPageUI.DOB_DAY);
        selectDropdown(driver, MyAccountPageUI.DOB_DAY, itemText);
    }
    public void selectMonthDropdown(String itemText){
        waitForElementClickable(driver, MyAccountPageUI.DOB_MONTH);
        selectDropdown(driver, MyAccountPageUI.DOB_MONTH, itemText);
    }
    public void selectYearDropdown(String itemText){
        waitForElementClickable(driver, MyAccountPageUI.DOB_YEAR);
        selectDropdown(driver, MyAccountPageUI.DOB_YEAR, itemText);
    }
    public void inputToEmail(String valueToSend){
        waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, valueToSend);
    }
    public void inputToCompany(String valueToSend){
        waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, valueToSend);
    }
    public void clickToSaveButton(){
        waitForElementClickable(driver, MyAccountPageUI.SAVE_INFOR_BUTTON);
        clickToElement(driver, MyAccountPageUI.SAVE_INFOR_BUTTON);
    }
    public boolean isUpdatedSuccessfullyMessageDisplayed(){
        return isElementDisplayed(driver, MyAccountPageUI.UPDATE_INFO_SUCCESSFULLY_MSG);
    }
    public String getFirstnameText(String attributeName){
        return getElementAttribute(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, attributeName);
    }
    public String getLastnameText(String attributeName){
        return getElementAttribute(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, attributeName);
    }
    public String getEmailText(String attributeName){
        return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, attributeName);
    }
    public String getCompanyText(String attributeName){
        return getElementAttribute(driver, MyAccountPageUI.COMPANY_TEXTBOX, attributeName);
    }
    public boolean isGenderSelected(){
        return isElementSelected(driver, MyAccountPageUI.GENDER_CHECKBOX);
    }
    public String getDayText(){
        return getFirstSelectedOptionText(driver, MyAccountPageUI.DOB_DAY);
    }
    public String getMonthText(){
        return getFirstSelectedOptionText(driver, MyAccountPageUI.DOB_MONTH);
    }
    public String getYearText(){
        return getFirstSelectedOptionText(driver, MyAccountPageUI.DOB_YEAR);
    }
    public void inputToTextboxById(String valueToSend, String id){
        waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, id);
        sendkeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, id);
    }
    public void clickToAddressLink(){
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK);
        clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
    }
    public void selectedDropdownById(String itemSelected, String id){
        waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_BY_ID, id);
        selectDropdown(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_BY_ID, itemSelected, id);
    }
    public boolean isInforAddressDisplayed(String dynamicText){
        return isElementDisplayed(driver, MyAccountPageUI.DYNAMIC_INFOR_ADDRESS_BY_TEXT, dynamicText);
    }
    public boolean isSaveSuccessfullyMessageDisplayed(){
        return isElementDisplayed(driver, MyAccountPageUI.ADD_ADDRESS_SUCCESSFULLY_MESSAGE);
    }

    public void clickAddnewButton() {
        waitForElementVisible(driver, MyAccountPageUI.ADD_ADDRESS_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADD_ADDRESS_BUTTON);
    }
    public void clickToChangePasswordLink(){
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
    }
    public void clickToChangePasswordButton(){
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
    }
    public boolean isChangePasswordMessageDisplayed(){
        return isElementDisplayed(driver, MyAccountPageUI.CHANGE_PASSWOR_SUCCESSFULLY_MSG);
    }
    public void clickToCloseButton(){
        waitForElementClickable(driver, MyAccountPageUI.CLOSE_BUTTON);
        clickToElement(driver, MyAccountPageUI.CLOSE_BUTTON);
    }
    public void clickToLogoutLink(){
        waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
        clickToElementByJS(driver, MyAccountPageUI.LOGOUT_LINK);
    }
    public void clickToMyProductReviewLink(){
        waitForElementClickable(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
    }
    public boolean isReviewTitleDisplayed(String text){
        return isElementDisplayed(driver, MyAccountPageUI.DYNAMIC_REVIEW_TITLE, text );
    }
    public boolean isReviewTextDisplayed(String text){
        return isElementDisplayed(driver, MyAccountPageUI.DYNAMIC_REVIEW_TEXT, text );
    }
}
