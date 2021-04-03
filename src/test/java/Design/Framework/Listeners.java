package Design.Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.ExtentReport;
import Resource.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReport.config();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onFinish(ITestContext context) {
	  System.out.println("Flush me");
		extent.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tell once started");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try
		{
		driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch(Exception e)
		{
			
		}
		try
		{    extentTest.get().addScreenCaptureFromPath(getScreenShot(testMethodName,driver), result.getMethod().getMethodName());
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("hellow we are back again");
		System.out.println("hellow we are back again");
		System.out.println("hellow we are back again");
		System.out.println("hellow we are back again");
		System.out.println("hellow we are back again");
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test passed");
	}
	
	
	

	
	
	
	
	
}
