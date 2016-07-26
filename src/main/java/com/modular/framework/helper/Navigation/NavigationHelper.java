/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Navigation;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *
 *         23-Jul-2016
 *
 */
public class NavigationHelper {
	
	public static final Logger log = LoggerHelper.getLogger(NavigationHelper.class);

	public static void navigateTo(String url) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.get(url);
		log.info(url);
	}

	public static void naviagteTo(URL url) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.get(url.getPath());
		log.info(url);
	}

	public static String getTitle() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(driver.getTitle());
		return driver.getTitle();
	}

	public static String getCurrentUrl() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
}
