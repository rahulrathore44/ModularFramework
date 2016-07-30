/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 */
package com.modular.framework.interfaces;

import java.util.List;
import java.util.Map;

/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 *
 */
public interface IdataBase {
	
	public Object[][] getData(String table);
	public Object[][] getData();
	public List<Map<String, Object>> getDbData();
	public List<Map<String, Object>> getDbData(String table);

}
