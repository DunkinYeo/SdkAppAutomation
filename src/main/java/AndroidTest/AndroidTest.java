package AndroidTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidTest {
    public static void main(String[] args) {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("appium:deviceName", "23cdd45b33017ece");
            cap.setCapability("appium:platformName", "Android");
            cap.setCapability("appium:automationName", "UiAutomator2");
            cap.setCapability("appium:platformVersion", "10");
            cap.setCapability("appium:app", "/Users/dunkinyeo/projects/App/SPatch_SDK_debug.apk");

            AndroidDriver driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/wd/hub"), cap);

           /*
            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();
*/
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}