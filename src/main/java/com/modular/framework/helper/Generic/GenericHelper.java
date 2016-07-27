/**
 * @author rahul.rathore
 *	
 *	23-Jul-2016
 */
package com.modular.framework.helper.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.utility.DateTimeHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rahul.rathore
 *
 *         23-Jul-2016
 *
 */
public class GenericHelper {

	public static final Logger log = LoggerHelper
			.getLogger(GenericHelper.class);

	public static WebElement getElement(By locator) {
		
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			log.error("Error : ", re);
			throw re;
		}

	}

	public static boolean IsElementPresentQuick(By locator) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		log.info(locator);
		return driver.findElements(locator).size() >= 1;
	}
	
	public static String takeScreenShot(String name) throws IOException {
		
		WebDriver driver = InitWebdriver.getDefaultDriver();
		
		if(driver instanceof HtmlUnitDriver){
			log.error("HtmlUnitDriver Cannot Take ScreenShot");
			return null;
		}
			
		File destDir = new File(ResourceHelper.getResourcePath("screenshots/") + DateTimeHelper.getCurrentDate());
		if(!destDir.exists())
			destDir.mkdir();
		
		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
					, destPath);
			log.info(destPath.getAbsoluteFile());
		} catch (IOException e) {
			log.error("Screenshot Failed", e);
			throw e;
		}
		return destPath.getAbsolutePath();
	}
	
	public static String takeScreenShot() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}

}
