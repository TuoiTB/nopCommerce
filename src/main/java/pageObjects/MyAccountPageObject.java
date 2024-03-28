package pageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUI.MyAccountPageUI;
import pageUI.RegisterPageUI;

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
}
