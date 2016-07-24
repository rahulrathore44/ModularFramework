/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *
 *         23-Jul-2016
 *
 */
public class GenericHelper {

	public static final Logger log = LoggerHelper
			.getLogger(GenericHelper.class);

	public static WebElement getElement(By locator) {
		
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			log.error("Error : ", re);
			throw re;
		}

	}

	public static boolean IsElementPresentQuick(By locator) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(locator);
		return driver.findElements(locator).size() >= 1;
	}

}
