package com.modular.framework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.modular.framework.configuration.browser.BrowserType;
import com.modular.framework.configuration.browser.ChromeBrowser;
import com.modular.framework.configuration.browser.FirefoxBrowser;
import com.modular.framework.configuration.browser.HtmlUnitBrowser;
import com.modular.framework.configuration.browser.IExploreBrowser;
import com.modular.framework.configuration.browser.PhantomJsBrowser;
import com.modular.framework.configuration.configreader.PropertyFileReader;

public class InitWebdriver {

	protected static PropertyFileReader reader = null;
	protected static WebDriver Driver = null;

	public InitWebdriver() {
		reader = new PropertyFileReader();
	}

	public InitWebdriver(String fileName) {
		reader = new PropertyFileReader(fileName);
	}

	@BeforeTest
	public static void setUp() {
		BrowserType type = reader.getBrowser();

		switch (type) {

		case Firefox:
			Driver = FirefoxBrowser.getFirefoxDriver(FirefoxBrowser.getFirefoxCapabilities());
			break;

		case Chrome:
			Driver = ChromeBrowser.getChromeDriver(ChromeBrowser
					.getChromeCapabilities());
			break;

		case HtmlUnitDriver:
			Driver = HtmlUnitBrowser.getHtmlUnitDriver();
			break;

		case Iexplorer:
			Driver = IExploreBrowser.getIExplorerDriver(IExploreBrowser
					.getIExplorerCapabilities());
			break;

		case PhantomJs:
			Driver = PhantomJsBrowser.getPhantomJsDriver(
					PhantomJsBrowser.getPhantomJsService(),
					PhantomJsBrowser.getPhantomJsCapability());
			break;
		default:
			Driver = HtmlUnitBrowser.getHtmlUnitDriver();
			break;
		}
	}

	@AfterTest(alwaysRun = true)
	public static void tearDown() {
		
		if(Driver != null){
			Driver.quit();
			Driver = null;
		}
	}

}
