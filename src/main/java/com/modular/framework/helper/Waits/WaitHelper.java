/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Generic.GenericHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
public class WaitHelper {
	
	
	private static WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, unit);
		if(exceptiontoIgnore != null){
			for (Class exp : exceptiontoIgnore) {
				wait.ignoring(exp);
			}
		}
		return wait;
	}
	
	
	public static void setImplicitWait(long timeout,TimeUnit unit) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit);
		
	}
	
	public static void waitForElement(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		wait.until(ExpectedConditions.visibilityOf(GenericHelper.getElement(locator)));
	}

	public static void hardWait(int timeOutInMiliSec) throws InterruptedException {
		Thread.sleep(timeOutInMiliSec);
	}
	

}
