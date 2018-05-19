package frameset;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class CommonUtilities {
	
	protected WebDriver driver;
	
	/**
	 * This method will enter text in text field.
	 * 
	 * @param id : String ID.
	 * @param valueToEnter : String Value to enter.
	 */
	public void enterValueInTextFieldUsingID(String id, String valueToEnter){
		driver.findElement(By.id(id)).sendKeys(valueToEnter);
	}
	
	/**
	 * This method will check if element is visible.
	 * 
	 * @param id : String ID.
	 * @return true if visible.
	 */
	public boolean isElementVisibleByID(String id){
		return driver.findElement(By.id(id)).isDisplayed();
	}
	
	/**
	 * This method will click on Element.
	 * 
	 * @param xpath : String Xpath.
	 */
	public void clickOnElementUsingXpath(String xpath){
		driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * This method will click on Element Using ID.
	 * 
	 * @param id : String ID. 
	 */
	public void clickOnElementUsingID(String id){
		driver.findElement(By.id(id)).click();
	}
	
	/**
	 * This method will verify if element is visible by xpath.
	 * 
	 * @param xpath : String Xpath.
	 * @return true if visible.
	 */
	public boolean isElmentDisplayedByXpath(String xpath){
		return driver.findElement(By.xpath(xpath)).isDisplayed();
		
	}
	
	/**
	 * This method will wait for 5 seconds.
	 */
	public void waitForLoadingRing(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will take a screenshot.
	 * 
	 * @throws IOException
	 */
	public void takesScreenShot() throws IOException{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+System.currentTimeMillis()+"error.png"));
	}

}
