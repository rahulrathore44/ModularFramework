/**
 * rsr 
 *
 *Jul 29, 2016
 */
package com.modular.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.CheckBox.CheckBoxOrRadioButtonHelper;
import com.modular.framework.helper.Waits.WaitHelper;

/**
 * @author rsr
 *
 * Jul 29, 2016
 */
public class TestCheckBox extends InitWebdriver {
	
	@Test
	public void testCheckBoxButton() {
		Driver.get("https://www.utexas.edu/learn/forms/checkboxes.html");
		WaitHelper.elementExits(By.id("graphics"), reader.getExplicitWait(), 250, TimeUnit.SECONDS);
		System.out.println(CheckBoxOrRadioButtonHelper.isIselected(By.id("graphics")));
		CheckBoxOrRadioButtonHelper.selectCheckBox(By.id("graphics"));
		System.out.println(CheckBoxOrRadioButtonHelper.isIselected(By.id("graphics")));
		CheckBoxOrRadioButtonHelper.unSelectCheckBox(By.id("graphics"));
		System.out.println(CheckBoxOrRadioButtonHelper.isIselected(By.id("graphics")));
	}

}
