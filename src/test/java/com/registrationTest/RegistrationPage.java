package com.registrationTest;

import java.io.IOException;

import com.homepageTest.HomePageConst;
import frameset.ReadConfigFile;

public class RegistrationPage extends HomePageConst {
	
	public RegistrationPage(){
		// default Constructor
	}
	
	public boolean isFirstNameFieldDisplayed() throws IOException{
		return isElementVisibleByID(ReadConfigFile.readConfigurationFile().getProperty("First_Name"));
	}
	
	public boolean isLastNameFieldDisplayed() throws IOException{
		return  isElementVisibleByID(ReadConfigFile.readConfigurationFile().getProperty("Last_Name"));
	}

}
