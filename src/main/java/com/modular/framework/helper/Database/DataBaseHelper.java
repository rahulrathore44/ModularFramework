/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 */
package com.modular.framework.helper.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.modular.framework.configuration.configreader.PropertyFileReader;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.interfaces.IdataReader;

/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 *
 */
public class DataBaseHelper implements IdataReader {

	private String connectionStr = "";

	protected static final Logger log = LoggerHelper.getLogger(DataBaseHelper.class);

	public Statement getConnection() throws SQLException, ClassNotFoundException {
		if("sql".equalsIgnoreCase(((PropertyFileReader)InitWebdriver.getReader()).getDbType()))
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		else
			Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection(this.connectionStr);
		return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}

	public void setConnectionStr(String connectionStr) {
		this.connectionStr = connectionStr;
	}
	
	public DataBaseHelper(){
		this("");
	}

	public DataBaseHelper(String connectionStr) {
		if("".equalsIgnoreCase(connectionStr))
			setConnectionStr(((PropertyFileReader)InitWebdriver.getReader()).getDbConnStr());
		else
			this.connectionStr = connectionStr;
	}

	public ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
		try {
			Statement exeStatment = getConnection();
			if(query.contains("select") || query.contains("Select")){
				return exeStatment.executeQuery(query);
			}else{
				throw new IllegalArgumentException("Select query not found");
			}
		} catch (SQLException | ClassNotFoundException e) {
			log.error(e);
			throw e;
		}
	}
	
	public int executeUpdate(String query) throws SQLException,ClassNotFoundException {
		try(Statement exeStatment = getConnection()) {
			if(!(query.contains("select") || query.contains("Select"))){
				return exeStatment.executeUpdate(query);
			}else{
				throw new IllegalArgumentException("Dml query not found");
			}
		} catch (SQLException | ClassNotFoundException e) {
			log.error(e);
			throw e;
		}
	}

	@Override
	public Object[][] getData(String query, String... columnName)
			throws SQLException, ClassNotFoundException {
		List<Map<String, Object>> tableData = getTableData(query,columnName);

		Object[][] data = new Object[tableData.size()][1];

		int i = 0;

		for (Map<String, Object> map : tableData) {
			data[i++][0] = map;
		}

		return data;
	}

	@Override
	public Object[][] getData(String query) throws SQLException,
	ClassNotFoundException {
		List<Map<String, Object>> tableData = getTableData(query);
		Object[][] data = new Object[tableData.size()][1];

		int i = 0;

		for (Map<String, Object> map : tableData) {
			data[i++][0] = map;
		}

		return data;
	}

	@Override
	public List<Map<String, Object>> getTableData(String query)
			throws SQLException, ClassNotFoundException {
		ResultSet set = executeQuery(query);
		ResultSetMetaData metaData = set.getMetaData();
		List<Map<String, Object>> data = new LinkedList<Map<String,Object>>();

		while(set.next()){
			Map<String, Object> tableData = new LinkedHashMap<String, Object>();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				tableData.put(metaData.getColumnLabel(i), set.getObject(i));
			}
			data.add(tableData);
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> getTableData(String query,
			String... columnName) throws SQLException, ClassNotFoundException {
		List<Map<String, Object>> tableData = getTableData(query);
		List<Map<String, Object>> filterData = new LinkedList<Map<String,Object>>();

		for (Map<String, Object> map : tableData) {
			Map<String, Object> filteMap = new LinkedHashMap<String, Object>();

			for(int i = 0; i < columnName.length; i++){
				filteMap.put(columnName[i], map.get(columnName[i]));
			}
			filterData.add(filteMap);
		}
		return filterData;
	}

}
