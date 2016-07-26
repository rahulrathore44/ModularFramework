/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Waits;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 *
 */
@SuppressWarnings("rawtypes")
public class WaitHelper {
	
	public static final Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	private static WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, unit);
		if(exceptiontoIgnore != null){
			for (Class exp : exceptiontoIgnore) {
				wait.ignoring(exp);
			}
		}
		log.debug("Getting the Wait Object");
		return wait;
	}
	
	
	public static void setImplicitWait(long timeout,TimeUnit unit) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
		log.debug("Timeout :" + timeout);
	}
	
	public static void waitForElement(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		log.info(locator);
		wait.until(ExpectedConditions.visibilityOf(GenericHelper.getElement(locator)));
		setImplicitWait(InitWebdriver.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}

	public static void hardWait(int timeOutInMiliSec) throws InterruptedException {
		log.debug("Sleep : " + timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}
	
	public static void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec,TimeUnit unit,Class...exceptiontoIgnore ) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec, unit, exceptiontoIgnore);
		log.info(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(InitWebdriver.getReader().getImplicitWait(), TimeUnit.SECONDS);
	}

}
