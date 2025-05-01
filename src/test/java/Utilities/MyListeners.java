package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test.BaseTest;

public class MyListeners implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String reportname="", screenshotname="";
	public BaseTest bt;
	
	public  WebDriver driver;
	
	public void onStart(ITestContext context) {
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd-hh-MM-ss");
		Date d = new Date();
		String timestamp = df.format(d);
		
		reportname = "Test-Report"+timestamp+".html";
		
		 String reportpath = System.getProperty("user.dir")+"//Reports//"+reportname;
		sparkReporter = new ExtentSparkReporter(reportpath);
		 sparkReporter.config().setReportName("Cura Health Test Report");
		 sparkReporter.config().setDocumentTitle("Functionality Report");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		 
		 extent.attachReporter(sparkReporter);
		 
		 extent.setSystemInfo("AppName", "Cura Health");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("Tester Name", "Kaveri");
		 extent.setSystemInfo("os", "Windows");
		 extent.setSystemInfo("Browser", "chrome");
	
	  }
	 public void onTestStart(ITestResult result) {
		//System.out.println("***TEST STARTED***");
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, "Test PASS : "+result.getTestClass().getName() );
	
		  }
	 
	 public void onTestFailure(ITestResult result) {
		 
		
		//System.out.println("In Test Failure method");
		test= extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, "Test FAIL : "+result.getTestClass().getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-mm-dd-hh-MM-ss");
		Date d = new Date();
		String timestamp1 = df1.format(d);
		screenshotname = result.getName()+timestamp1+".png";
		
		//Created an instance of driver and added Base class driver to it
		driver=((BaseTest) result.getInstance()).getDriver();
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
	    File source =  ts.getScreenshotAs(OutputType.FILE);	
	    String targetfilepath = System.getProperty("user.dir")+"//Screenshots//"+screenshotname;
	    
	    
	    File destination = new File(targetfilepath);
	    source.renameTo(destination);
		  
		String screenshotpath= targetfilepath+(result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
	 
	 }
	 
	 public  void onFinish(ITestContext context) {
		 //System.out.println("***FINISHED***");
		 extent.flush();
		  }

}
