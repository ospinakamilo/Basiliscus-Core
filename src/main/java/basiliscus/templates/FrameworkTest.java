package basiliscus.templates;

import java.util.ArrayList;

import org.openqa.selenium.remote.DesiredCapabilities;

import basiliscus.helpers.BrowserHelper;
import basiliscus.values.Driver;
import basiliscus.values.Resolution;


public abstract class FrameworkTest {
	
		
	private static ArrayList<BrowserHelper>  helperDrivers = new ArrayList<BrowserHelper>();
	
	
	/**
	 * This method creates a new SeleniunLocalHelper instance in the test
	 * using the default browser
	 */
	protected BrowserHelper newFrameworkDriver() {		
		BrowserHelper newDriver = new BrowserHelper();
		helperDrivers.add(newDriver);
		return newDriver;		
	}
	
	
	/**
	 * This method creates a new SeleniunLocalHelper instance in the test
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.SAFARI.
	 */
	protected BrowserHelper newFrameworkDriver(Driver browser) {		
		BrowserHelper newDriver = new BrowserHelper(browser);
		helperDrivers.add(newDriver);
		return newDriver;		
	}
	
	/**
	 * This method creates a new SeleniunLocalHelper instance in the test
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.SAFARI.
	 * @param resolution
	 * valid values are: Resolution.DESKTOP_LARGE, Resolution.DESKTOP_MEDIUM, Resolution.TABLET or Resolution.MOBILE.
	 */
	protected BrowserHelper newFrameworkDriver(Driver browser, Resolution resolution ) {		
		BrowserHelper newDriver = new BrowserHelper(browser, resolution);
		helperDrivers.add(newDriver);
		return newDriver;		
	}
	
	/**
	 * This method creates a new SeleniunLocalHelper instance in the test
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.SAFARI.
	 * @param capabilities
	 */
	protected BrowserHelper newFrameworkDriver(Driver browser, DesiredCapabilities capabilities){
		BrowserHelper newDriver = new BrowserHelper(browser,capabilities);
		helperDrivers.add(newDriver);
		return newDriver;
		
	}
	
	
	
	/**
	 * This method quits every open driver.
	 */
	protected static void quitFrameworkDrivers(){
		for (BrowserHelper driver : helperDrivers) {
			driver.quit();
		}
	}

}
