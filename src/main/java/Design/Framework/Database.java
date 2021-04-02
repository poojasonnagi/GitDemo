package Design.Framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
  String host= "localhost";
  String port= "3306";
		
		
		Connection con= DriverManager.getConnection("jdbc:mysql://"+ host +":"+port+"/qadbt","root","daddygod1#");
		
		Statement s= con.createStatement();
		ResultSet rs=s.executeQuery("Select * from demo");
		while(rs.next())
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("pass")).sendKeys(rs.getString("password"));
		
		}
	}

}
