package com.registrationTest;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationTest extends RegistrationPage {
	ExtentReports extents;
	ExtentTest logger;
	
	@BeforeTest
	public void startReports(){
		extents = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+System.currentTimeMillis()+".html", true);
		extents.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
	}
	
	@Test(description = "This method will verify visibility of First Name field.")
	public void TC001() throws IOException{
		logger = extents.startTest("First Name is Visible");
		launchBrowserAndURL();
		logger.log(LogStatus.PASS, "URL is launched successfully.");
		clickOnRegistrationButton();
		logger.log(LogStatus.PASS, "Clicked on Registration button.");
		waitForLoadingRing();
		Assert.assertTrue(isFirstNameFieldDisplayed());
		logger.log(LogStatus.PASS, "First Name field is displayed..");
	}
	
	@Test(description = "This method will verify visibility of Last Name field.")
	public void TC002() throws IOException{
		logger = extents.startTest("Last Name is Visible");
		launchBrowserAndURL();
		logger.log(LogStatus.PASS, "URL is launched successfully.");
		clickOnRegistrationButton();
		logger.log(LogStatus.PASS, "Clicked on Registration button.");
		waitForLoadingRing();
		Assert.assertTrue(isLastNameFieldDisplayed());
		logger.log(LogStatus.PASS, "Last Name field is displayed..");
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
