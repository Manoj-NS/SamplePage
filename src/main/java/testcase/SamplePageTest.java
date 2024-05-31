package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SamplePage;

public class SamplePageTest extends BaseClass {
	
	@BeforeTest()
	
	public void setData() {
		
		excelFileData="SamplePageData";
		
	}
	
	@Test(dataProvider="SamplePage")
	public void samplePage(String name, String email, String website, String experience, String expertise) {
		
		new SamplePage(driver)
//		.enterName(name)
		.enterEmail(email)
		.enterWebsite(website)
		.selectExperience(experience)
		.selectExpertise(expertise);
	}
}
