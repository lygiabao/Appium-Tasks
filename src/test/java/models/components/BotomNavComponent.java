package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BotomNavComponent {
    private final AppiumDriver<MobileElement> driver;
    private final static By homeIconSel = MobileBy.AccessibilityId("Home");
    private final static By webViewIconSel = MobileBy.AccessibilityId("Webview");
    private final static By loginIconSel = MobileBy.AccessibilityId("Login");
    private final static By formsIconSel = MobileBy.AccessibilityId("Forms");
    private final static By swipeIconSel = MobileBy.AccessibilityId("Swipe");
    private final static By dragIconSel = MobileBy.AccessibilityId("Drag");

    public BotomNavComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickOnHomeIcon(){
        driver.findElement(homeIconSel).click();
    }

    public void clickOnWebViewIcon(){
        driver.findElement(webViewIconSel).click();
    }

    public void clickOnLoginIcon(){
        driver.findElement(loginIconSel).click();
    }

    public void clickOnFormsIcon(){
        driver.findElement(formsIconSel).click();
    }

    public void clickOnSwipeIcon(){
        driver.findElement(swipeIconSel).click();
    }

    public void clickOnDragIcon(){
        driver.findElement(dragIconSel).click();
    }

}
