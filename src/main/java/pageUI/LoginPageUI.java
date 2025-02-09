package pageUI;

public class LoginPageUI {
    public final static String EMAIL_TEXTBOX = "CSS=input#curent-username";
    public final static String PASSWORD_TEXTBOX = "CSS=input#curent-password";
    public final static String LOGIN_LINK = "xpath=//button[@data-bs-target='#loginModal']";
    public final static String LOGIN_BUTTON = "css=button#LoginBtn";
    public final static String EMAIL_NOT_VERIFIED_MESSAGE = "xpath=//button[@id='ResendVerifiedCode']/parent::div";
    public final static String EMAIL_ERROR_MESSAGE = "css=span#Email-error";
    public final static String ERROR_LOGIN_MESSAGE = "XPATH=//div[@class='message-error validation-summary-errors']";
    public static final String POPUP_TOPIK = "xpath=//button[@class='btn-close' and @data-bs-dismiss='modal']";
}
