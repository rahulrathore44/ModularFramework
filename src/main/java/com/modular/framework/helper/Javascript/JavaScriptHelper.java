/**
 * rsr 
 *
 *Jul 25, 2016
 */
package com.modular.framework.helper.Javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rsr
 *
 * Jul 25, 2016
 */
public class JavaScriptHelper {
	
	public static final Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public static Object executeScript(String script) {
		
		WebDriver driver = InitWebdriver.getDefaultDriver();
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		log.info("Javascript : " + script);
		exe.executeAsyncScript(script);
		return null;
		
	}

}
