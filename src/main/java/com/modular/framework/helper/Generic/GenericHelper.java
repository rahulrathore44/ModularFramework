/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.framework.helper.InitWebdriver;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class GenericHelper {
	
	public static WebElement getElement(By locator) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		if(IsElementPresentQuick(locator))
			return driver.findElement(locator);
		throw new NoSuchElementException("Element Not Found : " + locator);
	}
	
	public static boolean IsElementPresentQuick(By locator) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		return driver.findElements(locator).size() >= 1; 
	}

}
