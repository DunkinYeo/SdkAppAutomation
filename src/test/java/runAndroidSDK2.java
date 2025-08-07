import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.devtools.v133.input.model.TouchPoint;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class runAndroidSDK2 {
    private ExtentReports extent;
    private ExtentTest test;
    private AndroidDriver driver;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Mobile Test Report");
        spark.config().setReportName("Android Automation Test");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Tester", "Dunkin Yeo");
    }

    @BeforeMethod
    public void setupAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "23cdd45b33017ece");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/dunkinyeo/projects/App/app-debug (1).apk");
        //capabilities.setCapability("udid", "353524094713874");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void runAndroidSDK2() {
        test = extent.createTest("Launch Android SDK Test App");

        try {
            test.info("App launched successfully");

             Thread.sleep(7000);
            test.info("Enter:S-patch Serial Number");
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.wellysis.sdk.ui.xml:id/input_serial_number\"]")).sendKeys("670225");

//Connect Device
            Thread.sleep(5000);
            test.info("click: Connect");
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.sdk.ui.xml:id/btn_connect\"]")).click();
//Disconnect Device
            Thread.sleep(8000);
            test.info("Click: Disconnect");
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.wellysis.sdk.ui.xml:id/btn_disconnect\"]")).click();
//Reconnect Device
            Thread.sleep(8000);
            test.info("click: ReConnect");
            driver.findElement(AppiumBy.id("//android.widget.Button[@resource-id=\"com.wellysis.sdk.ui.xml:id/btn_connect\"]")).click();
//Body Sensor Locations works

//Live Battery status

//Model Number

//Serial Number

//Hardware Version

//Software Version

//Firmware Version

//Manufacturer

//WriteSet ECG start

//WriteSet ECG pause

//WriteSet ECG Restart

//WriteSet ECG stop

//WriteSet Delete Bond

//WriteSet Power Off Time

//WriteSet Sign Out

//WriteSet Bonding Enable

//WriteSet Bonding Disable

//WriteSet Measurement Duration

//WriteSet System Reboot

//WriteSet BLE power state enable

//WriteSet BLE power state disable

//WriteSet Symptom Time


            Thread.sleep(8000);
            test.info("click: S-patch Battery");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_battery")).click();

            Thread.sleep(7000);
            test.info("click: Manufacturer");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_manufacturer")).click();

            Thread.sleep(7000);
            test.info("click: S-patch Model Number");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_model_number")).click();

            Thread.sleep(7000);
            test.info("click: S-patch Serial Number");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_serial_number")).click();

            Thread.sleep(7000);
            test.info("click: S-patch Hardware Version");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_hardware_version")).click();

            Thread.sleep(5000);
            test.info("click: S-patch Software Version");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_software_version")).click();

            Thread.sleep(5000);
            test.info("click: S-patch Firmware Version");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_firmware_version")).click();

            Thread.sleep(8000);
            test.info("Action: Swipe up");
            swipeUp();

            Thread.sleep(5000);
            test.info("click: Unlock Patch");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_unLock")).click();

            Thread.sleep(8000);
            test.info("click: Start Measurement");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_start_measurement")).click();

            Thread.sleep(20000);
            test.info("click: Pause Measurement");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_pause_measurement")).click();

            Thread.sleep(8000);
            test.info("click: Restart Measurement");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_restart_measurement")).click();

            Thread.sleep(8000);
            test.info("click: Get Packet Number From Memory");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_get_packet_number_from_memory")).click();

            Thread.sleep(8000);

            test.pass("All test steps executed successfully.");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    private void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.4);


        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    new TouchPoint<>(driver)

    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
        test.info("Appium driver stopped");
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}