import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MobileTest {

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
/*
            if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.wellysis.spatchex.spatchextest:id/bluetooth_status_tv\"]")).isDisplayed()){
                System.out.println("Disconnected!");

                driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_connect\"]")).click();
            }
*/
            Thread.sleep(7000);
            // Type Serial number TC1
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.wellysis.spatchex.spatchextest:id/edit_serial_number\"]")).sendKeys("670225");

            Thread.sleep(3000);
            // Click Connect TC2
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_connect\"]")).click();

            Thread.sleep(10000);
            // Click Battery TC3
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_battery\"]")).click();

            Thread.sleep(7000);
            // Click Manufacturer TC4
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_manufacturer\"]")).click();

            Thread.sleep(7000);
            // click ModelNumber - TC5 Bug with 1.76 FW?
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_model_number\"]")).click();

            Thread.sleep(7000);
            // Click SerialNumber TC6
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_serial_number\"]")).click();

            Thread.sleep(7000);
            // Click HardWareVersion TC7
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_hardware_version\"]")).click();

            Thread.sleep(5000);
            // Click SoftwareVersion TC8
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_software_version\"]")).click();

            Thread.sleep(5000);
            // Click FirmWareVersion TC9
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_firmware_version\"]")).click();

            Thread.sleep(5000);
//Swipe up
            private static void swipeUp(AndroidDriver driver) {
                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.3);

                new TouchAction<>(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
            }
            // ECG Live - Start measurement, end measurement, pause measurement, restart measurement.
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_unLock\"]")).click();

            Thread.sleep(5000);


            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.spatchex.spatchextest:id/btn_start_measurement\"]")).click();

            Thread.sleep(5000);

            //driver.findElement(AppiumBy.xpath("digit_2")).click();

            //Thread.sleep(7000);


/*
            // Set duration measurement, get duration measurement

            driver.findElement(AppiumBy.xpath("digit_2")).click();
            driver.findElement(AppiumBy.xpath("digit_2")).click();

            // Memory - Get packet number from memory, ECG Full, Acc, Gyro

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