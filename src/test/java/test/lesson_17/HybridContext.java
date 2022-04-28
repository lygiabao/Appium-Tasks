package test.lesson_17;

import context.Context;
import context.waitMoreThanContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HybridContext {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click
            MobileElement webViewNavBtnSel = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            webViewNavBtnSel.click();

            // Wai until we have more than one contacts
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new waitMoreThanContext(appiumDriver));

            // Get all context names
            for (String context : appiumDriver.getContextHandles()) {
                System.out.println(context);
            }

            // Swtich to Web View Context
            appiumDriver.context(Context.WEB_VIEW);

            // Interact on webview Element
            WebElement navToggle = appiumDriver.findElementByCssSelector("navbar__toggle");
            navToggle.click();
            List<MobileElement> menuItemElms = appiumDriver.findElementsByCssSelector(".menu__list li a");
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            if (menuItemElms.isEmpty()){
                throw new RuntimeException("There are no list item");
            }

            for (MobileElement menuItemElm : menuItemElms) {
                String itemText = menuItemElm.getText();
                String itemHref = menuItemElm.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataList.add(new MenuItemData("Github", itemHref));
                } else
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));

            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            appiumDriver.quit();
        }
    }

    public static class MenuItemData{
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }
        public String getHref() {
            return href;
        }
    }
}
