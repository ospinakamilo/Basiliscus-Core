/**
 * 
 * @author Camilo A. Ospina A.
 * 
 */
package basiliscus.init;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import automatedTests.SettingsParameters;
import basiliscus.exceptions.DriverError;
import basiliscus.values.Driver;

import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This class is used to setup the Selenium Drivers based on the 
 * Operating System and Settings Parameters. 
 * 
 */
public class OperatingSystemDriver {

	// DO NOT TOUCH	
	private WebDriver localDriver=null;	
	

	
	
	/**
	 * Set the private attribute localDriver to a new WebDriver,
	 * based on the Operating System and driver attribute of
	 * the class automatedTests.config.SettingsParameters.
	 * 
	 */
	public OperatingSystemDriver() throws Exception{

		switch(SettingsParameters.DRIVER){
			case FIREFOX:
				if(SystemUtils.IS_OS_LINUX){

					//TO DO

				}else if (SystemUtils.IS_OS_WINDOWS) {
					System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					capabilities.setCapability("moz:firefoxOptions", options);
					capabilities.setCapability("marionette", true);
		            this.localDriver= new FirefoxDriver(capabilities);

				}else if (SystemUtils.IS_OS_MAC) {

					//TO DO

				}

				break;

			case CHROME:
				if(SystemUtils.IS_OS_LINUX){

					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriverlinux");

				}else if (SystemUtils.IS_OS_WINDOWS) {

					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriver.exe");

				}else if (SystemUtils.IS_OS_MAC) {

					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedrivermac");

				}

				this.localDriver= new ChromeDriver();
				break;
			case SAFARI:
				this.localDriver= new SafariDriver();
				break;
			case IE:
				File file = new File("src/test/resources/Drivers/IEDriverServer.exe");
	            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	            
	            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            capabilities.setCapability("initialBrowserUrl", "https://");
	            this.localDriver= new InternetExplorerDriver(capabilities);
	            break;
			


		default:
			throw new DriverError(String.format("Configured Driver '%s' not availble for %s", SettingsParameters.DRIVER ,"creation."));
		}
			

		
	}
	
	
	/**
	 * Set the private attribute localDriver to a new WebDriver,
	 * based on the Operating System and the parameter given.
	 * @param browser type of local driver to use.
	 * Valid values are: Driver.CHROME, Driver.FIREFOX or Driver.INTERNET_EXPLORER.
	 * 
	 */
	public OperatingSystemDriver(Driver browser) throws Exception{

		switch(browser){
			case FIREFOX:
				if(SystemUtils.IS_OS_LINUX){

					//TO DO

				}else if (SystemUtils.IS_OS_WINDOWS) {
					System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					capabilities.setCapability("moz:firefoxOptions", options);
					capabilities.setCapability("marionette", true);
		            this.localDriver= new FirefoxDriver(capabilities);
		            
		            
				}else if (SystemUtils.IS_OS_MAC) {

					//TO DO

				}

				break;

			case CHROME:
				if(SystemUtils.IS_OS_LINUX){
					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriverlinux");

				}else if (SystemUtils.IS_OS_WINDOWS) {
					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriver.exe");

				}else if (SystemUtils.IS_OS_MAC) {

					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedrivermac");

				}

				this.localDriver= new ChromeDriver();
				break;
				
			case SAFARI:
				this.localDriver= new SafariDriver();
				break;
			case IE:
				File file = new File("src/test/resources/Drivers/IEDriverServer.exe");
	            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	            
	            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
	            capabilities.setCapability("initialBrowserUrl", "https://");
	            this.localDriver= new InternetExplorerDriver(capabilities);
	            break;


		default:
			throw new DriverError(String.format("Driver '%s' not availble for %s", browser ,"creation."));
		}

		
	}
	
	
	
	
	/**
	 * Set the private attribute localDriver to a new WebDriver,
	 * based on the Operating System and the parameter given.
	 * @param browser type of local driver to use.
	 * Valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.INTERNET_EXPLORER.
	 * @param capabilities
	 * 
	 */
	public OperatingSystemDriver(Driver browser, DesiredCapabilities capabilities) throws Exception{

		switch(browser){
			case FIREFOX:
				if(SystemUtils.IS_OS_LINUX){

					//TO DO

				}else if (SystemUtils.IS_OS_WINDOWS) {
					System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
		            this.localDriver= new FirefoxDriver(capabilities);

				}else if (SystemUtils.IS_OS_MAC) {

					//TO DO

				}
				
				break;

			case CHROME:
				if(SystemUtils.IS_OS_LINUX){
					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriverlinux");

				}else if (SystemUtils.IS_OS_WINDOWS) {
					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedriver.exe");

				}else if (SystemUtils.IS_OS_MAC) {

					System.setProperty("webdriver.chrome.driver",
							"src/test/resources/Drivers/chromedrivermac");

				}

				this.localDriver= new ChromeDriver(capabilities);
				break;
				
			case SAFARI:
				this.localDriver= new SafariDriver();
				break;
			case IE:
				File file = new File("src/test/resources/Drivers/IEDriverServer.exe");
	            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	            
	            this.localDriver= new InternetExplorerDriver(capabilities);
	            break;


		default:
			throw new DriverError(String.format("Driver '%s' not availble for %s", browser ,"creation."));
		}

		
	}

	

	/**
	 * Returns the localDriver if it has been initialized with initLocalDriver().
	 * Else returns null.
	 * 
	 */
	public WebDriver getLocalDriver() {
		
		return this.localDriver;
	}

}
