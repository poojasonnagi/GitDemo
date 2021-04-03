package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private By signin = By.cssSelector("a[href*='sign_in']");
	private By text = By.cssSelector("div[class='text-center'] h2");
	private By context= By.cssSelector("ul[class='nav navbar-nav navbar-right'] li");

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		
	}
     
	
	public WebElement getLogin() {
		return driver.findElement(signin);
		
	}

	public WebElement getTitle() {
		
		return driver.findElement(text);
		
	}

	public WebElement getContext() {
		return driver.findElement(context);
	} 
}
