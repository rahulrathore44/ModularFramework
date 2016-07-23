/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Navigation;

import org.openqa.selenium.WebDriver;

import com.modular.framework.helper.InitWebdriver;
import com.sun.jndi.toolkit.url.Uri;

/**
 * @author rahul.rathore
 *
 *         23-Jul-2016
 *
 */
public class NavigationHelper {

	public static void navigateTo(String url) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.get(url);

	}

	public static void naviagteTo(Uri url) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.get(url.getPath());

	}

	public static String getTitle() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		return driver.getTitle();
	}

	public static String getCurrentUrl() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		return driver.getCurrentUrl();
	}
}
