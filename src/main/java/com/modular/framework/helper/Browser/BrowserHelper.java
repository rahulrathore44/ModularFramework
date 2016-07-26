/**
 * rsr 
 *
 *Jul 26, 2016
 */
package com.modular.framework.helper.Browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rsr
 *
 * Jul 26, 2016
 */
public class BrowserHelper {
	
	public static final Logger log = LoggerHelper.getLogger(BrowserHelper.class);
	
	public static void browserMaximize() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.manage().window().maximize();
		log.info("");
	}
	
	public static void goBack() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.navigate().back();
		log.info("");
	}
	
	public static void goForward() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.navigate().forward();
		log.info("");
	}
	
	public static void refresh() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.navigate().refresh();
		log.info("");
	}
}
