package javacode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	
	WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        // Initialize ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/result.html");
        spark.config().setReportName("My Test Report");
        spark.config().setDocumentTitle("Automation Test Results");
        spark.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(spark);
      

        // Create a test case
        test = extent.createTest("MyFirstTest");

        // Set up WebDriver
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @Test
    public void launchGoogle() {
        test.info("Launching Google");
        driver.get("https://www.google.com");
        if (driver.getTitle().equals("Google")) {
            test.pass("Navigated to Google successfully");
        } else {
            test.fail("Google navigation failed");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // Write the test information to the report
        extent.flush();
    }

}
