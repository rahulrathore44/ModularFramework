package com.modular.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Button.ButtonHelper;
import com.modular.framework.helper.HyperLink.LinkHelper;
import com.modular.framework.helper.TextBox.TextBoxHelper;
import com.modular.framework.helper.Waits.WaitHelper;

public class MainClass extends InitWebdriver{
	
	@Test
	public void test() throws Exception {
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 20, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login"), reader.getUserName());
		TextBoxHelper.sendKeys(By.id("Bugzilla_password"), reader.getPassword());
		ButtonHelper.click(By.id("Bugzilla_restrictlogin"));
	}

}
