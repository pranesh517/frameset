package com.homepageTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.registrationTest.RegistrationPage;

import frameset.CommonUtilities;
import frameset.ReadConfigFile;

public class HomePageConst extends CommonUtilities {
	
	public void launchBrowserAndURL() throws IOException{
		String classPth = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", classPth+"/src/test/resources/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); 
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ReadConfigFile.readConfigurationFile().getProperty("URL"));
	}
	
	public RegistrationPage clickOnRegistrationButton() throws IOException{
		clickOnElementUsingXpath(ReadConfigFile.readConfigurationFile().getProperty("Registration_button"));
		return new RegistrationPage();
	}

}
