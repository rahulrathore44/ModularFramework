package com.modular.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.modular.framework.utility.DateTimeHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rsr
 *
 * Jul 21, 2016
 */
public class ChromeBrowser {

	public static Capabilities getChromeCapabilities() {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setJavascriptEnabled(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}
	
	public static WebDriver getChromeDriver(Capabilities cap){
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		//System.setProperty("webdriver.chrome.logfile", ResourceHelper.getResourcePath("logs/chromelog/chromelog" + DateTimeHelper.getCurrentDateTime() + ".log"));
		ChromeDriver driver = new ChromeDriver(cap);
		return driver;
	}

}
