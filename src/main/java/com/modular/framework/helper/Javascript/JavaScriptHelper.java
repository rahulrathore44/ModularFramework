/**
 * rsr 
 *
 *Jul 25, 2016
 */
package com.modular.framework.helper.Javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rsr
 *
 *         Jul 25, 2016
 */
public class JavaScriptHelper {

	public static final Logger log = LoggerHelper
			.getLogger(JavaScriptHelper.class);

	public static Object executeScript(String script) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info("Javascript : " + script);
		return exe.executeScript(script);
	}

	public static Object executeScript(String script, Object... args) {
		WebDriver driver = InitWebdriver.getDefaultDriver();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info("Javascript : " + script);
		return exe.executeScript(script, args);
	}

	public static void scrollToElemet(WebElement element) {
		log.info(element);
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
	}

	public static void scrollToElemet(By locator) {
		log.info(locator);
		scrollToElemet(GenericHelper.getElement(locator));
	}

	public static void scrollToElemetAndClick(By locator) {
		log.info(locator);
		WebElement element = GenericHelper.getElement(locator);
		scrollToElemet(element);
		element.click();
	}

	public static void scrollToElemetAndClick(WebElement element) {
		log.info(element);
		scrollToElemet(element);
		element.click();
	}

	public static void scrollIntoView(WebElement element) {
		log.info(element);
		executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void scrollIntoView(By locator) {
		log.info(locator);
		scrollIntoView(GenericHelper.getElement(locator));
	}

	public static void scrollIntoViewAndClick(By locator) {
		log.info(locator);
		WebElement element = GenericHelper.getElement(locator);
		scrollIntoView(element);
		element.click();
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		log.info(element);
		scrollIntoView(element);
		element.click();
	}
}
