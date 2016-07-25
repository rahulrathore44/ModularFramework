/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 */
package com.modular.framework.helper.dropdown;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 *
 */
public class DropDownHelper {
	
	public static final Logger log = LoggerHelper
			.getLogger(DropDownHelper.class);
	
	public static void SelectUsingVisibleValue(By locator,String visibleValue) {
		Select select = new Select(GenericHelper.getElement(locator));
		select.selectByVisibleText(visibleValue);
		log.info("Locator : " + locator + " Value : " + visibleValue);
	}
	
	public static void SelectUsingValue(By locator,String value) {
		Select select = new Select(GenericHelper.getElement(locator));
		select.selectByValue(value);
		log.info("Locator : " + locator + " Value : " + value);
	}
	
	public static void SelectUsingIndex(By locator,int index) {
		Select select = new Select(GenericHelper.getElement(locator));
		select.selectByIndex(index);
		log.info("Locator : " + locator + " Index : " + index);
	}
	
	public static List<String> getAllDropDownValues(By locator) {
		Select select = new Select(GenericHelper.getElement(locator));
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			log.info("Dropdown Value : " + element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}

}
