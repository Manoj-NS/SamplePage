package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class SamplePage extends BaseClass {
	
	public SamplePage(RemoteWebDriver commonDriver ) {
			this.driver=commonDriver;
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
		System.out.println(website+": Website entered succesfully");
		return this;
	}
	
	public SamplePage selectExperience(String experience) {
		
		WebElement elementExperienxeDDL = driver.findElement(By.id("g2599-experienceinyears"));
		Select experienceDDL = new Select(elementExperienxeDDL);
		
		List<WebElement> ddlOptions=experienceDDL.getOptions();
		System.out.println("Total DDL Options: "+ddlOptions.size());
			for (WebElement expddlOptions : ddlOptions) {
			System.out.println(expddlOptions.getText());
				}
			experienceDDL.selectByVisibleText(experience);
		//	experienceDDL.deselectByVisibleText("3-5");
			
	//To print the selected option		
			WebElement selectedOption=experienceDDL.getFirstSelectedOption();
			System.out.println("Selected Options: "+selectedOption.getText());
		
		return this;
	}

	public SamplePage selectExpertise(String expertise) {
		
		WebElement expertiseCheckbox01 = driver.findElement(By.xpath("//label[contains(text(),'Functional Testing')]"));
		System.out.println("checkbox01: "+expertiseCheckbox01.getText());
		String checkbox1=expertiseCheckbox01.getText();

		WebElement expertiseCheckbox02 = driver.findElement(By.xpath("//label[contains(text(),'Automation Testing')]"));
		System.out.println("checkbox02: "+expertiseCheckbox02.getText());
		String checkbox2=expertiseCheckbox02.getText();
		
		WebElement expertiseCheckbox03 = driver.findElement(By.xpath("//label[contains(text(),'Manual Testing')]"));
		System.out.println("checkbox03: "+expertiseCheckbox03.getText());
		String checkbox3=expertiseCheckbox03.getText();
		
		
		
		if(checkbox1.equals(expertise)) {
			expertiseCheckbox01.click();
			
		}
 
		
		
	
	return this;
	}

	public SamplePage selectEducation() {
	
	return this;
	}
/*	
	
	
/*	
	@CacheLookup
	@FindBy(how=How.ID, using="g2599-name") WebElement elementName;
	@CacheLookup
	@FindBy(how=How.ID, using="g2599-email")WebElement elementEmail;
	@CacheLookup
	@FindBy(how=How.ID, using="g2599-website") WebElement elementWebsite;
	@CacheLookup
	@FindBy(how=How.ID, using="g2599-experienceinyears") WebElement elementExperience;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Functional Testing']") WebElement elementExpertise1;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Automation Testing']") WebElement elementExpertise2;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Manual Testing']") WebElement elementExpertise3;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Graduate']") WebElement elementEducation1;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Post Graduate']") WebElement elementEducation2;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//label[normalize-space()='Other']") WebElement elementEducation3;
	@CacheLookup
	@FindBy(how=How.ID, using="contact-form-comment-g2599-comment") WebElement elementComment;
	@CacheLookup
	@FindBy(how=How.CLASS_NAME, using="pushbutton-wide") WebElement elementSubmit;

	public SamplePage(RemoteWebDriver commonDriver) {
		this.driver=commonDriver;
		PageFactory.initElements(driver, commonDriver);
		
	}
	
	public SamplePage enterName(String name) {
		elementName.sendKeys(name);
		System.out.println(name+": Name entered succesfully");
		
		return this;
	}
	
	public SamplePage enterEmail(String email) {
		elementEmail.sendKeys(email);
		System.out.println(email+": Email entered succesfully");
		
		return this;
	}
	
	public SamplePage selectExperience(String ddl) {
		elementExperience.click();
		Select selectOption=new Select (elementExperience);
		selectOption.selectByVisibleText(ddl);
		
		String optionSelected=selectOption.getFirstSelectedOption().getText();
		System.out.println("Selected Experience: "+optionSelected);
		return this;
	}
	
	public SamplePage selectExpertise1() {
		
		return this;
	}
	
	public SamplePage selectExpertise2() {
		
		return this;
	}
	
	public SamplePage selectExpertise3() {
		
		return this;
	}
	
	public SamplePage selectEducation1() {
		
		return this;
	}
	
	public SamplePage selectEducation2() {
		
		return this;
	}
	
	public SamplePage selectEducation3() {
		
		return this;
	}
	
	public SamplePage enterComment() {
		
		return this;
	}
	
	public SamplePage clickSubmit() {
		
		return this;
		}
		
		*/
	
}
