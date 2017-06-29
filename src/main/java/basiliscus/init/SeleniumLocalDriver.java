/**
 * 
 * @author Camilo A. Ospina A.
 * 
 */
package basiliscus.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import automatedTests.SettingsParameters;
import basiliscus.values.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;



/**
 * This class allows to configure a selenium local driver instance, according
 * to the  default Settings Parameters or parameters received.
 */
public class SeleniumLocalDriver {
	
	
	// Driver Declarations DO NOT TOUCH	
	private OperatingSystemDriver SettingsInstance;
	protected WebDriver driver;
	private Dimension ss;
	
	
	/**
	 * Creates a new Selenium Driver and assigns the IMPLICIT_WAIT and RESOLUTION, based
	 * on the class automatedTests.config.Settings Parameters.
	 */
	public SeleniumLocalDriver() {
		
		try {
			SettingsInstance = new OperatingSystemDriver();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		driver=SettingsInstance.getLocalDriver();
		driver.manage().timeouts().implicitlyWait(SettingsParameters.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
		
		ss = new Dimension(SettingsParameters.RESOLUTION.getWidth(), SettingsParameters.RESOLUTION.getHeight());
		
		driver.manage().window().setSize(ss);		
	}
	
	
	/**
	 * Creates a new Selenium Driver and assigns the IMPLICIT_WAIT and RESOLUTION, based
	 * on the given parameters.
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX or Driver.SAFARI.
	 */
	public SeleniumLocalDriver(Driver browser) {
			
			try {
				SettingsInstance = new OperatingSystemDriver(browser);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			driver=SettingsInstance.getLocalDriver();
			driver.manage().timeouts().implicitlyWait(SettingsParameters.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
			
			ss = new Dimension(SettingsParameters.RESOLUTION.getWidth(), SettingsParameters.RESOLUTION.getHeight());
			
			driver.manage().window().setSize(ss);			
		}
	
	
	/**
	 * Creates a new Selenium Driver and assigns the IMPLICIT_WAIT and RESOLUTION, based
	 * on the given parameters.
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX or Driver.SAFARI.
	 * @param capabilities
	 */
	public SeleniumLocalDriver(Driver browser, DesiredCapabilities capabilities) {
			
			try {
				SettingsInstance = new OperatingSystemDriver(browser,capabilities);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			driver=SettingsInstance.getLocalDriver();
			driver.manage().timeouts().implicitlyWait(SettingsParameters.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
			
			ss = new Dimension(SettingsParameters.RESOLUTION.getWidth(), SettingsParameters.RESOLUTION.getHeight());
			
			driver.manage().window().setSize(ss);			
		}
	
	
	
	
	/**
	 * Creates a new Selenium Driver and assigns the IMPLICIT_WAIT and RESOLUTION, based
	 * on the given parameters.
	 * @param browser 
	 * valid values are: Driver.CHROME, Driver.FIREFOX or Driver.SAFARI.
	 * @param size 
	 * valid values are: Resolution.DESKTOP_LARGE, Resolution.DESKTOP_MEDIUM, Resolution.TABLET or Resolution.MOBILE.
	 */
	public SeleniumLocalDriver(Driver browser, Resolution size) {
			
			try {
				SettingsInstance = new OperatingSystemDriver(browser);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			driver=SettingsInstance.getLocalDriver();
			driver.manage().timeouts().implicitlyWait(SettingsParameters.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
			
			ss = new Dimension(size.getWidth(), size.getHeight());
			driver.manage().window().setSize(ss);			
		}
	
	
	
	/**
	 * Returns the created WebDriver.
	 */
	public WebDriver getDriver(){
		return this.driver;
	}
}
