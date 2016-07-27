/**
 * rsr 
 *
 *Jul 27, 2016
 */
package com.modular.framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Browser.BrowserHelper;
import com.modular.framework.helper.Javascript.JavaScriptHelper;

/**
 * @author rsr
 *
 * Jul 27, 2016
 */
public class TestBrowserWindow extends InitWebdriver {
	
	@Test
	public void testBrowser() {
		Driver.get("http://www.gmail.com");
		JavaScriptHelper.executeScript("window.open('http://www.w3schools.com', '', 'width=100, height=100');");
		BrowserHelper.SwitchToWindow(1);
		BrowserHelper.browserMaximize();
		Assert.assertNotNull(Driver.getTitle());
		BrowserHelper.switchToParentWindow();
		Assert.assertNotNull(Driver.getTitle());
		BrowserHelper.switchToParentWithChildClose();
		Assert.assertNotNull(Driver.getTitle());
	}

}
