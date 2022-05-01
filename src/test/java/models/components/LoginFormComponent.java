package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> driver;
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTxt = MobileBy.xpath("//*[contains(@text, 'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordTxt = MobileBy.xpath("//*[contains(@text, 'Please enter at least 8 character')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement usernameElem(){
        return driver.findElement(usernameSel);
    }

    public MobileElement passwordElem(){
        return driver.findElement(passwordSel);
    }

    public MobileElement loginBtnElem(){
        return driver.findElement(loginBtnSel);
    }

    public void inputUsername(String username){
        if (!username.isEmpty()){
            usernameElem().sendKeys(username);
        }
    }

    public void inputPassword(String password){
        if (!password.isEmpty()){
            usernameElem().sendKeys(password);
        }
    }

    public String getInvalidEmail(){
        return driver.findElement(incorrectEmailTxt).getText().trim();
    }

    public String getInvalidPassword(){
        return driver.findElement(incorrectPasswordTxt).getText().trim();
    }

    public void clickOnLoginBtn(){
       loginBtnElem().click();
    }

}
