/**
 * rsr 
 *
 *Jul 21, 2016
 */
package com.modular.framework.configuration.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author rsr
 *
 * Jul 21, 2016
 */
public class HtmlUnitBrowser {
	
	public static WebDriver getHtmlUnitDriver() {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		return driver;
	}

}
