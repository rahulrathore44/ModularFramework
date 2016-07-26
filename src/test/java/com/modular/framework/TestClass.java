package com.modular.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Button.ButtonHelper;
import com.modular.framework.helper.HyperLink.LinkHelper;
import com.modular.framework.helper.TextBox.TextBoxHelper;
import com.modular.framework.helper.Waits.WaitHelper;
import com.modular.framework.helper.dropdown.DropDownHelper;

public class TestClass extends InitWebdriver{
	
	 @Test
	  public void checkThat2is3() {
	       System.out.println("Test Method");
	  }
	
	/* @Test
		public void testFail() {
			//Assert.fail("Check for Failure", new NoSuchElementException(null));
		}*/
	 
	@Test
	public void testMethod() throws Exception {
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 250, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login"), reader.getUserName());
		TextBoxHelper.sendKeys(By.id("Bugzilla_password"), reader.getPassword());
		ButtonHelper.click(By.id("Bugzilla_restrictlogin"));
		ButtonHelper.click(By.id("log_in"));
		WaitHelper.waitForElement(By.partialLinkText("Testng"), 60, 250, TimeUnit.SECONDS, NoSuchElementException.class);
		LinkHelper.clickPartialLink("Testng");
		WaitHelper.waitForElement(By.id("rep_platform"), 60, 250, TimeUnit.SECONDS, NoSuchElementException.class);
		DropDownHelper.SelectUsingVisibleValue(By.id("rep_platform"), "Other");
		List<String> values = DropDownHelper.getAllDropDownValues(By.id("rep_platform"));
		ButtonHelper.click(By.xpath("//div[@id='header']/ul[1]/li[11]/a"));
	}

}
