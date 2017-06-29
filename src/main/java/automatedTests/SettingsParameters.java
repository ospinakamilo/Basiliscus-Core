package automatedTests;

import basiliscus.values.*;


/**
 * This class is used to set the default parameters of the framework.
 * e.g: The Default Browser, Resolution, Implicit wait time, and anything else
 * you consider parameterizable on your tests .
 */
public class SettingsParameters{
	
	
	public static Resolution RESOLUTION = Resolution.DESKTOP_LARGE; //Default Resolution to use unless parameters are given.
	public static Driver DRIVER = Driver.CHROME; //Default driver to use, unless parameters are given.
	public static Integer IMPLICIT_WAIT_SECONDS=7; //Time to wait till page loads
	
	

}
