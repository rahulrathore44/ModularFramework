package com.modular.framework.interfaces;

import java.util.List;
import java.util.Map;

public interface IexcelReader {
	
	public Object[][] getData(String sheet);
	public Object[][] getData();
	public List<Map<String, Object>> getExcelData();
	public List<Map<String, Object>> getExcelData(String sheet);

}
