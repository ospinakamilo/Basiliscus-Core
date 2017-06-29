/**
 * 
 * @author Camilo A. Ospina A.
 * 
 */
package basiliscus.helpers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import automatedTests.SettingsParameters;
import basiliscus.init.SeleniumLocalDriver;
import basiliscus.values.Driver;
import basiliscus.values.Resolution;


/**
 * This Class allows a simple interaction with Selenium Local Drivers
 */
public class BrowserHelper {
	
	private WebDriver driver;
	private Driver browser;
	private Resolution resolution;
	
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 */
	public BrowserHelper(){
		this.browser=automatedTests.SettingsParameters.DRIVER;		
		this.driver= new SeleniumLocalDriver().getDriver();
		resolution = automatedTests.SettingsParameters.RESOLUTION;
		
	}
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 * @param navigator 
	 * valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.SAFARI.
	 */
	public BrowserHelper(Driver navigator){
		this.browser=navigator;
		this.driver= new SeleniumLocalDriver(navigator).getDriver();
		resolution = automatedTests.SettingsParameters.RESOLUTION;
	}
	
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 * @param navigator 
	 * valid values are: Driver.CHROME, Driver.FIREFOX, Driver.IE or Driver.SAFARI.
	 * @param capabilities
	 */
	public BrowserHelper(Driver navigator, DesiredCapabilities capabilities){
		this.browser=navigator;
		this.driver= new SeleniumLocalDriver(navigator, capabilities).getDriver();
		resolution = automatedTests.SettingsParameters.RESOLUTION;
	}
	
	
	/**
	 * This method creates a SeleniumLocalHelper instance.
	 * @param navigator 
	 * valid values are: Driver.CHROME, Driver.FIREFOX or Driver.SAFARI.
	 * @param size 
	 * valid values are: Resolution.DESKTOP_LARGE, Resolution.DESKTOP_MEDIUM, Resolution.TABLET or Resolution.MOBILE.
	 */
	public BrowserHelper(Driver navigator, Resolution size){
		this.browser=navigator;
		this.driver= new SeleniumLocalDriver(navigator, size).getDriver();
		resolution = size;
	}
	
	
	/**
	 * This method returns the driver's instance, a <<WebDriver>> class.
	 */
	public WebDriver getDriver(){
		return this.driver;
	}
	
	
	/**
	 * This method loads a URL in the current browser window.
	 * @param url The URL to visit on the current browser window.
	 */
	public void loadUrl(String url){
		this.driver.get(url);		
	}
	
	
	/**
	 * @return the resolution
	 */
	public Resolution getResolution() {
	
		return resolution;
	}
	
	
	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(Resolution resolution) {
	
		this.resolution = resolution;
	}
	
	
	/**
	 * This method returns an element looking it out by the Id attribute in the HTML.
	 * @param id The id attribute to search on the HTML DOM.
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementById(String id){
		return this.driver.findElement(By.id(id));		
	}
	
	
	/**
	 * This method returns an element looking it out by the Name attribute in the HTML.
	 * @param name The name attribute to search on the HTML DOM.
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByName(String name){
		return this.driver.findElement(By.name(name));		
	}
	
	
	/**
	 * This method returns an element looking it out by the Xpath route.
	 * @param xpath The Xpath route of the element.
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByXpath(String xpath){
		return this.driver.findElement(By.xpath(xpath));		
	}
	
	
	/**
	 * Find an element via the driver's underlying W3 Selector engine. If the browser does not implement the Selector API, a best effort is made to emulate the API. 
	 * @param selector css expression
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByCssSelector(String selector){
		return this.driver.findElement(By.cssSelector(selector));		
	}
	
	
	/**
	 * Find an element searching by its tag name e.g: h1,p,a. 
	 * @param name The element's tagName
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByTag(String name){
		return this.driver.findElement(By.tagName(name));		
	}
	
	
	/**
	 * Find an element searching by its exact text. 
	 * @param text The exact text to match against
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByText(String text){
		return this.driver.findElement(By.linkText(text));		
	}
	
	
	/**
	 * Find an element searching by some text. 
	 * @param partialText The text to match against
	 * @return The first matching element on the current page.
	 */
	public WebElement findElementByPartialText(String partialText){
		return this.driver.findElement(By.partialLinkText(partialText));		
	}
	
	
	/**
	 * This method returns all elements found by a given name.
	 * @param name The name attribute to search on the HTML DOM.
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByName(String name){
		return this.driver.findElements(By.name(name));		
	}
	
	
	/**
	 * Finds elements based on the value of the "class" attribute. If an element has many classes then this will match against each of them. For example if the value is "one two onone", then the following "className"s will match: "one" and "two"
	 * @param className The value of the "class" attribute to search for
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByClassName(String className){
		return this.driver.findElements(By.className(className));		
	}
	
	
	/**
	 * Finds elements via the driver's underlying W3 Selector engine. If the browser does not implement the Selector API, a best effort is made to emulate the API. 
	 * @param selector css expression
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByCssSelector(String selector){
		return this.driver.findElements(By.cssSelector(selector));		
	}
	
		
	/**
	 * Finds elements searching by their tag name e.g: h1,p,a. 
	 * @param name The element's tagName
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByTag(String name){
		return this.driver.findElements(By.tagName(name));		
	}
	
	
	/**
	 * Find elements searching by its exact text. 
	 * @param text The exact text to match against
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByText(String text){
		return this.driver.findElements(By.linkText(text));		
	}
	
	
	/**
	 * Find elements searching by some text. 
	 * @param partialText The text to match against
	 * @return A list of all the matching WebElements on the current page, or an empty list if nothing matches.
	 */
	public List<WebElement> findElementsByPartialText(String partialText){
		return this.driver.findElements(By.partialLinkText(partialText));		
	}

	
	/**
	 * Waits an Element for the Implicit wait configured in class SettingsParameters until is clickable an then clicks it.
	 */	
	public void click(WebElement elementToClick) throws Exception{
		if(this.browser == Driver.CHROME || this.browser == Driver.SAFARI){
			boolean clicked=false;
			Exception e2=null;
			
			for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(SettingsParameters.IMPLICIT_WAIT_SECONDS);stop>System.nanoTime();) {
				try {
					
					elementToClick.click();
					clicked=true;
			        break;		
				} catch (WebDriverException e) {
					e2=e;
					JavascriptExecutor js =(JavascriptExecutor)driver;
			        js.executeScript("window.scrollTo(0,"+(elementToClick.getLocation().y-70)+")");
			        
				}
			}
			if (!clicked){
				throw e2;
			}
		}else{
			elementToClick.click();
		}
	}

	/**
	* Select dropdown value
	* 
	* @param selectElement The Select element
	* @param value Tha value to select
	*
	*/
	public void selectValueFromSelect (Select selectElement, String value){

		selectElement.selectByValue(value);
	}
	
	/**
	* Check the element
	*
	* @param element To be check
	 * @throws Exception 
	*/
	public void toggleCheckbox(WebElement element) throws Exception{
		if (!element.isSelected()) {
			click(element);
		}
	}

	/**
	* Uncheck the element
	*
	* @param element To be uncheck
	 * @throws Exception 
	*/
	public void uncheckCheckbox(WebElement element) throws Exception{
		if (element.isSelected()) {
			click(element);
		}
	}	
	
	/**
	 * Quits this driver, closing every associated window.
	 */
	public void quit(){
		this.driver.quit();
	}
	
	
	/**
	 * Close the current window, quitting the browser if it's the last window currently open.
	 */
	public void close(){
		this.driver.close();
	}
	
	/**
	 * Send ESPACE character to element and clean the element
	 * @param element The element to be clear
	 */
	public void cleanElement(WebElement element){
		element.sendKeys(" ");
		element.clear();
	}

}
