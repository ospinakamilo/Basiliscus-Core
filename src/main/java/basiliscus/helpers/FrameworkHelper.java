/**
 * 
 * @author Camilo A. Ospina A.
 * 
 */
package basiliscus.helpers;

import java.util.ArrayList;

import org.openqa.selenium.Dimension;

import basiliscus.values.Driver;
import basiliscus.values.Resolution;


/**
 * This class provides methods for creating Helpers that have access to Selenium drivers.
 */
public class FrameworkHelper {
	private static ArrayList <BrowserHelper> localDriversList = new ArrayList <BrowserHelper>();
	
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 */
	public static BrowserHelper NewLocalDriver(){
		BrowserHelper newDriver = new BrowserHelper();
		localDriversList.add(newDriver);
		return newDriver;
	}
	
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX or Driver.INTERNET_EXPLORER.
	 * @param size 
	 * valid values are: Resolution.DESKTOP_LARGE, Resolution.DESKTOP_MEDIUM, Resolution.TABLET or Resolution.MOBILE.
	 */
	public static BrowserHelper NewLocalDriver(Driver browser, Resolution size){
		BrowserHelper newDriver = new BrowserHelper(browser, size);
		localDriversList.add(newDriver);
		return newDriver;
	}


	/**
	 * This method resizes an existing SeleniumlocalHelper.
	 * @param browser existing SeleniumLocalHelper.
	 * @param resolution size to give to the current browser.
	 */
	public static void setSize(BrowserHelper browser, Resolution resolution){
		Dimension ss = new Dimension(resolution.getWidth(),resolution.getHeight());
		browser.getDriver().manage().window().setSize(ss);

	}
	
	
	/**
	 * Quit all Drivers created using the method NewLocalDriver().
	 * 
	 */
	protected void quitDrivers(){
		for (BrowserHelper currentDriver : localDriversList) {
			currentDriver.quit();			
		}
	}
	
	
	/**
	 * Sleep the Execution for an specified amount of time.
	 * @param milliseconds to sleep the execution.
	 * 
	 */
	public static void sleep(Integer milliseconds){
		try{
			Thread.sleep(milliseconds);			
		}catch (Exception e){
			e.printStackTrace();
		}
				
	}

}

