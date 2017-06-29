package basiliscus.templates;


import basiliscus.helpers.BrowserHelper;
import basiliscus.values.Resolution;

public abstract class FrameworkArchetype {
	
	protected static BrowserHelper localBrowser;
	
	/**
	 * This method set a custom browser to the attribute localBrowser.
	 * @param browser
	 */
	public static void setBrowser(BrowserHelper browser){
		localBrowser = browser;
	}
	
	/**
	 * This method set a resolution to the localBrowser.
	 * @param resolution
	 */
	public static void setResolution(Resolution resolution){
		localBrowser.setResolution(resolution);	
	}

}
