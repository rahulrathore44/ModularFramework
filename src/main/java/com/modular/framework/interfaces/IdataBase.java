/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 */
package com.modular.framework.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 *
 */
public interface IdataBase {
	
	public Object[][] getData(String query,String... columnName) throws SQLException,ClassNotFoundException;
	public Object[][] getData(String query)throws SQLException,ClassNotFoundException;
	public List<Map<String, Object>> getDbData(String query)throws SQLException,ClassNotFoundException;
	public List<Map<String, Object>> getDbData(String query,String... columnName)throws SQLException,ClassNotFoundException;

}
