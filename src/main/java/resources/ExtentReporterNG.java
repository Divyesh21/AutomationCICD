package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
	String path=System.getProperty("user.dir")+"//reports//index. html";
	
	  
    //WebDriver driver=new ChromeDriver();
    
    //driver.get("google.com");
    
    ExtentSparkReporter reporter=new ExtentSparkReporter(path);// create html file for report
    reporter.config().setReportName("Web Automation results");
    reporter.config().setDocumentTitle("Test Results");
    
    ExtentReports extent=new ExtentReports();
    extent.attachReporter(reporter);	
    extent.setSystemInfo("Tester", "Divyesh Gavade");
    return extent;
}
	
}
