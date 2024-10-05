package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportManager;
import utilities.ReadExcel;


public class BaseClass {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	protected static ExtentReports extent;
    protected static ExtentTest test;
    
	
	  @BeforeSuite 
	  public void startReport() {
			extent = ExtentReportManager.getExtentReports();
			
		}	  
	  
	  @DataProvider (indices=1)
		public String[][] SamplePage() throws IOException {
			
			return ReadExcel.getData(excelFileName);
			}
 	
		@Parameters({"browserName","URL"})
		@BeforeMethod
		public void BeforeMethod(String browserName, String url){
		
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
			


	}
	
		@AfterMethod
		public void AfterMethod() {
			driver.close();
		}
		
		@AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

		 @AfterSuite
		    public void teardownReport() {
			 if (extent != null) {
		            extent.flush();
		        }		    }


		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}
	
	

}
