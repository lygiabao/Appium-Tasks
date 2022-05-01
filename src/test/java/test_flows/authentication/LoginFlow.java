package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginFormComponent;
import models.page_objects.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private String usernameStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String usernameStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.usernameStr = usernameStr;
        this.passwordStr = passwordStr;
    }

    public void login(){
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
        if(!usernameStr.isEmpty()){
            MobileElement emailElm = loginFormComponent.usernameElem();
            emailElm.clear();
            emailElm.sendKeys(usernameStr);
        }

        if(!passwordStr.isEmpty()){
            MobileElement passwordElemElm = loginFormComponent.passwordElem();
            passwordElemElm.clear();
            passwordElemElm.sendKeys(passwordStr);
        }

        loginFormComponent.clickOnLoginBtn();
    }

    public void verifyLogin(){
        boolean isEmailValid = EmailValidator.getInstance().isValid(usernameStr);
        boolean isPasswordValid = passwordStr.length() >= 8;

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();

        if (isEmailValid && isPasswordValid){
            verifyCorrectLogin();
        }

        if (!isEmailValid){
            verifyInCorrectEmail(loginFormComponent);
        }

        if (!isPasswordValid){
            verifyInCorrectPassword(loginFormComponent);
        }
    }

    private void verifyInCorrectPassword(LoginFormComponent loginFormComponent) {
        String actualInvalidEmail= loginFormComponent.getInvalidEmail();
        String expectedInvalidEmail = "Please enter a valid email address";

        // Verification
        System.out.println(actualInvalidEmail);
        System.out.println(expectedInvalidEmail);
    }

    private void verifyInCorrectEmail(LoginFormComponent loginFormComponent) {
        String actualInvalidPassword= loginFormComponent.getInvalidPassword();
        String expectedInvalidEmail = "Please enter at least 8 character";

        // Verification
        System.out.println(actualInvalidPassword);
        System.out.println(expectedInvalidEmail);
    }

    private void verifyCorrectLogin() {

    }
}
