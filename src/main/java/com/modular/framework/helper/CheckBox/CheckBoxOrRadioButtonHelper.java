/**
 * rsr 
 *
 *Jul 29, 2016
 */
package com.modular.framework.helper.CheckBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rsr
 *
 * Jul 29, 2016
 */
public class CheckBoxOrRadioButtonHelper {
	
	public static final Logger log = LoggerHelper.getLogger(CheckBoxOrRadioButtonHelper.class);
	
	public static void selectCheckBox(By locator) {
		log.info(locator);
		selectCheckBox(GenericHelper.getElement(locator));
	}
	
	public static void unSelectCheckBox(By locator) {
		log.info(locator);
		unSelectCheckBox(GenericHelper.getElement(locator));
	}
	
	public static boolean isIselected(By locator) {
		return isIselected(GenericHelper.getElement(locator));
	}
	
	public static boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		log.info(flag);
		return flag;
	}
	
	public static void selectCheckBox(WebElement element) {
		log.info(element);
		if(!isIselected(element))
			element.click();
	}
	
	public static void unSelectCheckBox(WebElement element) {
		log.info(element);
		if(isIselected(element))
			element.click();
	}

}
