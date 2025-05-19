import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Test;
import java.net.URL;

public class MobileTest {
@Test
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

            // Click Battery, Manufacturer, model number, serial number, hardware version, software version, firmware version

            if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.wellysis.spatchex.spatchextest:id/bluetooth_status_tv\"]")).isDisplayed()){
                System.out.println("Disconnected!");
                driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_connect\"]")).click();
            }

            Thread.sleep(7000);

            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.wellysis.spatchex.spatchextest:id/edit_serial_number\"]")).sendKeys("610262");

            Thread.sleep(3000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_connect\"]")).click();

            Thread.sleep(10000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_battery\"]")).click();

            Thread.sleep(7000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_manufacturer\"]")).click();

            Thread.sleep(7000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_model_number\"]")).click();

            Thread.sleep(7000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_serial_number\"]")).click();

            Thread.sleep(7000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_hardware_version\"]")).click();

            Thread.sleep(5000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_software_version\"]")).click();

            Thread.sleep(5000);

            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_firmware_version\"]")).click();

            Thread.sleep(5000);

            // ECG Live - Start measurement, end measurement, pause measurement, restart measurement.
/*
            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();

            // Set duration measurement, get duration measurement

            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();

            // Memory - Get package number from memory, ECG Full, Acc, Gyro

            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();

            //Reset S-patch

            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();
*/


            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}