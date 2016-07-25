/**
 * rsr 
 *
 *Jul 25, 2016
 */
package com.modular.framework.helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rsr
 *
 *         Jul 25, 2016
 */
public class AlertHelper {

	public static final Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public static void AcceptAlert() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.switchTo().alert().accept();
		log.info("Accept the Alert");
	}

	public static void DismissAlert() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		driver.switchTo().alert().dismiss();
		log.info("Dismiss the Alert");
	}

	public static String getAlertText() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		String text = driver.switchTo().alert().getText();
		log.info(text);
		return text;
	}

	public static boolean isAlertPresent() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		try {
			driver.switchTo().alert();
			log.info("true");
			return true;
		} catch (Exception e) {
			// Ignore
			log.info("false");
			return false;
		}
	}

	public static void AcceptAlertIfPresent() {

		if (!isAlertPresent())
			return;
		AcceptAlert();
	}

	public static void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
	}
	
	public static void AcceptPrompt(String text) {
		
		if (!isAlertPresent())
			return;
		
		WebDriver driver = InitWebdriver.getDefaultDriver();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		log.info("Value : "+ text);
	}

}
