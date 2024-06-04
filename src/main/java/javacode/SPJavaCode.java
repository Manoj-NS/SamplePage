package javacode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SamplePage;

public class SPJavaCode {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.globalsqa.com/samplepagetest/");
		
		
		
		
		WebElement elementName = driver.findElement(By.id("g2599-name"));
		elementName.sendKeys("Surya");
		System.out.println(elementName.getAttribute("value")+": Name entered succesfully");
		
		WebElement elementEmail = driver.findElement(By.id("g2599-email"));
		elementEmail.sendKeys("test@123.com");
		
		WebElement elementExperienxeDDL = driver.findElement(By.id("g2599-experienceinyears"));
		Select experienceDDL = new Select(elementExperienxeDDL);
		
		List<WebElement> ddlOptions=experienceDDL.getOptions();
		System.out.println("Total DDL Options: "+ddlOptions.size());
			for (WebElement expddlOptions : ddlOptions) {
			System.out.println(expddlOptions.getText());
				}
			experienceDDL.selectByVisibleText("3-5");
		//	experienceDDL.deselectByVisibleText("3-5");
			experienceDDL.selectByVisibleText("7-10");
	//To print the selected option	
			
			WebElement selectedOption=experienceDDL.getFirstSelectedOption();
			System.out.println("Selected Options: "+selectedOption.getText());
			
//Checkbox	
			
			List<WebElement> checkboxOptions=driver.findElements(By.xpath("//input[@type='checkbox']"));
			
			int expertiseOptionsCount = checkboxOptions.size();
			System.out.println("Expertise Checkbox Count: "+expertiseOptionsCount);
			
			
			for (WebElement expertiseOptions : checkboxOptions) {
				
				System.out.println("Expertise Checkbox Option: "+expertiseOptions.getAttribute("value"));
				
				String expCheckboxOptions = expertiseOptions.getAttribute("value");
				
				
				String actualCheckbox = "Automation Testing";
				
				if (expCheckboxOptions.equals(actualCheckbox)) {
					
					expertiseOptions.click();
					System.out.println("Selected Checkbox: "+expCheckboxOptions);
				}
				
			}
			
			
			WebElement expertiseCheckbox01 = driver.findElement(By.xpath("//label[contains(text(),'Functional Testing')]"));
			System.out.println("checkbox01: "+expertiseCheckbox01.getText());
			String checkbox1=expertiseCheckbox01.getText();

			WebElement expertiseCheckbox02 = driver.findElement(By.xpath("//label[contains(text(),'Automation Testing')]"));
			System.out.println("checkbox02: "+expertiseCheckbox02.getText());
			String checkbox2=expertiseCheckbox02.getText();
			
			WebElement expertiseCheckbox03 = driver.findElement(By.xpath("//label[contains(text(),'Manual Testing')]"));
			System.out.println("checkbox03: "+expertiseCheckbox03.getText());
			String checkbox3=expertiseCheckbox03.getText();
			
			expertiseCheckbox01.click();
			
			if(checkbox1.equals(checkbox3)) {
				
			}
			
			
			
			
			
// To Select Radio Button
			
			////div[@class='grunion-field-wrap grunion-field-checkbox-multiple-wrap']
			
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
			
		List<WebElement> radioOptions = driver.findElements(By.xpath("//input[@type='radio']"));	
		
		int radioLen=radioOptions.size();
		System.out.println("Total Check Box: "+radioLen);	
		
		System.out.println("Checkbox Options: ");
		for(WebElement eduOptions: radioOptions) 
		
		{
//		System.out.println(eduOptions.getAttribute("value"));
			String eduOptions1=eduOptions.getAttribute("value");
			System.out.println(eduOptions1);
			
				String radioOptions1="Other";
			
			if(eduOptions1.equals(radioOptions1)) {
				eduOptions.click();
				
				
			System.out.println("Selected Checkbox: "+eduOptions1);	
				
			}
		
		}
	
		
			
		
			
			
	/*	
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

			elementName.sendKeys(name);
			System.out.println(name+": Name entered succesfully");
			
				elementEmail.sendKeys(email);
			System.out.println(email+": Email entered succesfully");
	}		
	*/	
		
	

		
	// driver.close();	
	
	}
	

}
