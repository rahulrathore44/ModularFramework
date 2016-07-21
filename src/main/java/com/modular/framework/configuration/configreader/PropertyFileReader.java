/**
 * rsr 
 *
 *Jul 21, 2016
 */
package com.modular.framework.configuration.configreader;

import java.io.FileInputStream;
import java.util.Properties;

import com.modular.framework.configuration.browser.BrowserType;
import com.modular.framework.interfaces.IconfigReader;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rsr
 *
 *         Jul 21, 2016
 */
public class PropertyFileReader implements IconfigReader {

	private Properties prop = null;

	public PropertyFileReader() {

		prop = new Properties();
		try {
			prop.load(ResourceHelper
					.getResourcePathInputStream("resources/configfile/config.properties"));
			System.out.println(prop.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PropertyFileReader(String fileName) {

		prop = new Properties();
		try {
			prop.load(ResourceHelper
					.getResourcePathInputStream("resources/configfile/"
							+ fileName));
			System.out.println(prop.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

}
