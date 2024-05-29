package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;


public class SamplePage extends BaseClass {
	
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
}
