/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 */
package com.modular.framework.interfaces;

import com.modular.framework.configuration.browser.BrowserType;

/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 *
 */
public interface IconfigReader {
	
	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
	
}
