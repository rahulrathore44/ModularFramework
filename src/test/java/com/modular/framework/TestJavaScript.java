/**
 * rsr 
 *
 *Jul 27, 2016
 */
package com.modular.framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Alert.AlertHelper;
import com.modular.framework.helper.Browser.BrowserHelper;
import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.Javascript.JavaScriptHelper;
import com.modular.framework.helper.Waits.WaitHelper;

/**
 * @author rsr
 *
 * Jul 27, 2016
 */
public class TestJavaScript extends InitWebdriver {
	
	@Test
	public void testConfirm() {
		Driver.get("http://www.google.com");
		JavaScriptHelper.executeScript("confirm('Press a button');");
		AlertHelper.AcceptAlertIfPresent();
		JavaScriptHelper.executeScript("confirm('Press a button');");
		AlertHelper.DismissAlertIfPresent();
	}
	
	@Test
	public void testGetAlertText() {
		Driver.get("http://www.google.com");
		JavaScriptHelper.executeScript("prompt('Please enter your name');");
		System.out.println(AlertHelper.getAlertText());
		AlertHelper.AcceptPrompt("Harry Potter");
		JavaScriptHelper.executeScript("prompt('Please enter your name');");
		AlertHelper.DismissAlertIfPresent();
	}
	
	@Test
	public void testPromt() {
		Driver.get("http://www.google.com");
		JavaScriptHelper.executeScript("prompt('Please enter your name');");
		AlertHelper.AcceptPrompt("Harry Potter");
		JavaScriptHelper.executeScript("prompt('Please enter your name');");
		AlertHelper.DismissAlertIfPresent();
	}
	
	@Test
	public void testAlert() {
		Driver.get("http://www.google.com");
		JavaScriptHelper.executeScript("alert('Please enter your name');");
		System.out.println(AlertHelper.getAlertText());
		AlertHelper.AcceptAlertIfPresent();
	}
	
	@Test
	public void testScrollTo() throws IOException {
		Driver.get("https://www.udemy.com/");
		JavaScriptHelper.scrollToElemet(By.xpath("//a[text()='Sign Up' and @class='signup-link btn btn-success signup-btn mt20']"));
		GenericHelper.takeScreenShot("testScrollTo");
		JavaScriptHelper.scrollIntoView(By.xpath("//a[text()='Sign Up' and @class='dropdown__main-link']"));
		GenericHelper.takeScreenShot("testScrollIntoView");
	}
	
	@Test
	public void testScrollToAncClick() throws IOException, InterruptedException {
		Driver.get("https://www.udemy.com/");
		JavaScriptHelper.scrollToElemetAndClick(WaitHelper.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='signup-link btn btn-success signup-btn mt20']"), 5, 2));
		GenericHelper.takeScreenShot("testScrollToClick");
		BrowserHelper.goBack();
		BrowserHelper.goForward();
		JavaScriptHelper.scrollIntoViewAndClick(WaitHelper.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='dropdown__main-link']"), 5, 2));
		GenericHelper.takeScreenShot("testScrollIntoViewClick");
	}

}
