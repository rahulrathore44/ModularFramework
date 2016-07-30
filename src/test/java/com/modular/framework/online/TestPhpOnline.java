/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 */
package com.modular.framework.online;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Button.ButtonHelper;
import com.modular.framework.helper.Javascript.JavaScriptHelper;
import com.modular.framework.helper.Waits.WaitHelper;

/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 *
 */
public class TestPhpOnline extends InitWebdriver {
	
	@Test
	public void testHotels() {
		Driver.get("http://phptravels.net/");
		WaitHelper.elementExits(By.xpath("//div[@class='navbar']//a[contains(.,'Hotels')]"), 60, 250, TimeUnit.SECONDS);
		ButtonHelper.click(By.xpath("//div[@class='navbar']//a[contains(.,'Hotels')]"));
		WaitHelper.elementExits(By.xpath("//label[contains(.,'Apartment')]"), 60, 250, TimeUnit.SECONDS);
		JavaScriptHelper.scrollIntoViewAndClick(By.xpath("//label[contains(.,'Apartment')]"));
		JavaScriptHelper.scrollIntoViewAndClick(By.xpath("//label[@for='Airport Transport']"));
		JavaScriptHelper.scrollIntoViewAndClick(By.id("searchform"));
	}
}
