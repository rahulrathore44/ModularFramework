/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 */
package com.modular.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.HyperLink.LinkHelper;
import com.modular.framework.helper.TextBox.TextBoxHelper;
import com.modular.framework.helper.Waits.WaitHelper;

/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 *
 */
public class TestFailClass extends InitWebdriver {
	
	@Test
	public void testFail() {
		Driver.get(reader.getWebsite());
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 250, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login1"), reader.getUserName()); // Invalid id
	} 
	
	

}
