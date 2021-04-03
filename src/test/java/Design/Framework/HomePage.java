package Design.Framework;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObj.LandingPage;
import PageObj.LoginPage;
import Resource.base;


public class HomePage extends base {

	public WebDriver driver;

	LandingPage l;
	
     
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException, InterruptedException {
         
		
		 
		driver = intializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		l = new LandingPage(driver);
		Thread.sleep(5000);
		
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getForgetPassword().click();
		System.out.println("Hello all , i am manipulated once");
        
	}
    
	@DataProvider
	public Object[][] getData() {
		
		System.out.println("Hello all , i am inside data provider");
		Object[][] data = new Object[2][2];

		data[0][0] = "pooja";
		data[0][1] = "1234";
		data[1][0] = "arati";
		data[1][1] = "5678";
		return data;
	}

	@AfterTest
	public void close()
	{
		
		driver.close();
		System.out.println("I am closed");
	}
	
	
	
}
