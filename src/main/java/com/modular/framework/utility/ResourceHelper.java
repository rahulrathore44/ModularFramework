/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 */
package com.modular.framework.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.modular.framework.helper.logger.LoggerHelper;

/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 *
 */
public class ResourceHelper {
	
	public static final Logger log = LoggerHelper
			.getLogger(ResourceHelper.class);
	
	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		log.debug(path);
		return path;
	}
	
	public static String getBaseResourcePath() {
		String path = ResourceHelper.class.getClass().getResource("/").getPath();
		log.debug(path);
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(resource));
	}
	
}
