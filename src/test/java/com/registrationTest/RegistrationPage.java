package com.registrationTest;

import java.io.IOException;

import com.homepageTest.HomePageConst;
import frameset.ReadConfigFile;

public class RegistrationPage extends HomePageConst {
	
	public RegistrationPage(){
		// default Constructor
	}
	
	/**
	 * This method will check if first name field is displayed.
	 * @return
	 * @throws IOException
	 */
	public boolean isFirstNameFieldDisplayed() throws IOException{
		return isElementVisibleByID(ReadConfigFile.readConfigurationFile().getProperty("First_Name"));
	}
	
	/**
	 * This method will check if last name field is displayed.
	 * @return
	 * @throws IOException
	 */
	public boolean isLastNameFieldDisplayed() throws IOException{
		return  isElementVisibleByID(ReadConfigFile.readConfigurationFile().getProperty("Last_Name"));
	}

}
