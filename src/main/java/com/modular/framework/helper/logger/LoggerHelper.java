/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 */
package com.modular.framework.helper.logger;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.modular.framework.utility.ResourceHelper;

/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 *
 */
public class LoggerHelper {
	
	private static String patteren = "%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{1}] - [%M] %m%n";
	private static Logger root = null;
	public static Layout getPatternLayout(String patteren) {
		return new PatternLayout(patteren);
	}
	
		
	public static String getPatteren() {
		return patteren;
	}

	public static void setPatteren(String patteren) {
		LoggerHelper.patteren = patteren;
	}

	public static Appender getConsoleAppender() {
		
		ConsoleAppender console = new ConsoleAppender(getPatternLayout(getPatteren()));
		console.setName("ConsoleAppender");
		console.setThreshold(Level.INFO);
		console.setTarget("System.out");
		console.activateOptions();
		return console;
	}
	
	public static Appender getRollingFileAppender() {
		
		RollingFileAppender file = new RollingFileAppender();
		file.setAppend(true);
		file.setLayout(getPatternLayout(getPatteren()));
		file.setName("Rolling File Appender");
		file.setThreshold(Level.INFO);
		file.setMaxBackupIndex(10);
		file.setFile(ResourceHelper.getResourcePath("logs/") + "Selenium.log");
		file.activateOptions();
		return file;
	}
	
	public static Logger getLogger(Class clas) {
		
		if(root != null)
			return Logger.getLogger(clas);
		
		root = Logger.getRootLogger();
		root.addAppender(getConsoleAppender());
		root.addAppender(getRollingFileAppender());
		return Logger.getLogger(clas);
	}

}
