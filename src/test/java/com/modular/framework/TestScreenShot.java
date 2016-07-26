/**
 * rsr 
 *
 *Jul 25, 2016
 */
package com.modular.framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Browser.BrowserHelper;
import com.modular.framework.helper.Button.ButtonHelper;
import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.Navigation.NavigationHelper;
import com.modular.framework.helper.Waits.WaitHelper;
import com.modular.framework.utility.DateTimeHelper;

/**
 * @author rsr
 *
 * Jul 25, 2016
 */
public class TestScreenShot extends InitWebdriver {
	
	@Test
	public void testTakeScreenShor() throws IOException {
		Driver.get("https://www.youtube.com/");
		System.out.println(GenericHelper.takeScreenShot(DateTimeHelper.getCurrentDateTime()));
	}
	
	@Test
	public void browserTest() {
		Driver.get("https://www.youtube.com/");
		WaitHelper.waitForElementVisible(By.xpath("//span[text()='Sign in']"), 
				60, 250,
				TimeUnit.SECONDS, 
				ElementNotVisibleException.class,
				NoSuchElementException.class);
		ButtonHelper.click(By.xpath("//span[text()='Sign in']"));
		BrowserHelper.goBack();
		BrowserHelper.goForward();
		BrowserHelper.refresh();
		System.out.println(" Titlte : "+ NavigationHelper.getTitle());
	}
}
