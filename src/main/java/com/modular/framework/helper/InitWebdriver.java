package com.modular.framework.helper;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.modular.framework.configuration.browser.BrowserType;
import com.modular.framework.configuration.browser.ChromeBrowser;
import com.modular.framework.configuration.browser.FirefoxBrowser;
import com.modular.framework.configuration.browser.HtmlUnitBrowser;
import com.modular.framework.configuration.browser.IExploreBrowser;
import com.modular.framework.configuration.browser.PhantomJsBrowser;
import com.modular.framework.configuration.configreader.PropertyFileReader;
import com.modular.framework.configuration.exception.NoSutiableDriverFoundException;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.interfaces.IconfigReader;



public class InitWebdriver {

	protected static PropertyFileReader reader = null;
	protected static WebDriver Driver = null;
	public static final Logger log = LoggerHelper.getLogger(InitWebdriver.class);

	public InitWebdriver() {
		reader = new PropertyFileReader();
	}

	public InitWebdriver(String fileName) {
		reader = new PropertyFileReader(fileName);
	}

	@BeforeTest
	public static void setUp() {
		BrowserType type = reader.getBrowser();
		log.info("Browser Type : " + type);
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
			throw new NoSutiableDriverFoundException(" Driver Not Found : " + reader.getBrowser());
		}
		Driver.manage().timeouts().pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		Driver.get(reader.getWebsite());
	}
	
	public static WebDriver getDefaultDriver() {
		log.debug("Driver Object");
		return Driver;
	}
	
	public static IconfigReader getReader(){
		log.debug("Reader Object");
		return reader;
	}
	
	@AfterTest(alwaysRun = true)
	public static void tearDown() {
		
		if(Driver != null){
			Driver.quit();
			Driver = null;
			log.info("Shutting down the Driver");
		}
	}

}
