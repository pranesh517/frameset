package com.homepageTest;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends HomePageConst {
	ExtentReports extents;
	ExtentTest logger;
	
	@BeforeTest
	public void startReports(){
		extents = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+System.currentTimeMillis()+".html", true);
		extents.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
	}
	
	@Test(description = "This method will verify visibility of First Name field.")
	public void TC0015() throws IOException{
		logger = extents.startTest("First Name is Visible");
		launchBrowserAndURL();
		logger.log(LogStatus.PASS, "URL is launched successfully.");
		Assert.assertTrue(isRegistrationButtonDisplayed());
		logger.log(LogStatus.PASS, "Registration button is displayed.");
	}
	
	@AfterMethod
	public void captureFailure(ITestResult result) throws IOException{
		if(ITestResult.FAILURE == result.getStatus()){
			logger.log(LogStatus.FAIL, "Test is failed.");
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			takesScreenShot();
		} else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		extents.endTest(logger);
		driver.quit();
	}
	
	@AfterTest
	public void endReport(){
		extents.flush();
		extents.close();		
	}

}
