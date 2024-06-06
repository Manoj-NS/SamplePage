package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import javacode.ExtentReport;
import utilities.ExtentReportManager;
import utilities.ReadExcel;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String excelFileData;
	public ExtentTest test;
    public static ExtentReports extent;

	
	@BeforeSuite
	public void setupReport() {
		
		extent = ExtentReportManager.getExtentReports();  
    }
	
	@Parameters({"browserName","URL"})
	@BeforeMethod
	public void BeforeMethod(String browserName, String url){
		
//		test=ExtentReportManager.getExtentReports().createTest("Test Case Name");
        test = extent.createTest("Sample Page Testing");  

		
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		    test.info("Browser launched and navigated to URL: " + url);

	}
	
		@AfterMethod
		public void AfterMethod() {
			driver.quit();
			if (test != null) {
	            test.info("Browser closed");
	        }		
			}
	
		 @AfterSuite
		    public void teardownReport() {
			 if (extent != null) {
		            extent.flush();
		        }		    }
		
		@DataProvider //(indices=0)
		public String[][] SamplePage() throws IOException {
			
			return ReadExcel.getData(excelFileData);
			}
	
	

}
