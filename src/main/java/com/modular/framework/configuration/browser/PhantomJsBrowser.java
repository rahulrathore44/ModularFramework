/**
 * rsr 
 *
 *Jul 21, 2016
 */
package com.modular.framework.configuration.browser;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.modular.framework.utility.DateTimeHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rsr
 *
 *         Jul 21, 2016
 */
public class PhantomJsBrowser {
	
	public static PhantomJSDriverService getPhantomJsService() {
		return new PhantomJSDriverService.Builder()
				.usingAnyFreePort()
				.usingPhantomJSExecutable(new File(ResourceHelper.getResourcePath("driver/phantomjs.exe")))
				.withLogFile(new File(ResourceHelper.getResourcePath("logs/phantomjslogs/") + "phantomjslogs" + DateTimeHelper.getCurrentDateTime() + ".log"))
				.build();
		
	}
	
	public static Capabilities getPhantomJsCapability() {
		DesiredCapabilities cap = DesiredCapabilities.phantomjs();
		cap.setJavascriptEnabled(true);
		return cap;
	}

	public static WebDriver getPhantomJsDriver(PhantomJSDriverService sev,Capabilities cap) {
		
		PhantomJSDriver driver = new PhantomJSDriver(sev,cap);
		return driver;
	}

}
