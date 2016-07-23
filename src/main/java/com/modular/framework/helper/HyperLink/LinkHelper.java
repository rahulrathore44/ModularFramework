/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.HyperLink;

import org.openqa.selenium.By;

import com.modular.framework.helper.Generic.GenericHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class LinkHelper {
	
	public static void clickLink(String linkText) {
		GenericHelper.getElement(By.linkText(linkText)).click();
		
	}
	
	public static void clickPartialLink(String partialLinkText) {
		GenericHelper.getElement(By.partialLinkText(partialLinkText)).click();
		
	}

}
