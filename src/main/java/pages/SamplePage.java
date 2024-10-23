package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;

public class SamplePage extends BaseClass {
	
	public SamplePage(RemoteWebDriver driver) {
			this.driver=driver;
		}
	
	
	public SamplePage enterName(String name) {
		
	WebElement elementName = driver.findElement(By.id("g2599-name"));
	elementName.sendKeys(name);
	System.out.println(name+": Name entered succesfully");

	return this;
	
	}
	
	public SamplePage enterEmail(String email) {
	WebElement elementEmail = driver.findElement(By.id("g2599-email"));
	elementEmail.sendKeys(email);
	System.out.println(email+": Email entered succesfully");
	
	return this;
	}
	
	public SamplePage enterWebsite(String website) {
		
		WebElement elementWebsite = driver.findElement(By.id("g2599-website"));		
		elementWebsite.sendKeys(website);
		System.out.println("Selected Website: "+website);

		return this;
	}
	
	public SamplePage selectExperience(String experience) {
		
		WebElement elementExperienxeDDL = driver.findElement(By.id("g2599-experienceinyears"));
		Select experienceDDL = new Select(elementExperienxeDDL);
		
		List<WebElement> ddlOptions=experienceDDL.getOptions();
		System.out.println("Total DDL Options: "+ddlOptions.size());
			for (WebElement expddlOptions : ddlOptions) {
			System.out.println("Dropdown Options: "+expddlOptions.getText());
				}
			experienceDDL.selectByVisibleText(experience);
		//	experienceDDL.deselectByVisibleText("3-5");
			
	//To print the selected option		
			WebElement selectedOption=experienceDDL.getFirstSelectedOption();
			System.out.println("Selected Dropdown: "+selectedOption.getText());
			
//			// Scroll by 1000 pixels down the page
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");		
			
		return this;
	}

	public SamplePage verifyexpCount(String checkboxCount, String checkboxOption) {
				
		List<WebElement> checkboxOptions=driver.findElements(By.xpath("//input[@type='checkbox']"));
			try {
				
			int actualOption = checkboxOptions.size();
			int expectedOption=Integer.parseInt(checkboxCount);
					
			if (actualOption==expectedOption) {
			System.out.println("Exp Checkbox Count: "+checkboxCount);}
					
			} catch (Exception e) {
					// TODO: handle exception
			System.out.println("No Data Entered");
			}
				
				//	Assert.assertEquals(expectedOption, actualOption);	
//To validate the checkbox options
					
			for (WebElement expertiseOptions : checkboxOptions) {				
			String actualCheckboxOptions = expertiseOptions.getAttribute("value");
							
		//To get the value from excel		
			String [] options= checkboxOption.split(",\\s*");
					
			for (String expectedcheckboxOptions: options) {						
							
			if(actualCheckboxOptions.equals(expectedcheckboxOptions.trim())) {
			System.out.println("Expertise Checkbox Option: "+actualCheckboxOptions);	
						}				
					}
				}
			return this;
				}
			
	public SamplePage selectExpertise(String expertise) throws InterruptedException {

		List<WebElement> checkboxOptions=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
			for (WebElement expertiseOptions : checkboxOptions) {
			
		//	System.out.println("Expertise Checkbox Option: "+expertiseOptions.getAttribute("value"));			
			String expCheckboxOptions = expertiseOptions.getAttribute("value");
					
//To get the value from excel		
			String [] options= expertise.split(",\\s*");
			
			for (String optionSelected: options) {						
					
			if(expCheckboxOptions.equals(optionSelected.trim())) {
				expertiseOptions.click();
				System.out.println("Selected Checkbox: "+optionSelected);}	
			}
		}
//			Thread.sleep(5000);
	return this;
	}

	public SamplePage verifyEducationRadiobutton(String educationCount, String educationOptions) {
		
	List<WebElement> radioOptions = driver.findElements(By.xpath("//input[@type='radio']"));	
		
		try {int actualRadioLen=radioOptions.size();
		int expectedRadioLen=Integer.parseInt(educationCount);
		
		if(actualRadioLen==expectedRadioLen) {
		System.out.println("Total Radio Button: "+expectedRadioLen);}	
		
		} catch (Exception e){
			System.out.println("No data entered");
		}
				
//TO verify options		
		
		for(WebElement eduOptions: radioOptions){
			
			String actualRadiobutton=eduOptions.getAttribute("value");
			String[] expectedRadiobutton=educationOptions.split(",\\s*");
			
			for(String radioButtons: expectedRadiobutton) {
			
			if(actualRadiobutton.equals(radioButtons.trim())) {
			
			System.out.println("Radio Button Options: "+actualRadiobutton);	}
			}
		}
	
		return this;
	
		}
		
		public SamplePage selectEducation(String education) throws InterruptedException {
			
			List<WebElement> radioOptions = driver.findElements(By.xpath("//input[@type='radio']"));
			for(WebElement eduOptions: radioOptions){
				
				String radiobuttonOptions=eduOptions.getAttribute("value");
				String[] expectedOption=education.split(",\\s*");
				
				for(String radioButtons: expectedOption) {
				
				if(radiobuttonOptions.equals(radioButtons.trim())) {
			
					eduOptions.click();
			
				System.out.println("Selected radioButton: "+radiobuttonOptions);	}
				
				}
//				Thread.sleep(5000);
			}	
			
		return this;
		}
		
		public SamplePage enterComments(String comments) {
			
			WebElement commentelement = driver.findElement(By.id("contact-form-comment-g2599-comment"));
			commentelement.sendKeys(comments);
			
			int commentCount=comments.length();
			
			Assert.assertTrue(commentCount<250, "Only 250 characters are allowed \n");
			System.out.println("Comments entered sucessfully");
				
			return this;
		}
}
