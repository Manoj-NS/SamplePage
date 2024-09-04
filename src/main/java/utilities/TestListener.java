package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BaseClass;


public class TestListener extends BaseClass implements ITestListener{
	
	@Override 
    public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
    }

	@Override
    public void onTestSuccess(ITestResult result) {
		 test.log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
    }
    
	@Override
	    public void onTestFailure(ITestResult result) {
	        BaseClass base = (BaseClass) result.getInstance();
	        
	        String screenshotPath = ScreenShots.captureScreenshot(base.driver);

	        test.log(Status.FAIL, "Test Case Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, result.getThrowable());
	        test.addScreenCaptureFromPath(screenshotPath);

	        System.out.println("Validation failed, please check the Extent Report");
	    }

	@Override
	    public void onTestSkipped(ITestResult result) {
	        BaseClass base = (BaseClass) result.getInstance();
	        String screenshotPath = ScreenShots.captureScreenshot(base.driver);

	        test.log(Status.SKIP, "Test Case Skipped: " + result.getMethod().getMethodName());
	        test.log(Status.SKIP, result.getThrowable());
	        test.addScreenCaptureFromPath(screenshotPath);

	        }
	 
	@Override
	    public void onFinish(ITestContext context) {
		 if (extent != null) {
				/*
				 * for (ITestResult result : context.getPassedTests().getAllResults()) {
				 * ExtentTest test = extent.createTest(result.getMethod().getMethodName());
				 * test.log(Status.INFO, "Test Case Ended"); }
				 */
	            
	            extent.flush();
	        }
	    }
	}