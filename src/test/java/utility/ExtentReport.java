package utility;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
	    
		String path=System.getProperty("user.dir"+"\\target\\ExtentReports\\ExtentReports.html");
		sparkReporter=new ExtentSparkReporter(path);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("Functional Test Report");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("os",context.getCurrentXmlTest().getParameter("os"));
		extentReports.setSystemInfo("browser",context.getCurrentXmlTest().getParameter("browser"));
		extentReports.setSystemInfo("execution",context.getCurrentXmlTest().getParameter("execution"));
	  
		List<String> lst=context.getCurrentXmlTest().getIncludedGroups();
		extentReports.setSystemInfo("Groups Inlcuded", lst.toString());
	}
	
	public void onTestSuccess(ITestResult result) {
	    
		extentTest=extentReports.createTest(result.getTestClass().getTestName());
		extentTest.log(Status.PASS,result.getTestName()+" Got Passed");
		extentTest.assignCategory(result.getMethod().getGroups());
	  }
	
	public void onTestFailure(ITestResult result) {
	   
		extentTest=extentReports.createTest(result.getClass().getName());
		
		extentTest.log(Status.FAIL,result.getTestName()+" Got Failed");
		extentTest.assignCategory(result.getMethod().getGroups());
		String target="";
		try {
			
			target=ScreenshotUtility.takeScreenshot(result.getTestName());
			
		} catch (IOException e) {
			
			System.out.println("Unable to capture Screenshot...");
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(target);
	  }
	
	public void onFinish(ITestContext context) {
	   
		extentReports.flush();
	  }
}
