package Resource;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	  WebDriver driver;
	public  Properties prop;
	
	public WebDriver intializeDriver() throws IOException, InterruptedException
	{
    	  
    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop= new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
		     driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			//include firefox code
		}
		
		
		
		Thread.sleep(5000);
		return driver;
	}
		
		
	
public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destination));
	return destination;
}
	
		
	}


