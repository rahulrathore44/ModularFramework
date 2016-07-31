package com.modular.framework;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Database.DataBaseHelper;

public class TestClassDb extends InitWebdriver {

	@Test
	public void name() throws ClassNotFoundException, SQLException {
		DataBaseHelper helper = new DataBaseHelper();
		Object [][]data = helper.getData("Select * from customers");
		
		List<Map<String, Object>> test = helper.getDbData("Select * from customers");
		for (Map<String, Object> map : test) {
			for  ( String s : map.keySet() ) {
				System.out.println("   " + s + "  : "  + map.get(s));
			}
		}
		
		List<Map<String, Object>> test1 = helper.getDbData("Select * from orders","ORDER_NO");
		for (Map<String, Object> map : test1) {
			for  ( String s : map.keySet() ) {
				System.out.println("   " + s + "  : "  + map.get(s));
			}
		}
		System.out.println(data.length);
	}
}
