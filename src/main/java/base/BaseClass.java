package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadExcel;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String excelFileData;
	
	
	
	@Parameters({"browserName","URL"})
	@BeforeMethod
	public void BeforeMethod(String browserName, String url)
	{
		
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
	//	driver.quit();
		
	}
	
	@DataProvider
	public String[][] SamplePage() throws IOException {
		
		return ReadExcel.getData(excelFileData);
	}
	
	

}
