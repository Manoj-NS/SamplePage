package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.SamplePage;

public class SamplePageTest extends BaseClass {
	
	@BeforeTest()
	public void setData() {
		
		excelFileName="SamplePageData";
 	}
	
	@Test(dataProvider="SamplePage")
	public void samplePage(String name, String email, String website, String experience, String checkboxCount, 
			String checkboxOption, String expertise, String educationCount, String educationOptions, 
			String education, String comments) {
		
		test.log(Status.INFO, "Starting test case");
		
		new SamplePage(driver)
		.enterName(name)
		.enterEmail(email)
		.enterWebsite(website)
		.selectExperience(experience)
		.verifyexpCount(checkboxCount, checkboxOption)
		.selectExpertise(expertise)
		.verifyEducationRadiobutton(educationCount, educationOptions)
		.selectEducation(education)
		.enterComments(comments);
		
        test.log(Status.PASS, "Test case completed successfully");

        

		
		
	}
}
