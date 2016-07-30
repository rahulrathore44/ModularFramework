/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 */
package com.modular.framework.helper.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.modular.framework.configuration.configreader.PropertyFileReader;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.interfaces.IdataBase;

/**
 * @author rahul.rathore
 *	
 *	30-Jul-2016
 *
 */
public class DataBaseHelper implements IdataBase {
	
	private String connectionStr = "";
	private ResultSet resultSet = null;
	
	protected static final Logger log = LoggerHelper.getLogger(DataBaseHelper.class);
	
	public Statement getConnection() throws SQLException, ClassNotFoundException {
		if("sql".equalsIgnoreCase(((PropertyFileReader)InitWebdriver.getReader()).getDbConnStr()))
			Class.forName("com.microsoft.sqlserver.jdbc.SqlServerDriver");
		else
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection(this.connectionStr);
		return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	public void setConnectionStr(String connectionStr) {
		this.connectionStr = connectionStr;
	}

	public DataBaseHelper(String connectionStr) {
		if("".equalsIgnoreCase(connectionStr))
			setConnectionStr(((PropertyFileReader)InitWebdriver.getReader()).getDbConnStr());
		else
			this.connectionStr = connectionStr;
	}
	
	public void executeQuery(String query) throws SQLException, ClassNotFoundException {
		try(Statement exeStatment = getConnection()) {
			if(query.contains("select") || query.contains("Select")){
				resultSet = exeStatment.executeQuery(query);
			}else{
				exeStatment.executeUpdate(query);
			}
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
	}
	
	public ResultSet getResult(){
		return resultSet;
	}

	@Override
	public Object[][] getData(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[][] getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getDbData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getDbData(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
