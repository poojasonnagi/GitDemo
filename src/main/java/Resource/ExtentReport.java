package Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public ExtentReports extent;
	
	public static ExtentReports config()
	{
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("My First Test Report");
	System.out.println(reporter.config().getDocumentTitle());
	reporter.config().setReportName("Selenium WebDriver TestCases");
	
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Pooja Sonnagi");
	return extent;
	}
	
}
