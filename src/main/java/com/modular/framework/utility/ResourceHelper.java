/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 */
package com.modular.framework.utility;

/**
 * @author rahul.rathore
 *	
 *	20-Jul-2016
 *
 */
public class ResourceHelper {
	
	public static String getResourcePath(String resource) {
		String path = ResourceHelper.class.getClassLoader().getResource(resource).getPath();
		return path;
	}
	
	public static String getBaseResourcePath() {
		return getResourcePath("/");
	}
	
}
