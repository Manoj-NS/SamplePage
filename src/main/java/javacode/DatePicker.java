package javacode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		WebElement makeappButton = driver.findElement(By.id("btn-make-appointment"));
		makeappButton.click();
		
		WebElement enterUsername = driver.findElement(By.id("txt-username"));
		enterUsername.sendKeys("John Doe");

		WebElement enterPassword = driver.findElement(By.id("txt-password"));
		enterPassword.sendKeys("ThisIsNotAPassword");
		
		WebElement clickloginButton = driver.findElement(By.id("btn-login"));
		clickloginButton.click();
		
		WebElement clickDatePicker = driver.findElement(By.id("txt_visit_date"));
		clickDatePicker.click();
		
//To select date		
		WebElement dateSelect = driver.findElement(By.xpath("//td[text()=20]"));
		dateSelect.click();
//		System.out.println("Selected Date: "+dateSelect.getText());
		
//To Change Month
		
		WebElement monthChange = driver.findElement(By.xpath("//th[text()='June 2024']"));
		monthChange.click();
		
		WebElement monthSelect = driver.findElement(By.xpath("//span[text()='Dec']"));
		monthSelect.click();
		
		WebElement newdateSelect = driver.findElement(By.xpath("(//td[text()='25'])[2]"));
		newdateSelect.click();

//Enter Date			
		WebElement enterDate = driver.findElement(By.id("txt_visit_date"));
		enterDate.clear();
		enterDate.sendKeys("25/11/2024");
		
		
	}

}
