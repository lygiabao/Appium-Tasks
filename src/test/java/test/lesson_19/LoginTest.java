package test.lesson_19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

public class LoginTest {

    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            loginWithCreds(appiumDriver, "a123@", "12345678");
            loginWithCreds(appiumDriver, "bao@gmail.com", "1234567");
            loginWithCreds(appiumDriver, "bao@gmail,con", "12345678");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

    private static void loginWithCreds(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, username, password);
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

}
