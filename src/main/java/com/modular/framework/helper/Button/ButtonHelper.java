/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Button;

import org.openqa.selenium.By;

import com.modular.framework.helper.Generic.GenericHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class ButtonHelper {
	
	public static void click(By locator) {
		GenericHelper.getElement(locator).click();
	}

}
