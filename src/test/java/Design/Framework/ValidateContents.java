package Design.Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import PageObj.LandingPage;
import Resource.base;

public class ValidateContents extends base {

	public WebDriver driver;

	LandingPage l;
	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName()); 
     
	@Test
	public void basePageNavigation( ) throws IOException, InterruptedException {
          
		driver = intializeDriver();
		driver.manage().window().maximize();
	
		driver.get(prop.getProperty("url"));
		l = new LandingPage(driver);
		Thread.sleep(2000);
		System.out.println(l.getContext().getText());
		Assert.assertTrue(l.getContext().isDisplayed());;
        //log.error("if not displayed show error");
        
        
  
	}
	@AfterTest
	public void close()
	{
		
		driver.close();
		log.info("I am closed");
	}
	
	
}
