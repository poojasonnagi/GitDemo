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

@Test
public class ValidateTitle extends base {
	
	
	public WebDriver driver;

	LandingPage l;
	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
     
	public void basePageNavigation( ) throws IOException, InterruptedException {
     
		driver = intializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		///log.error("I am not able to execute");
		l = new LandingPage(driver);
		Thread.sleep(2000);
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSE");
       // log.debug("check me if am right");
  
	}
	@AfterTest
	public void close()
	{
		
		driver.close();
		log.info("I am closed");
	}
	
	
}
