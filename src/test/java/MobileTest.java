import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {
    public static void main(String[] args) {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "23cdd45b33017ece");
        desiredCapabilities.setCapability("app", "/Users/dunkinyeo/projects/App/SPatch_SDK_debug.apk");

        AppiumDriver driver = null;
        try{
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }


    }
}