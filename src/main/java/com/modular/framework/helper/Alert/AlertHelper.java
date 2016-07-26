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
	
	public static Alert getAlert() {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		return driver.switchTo().alert();
	}

	public static void AcceptAlert() {
		getAlert().accept();
		log.info("Accept the Alert");
	}

	public static void DismissAlert() {
		getAlert().dismiss();
		log.info("Dismiss the Alert");
	}

	public static String getAlertText() {
		String text = getAlert().getText();
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
