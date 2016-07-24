/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Button;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class ButtonHelper {
	
	public static final Logger log = LoggerHelper.getLogger(ButtonHelper.class);
	
	public static void click(By locator) {
		GenericHelper.getElement(locator).click();
		log.info(locator);
	}

}
