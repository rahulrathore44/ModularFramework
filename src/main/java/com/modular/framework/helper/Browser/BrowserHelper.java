/**
 * rsr 
 *
 *Jul 26, 2016
 */
package com.modular.framework.helper.Browser;

import java.util.LinkedList;
import java.util.Set;

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
	
	public static Set<String> getWindowHandlens() {
		log.debug("");
		return InitWebdriver.getDefaultDriver().getWindowHandles();
	}
	
	public static void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		
		if( index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);
		 
		InitWebdriver.getDefaultDriver().switchTo().window(windowsId.get(index));
		log.info("Index : " + index);
	}
	
	public static void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		InitWebdriver.getDefaultDriver().switchTo().window(windowsId.get(0));
		log.info("");
	}
	
	public static void switchToParentWithChildClose() {
		switchToParentWindow();	
		
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		WebDriver driver = InitWebdriver.getDefaultDriver();
		
		for(int i = 1; i < windowsId.size(); i++){
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow();	
	}
}
