/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.TextBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class TextBoxHelper {
	
	public static final Logger log = LoggerHelper
			.getLogger(TextBoxHelper.class);
	
	public static void sendKeys(By locator,String value) {
		log.info("Locator : " + locator + " Value : " + value);
		GenericHelper.getElement(locator).sendKeys(value);
	}
	
	public static void clear(By locator) {
		log.info(locator);
		GenericHelper.getElement(locator).clear();
	}
	
	public static String getText(By locator) {
		log.info(locator);
		return GenericHelper.getElement(locator).getText();
	}
	
	public static void clearAndSendKeys(By locator,String value) {
		WebElement element =  GenericHelper.getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

}
