/**
 * rsr 
 *
 *Jul 21, 2016
 */
package com.modular.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.modular.framework.utility.DateTimeHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rsr
 *
 *         Jul 21, 2016
 */
public class IExploreBrowser {
	
	public static Capabilities getIExplorerCapabilities() {

		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
				ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		return cap;
	}
	
	public static WebDriver getIExplorerDriver(Capabilities cap) {
		System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("driver/IEDriverServer.exe"));
		//System.setProperty("webdriver.ie.driver.logfile", ResourceHelper.getResourcePath("logs/ielog/ielog" + DateTimeHelper.getCurrentDateTime() + ".log"));
		InternetExplorerDriver driver = new InternetExplorerDriver(cap);
		return driver;
	}
}
