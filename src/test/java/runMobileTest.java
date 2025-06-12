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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class runMobileTest {
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
        capabilities.setCapability("appium:app", "/Users/dunkinyeo/projects/App/SPatch_SDK_debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void runMobileTest() {
        test = extent.createTest("Launch Android App Test");

        try {
            test.info("App launched successfully");

            Thread.sleep(7000);
            test.info("Enter:S-patch Serial Number");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/edit_serial_number")).sendKeys("670225");

            Thread.sleep(3000);
            test.info("click: Connect");
            driver.findElement(AppiumBy.id("com.wellysis.spatchex.spatchextest:id/btn_connect")).click();

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
    asf

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