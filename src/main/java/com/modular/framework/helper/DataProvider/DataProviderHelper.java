/**
 * @author rahul.rathore
 *	
 *	28-Jul-2016
 */
package com.modular.framework.helper.DataProvider;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.modular.framework.helper.ExcelReader.ExcelReaderHelper;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rahul.rathore
 *	
 *	28-Jul-2016
 *
 */
public class DataProviderHelper {
	
	public static final Logger log = LoggerHelper.getLogger(DataProviderHelper.class);
	
	@DataProvider(name="getLoginData")
	public static Object[][] getLoginData() {
		log.info("Data Provider");
		ExcelReaderHelper helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/Login.xlsx"), "LoginDetails");
		return helper.getData();
	}
	
	@DataProvider(name="getLoginDatafromAno")
	public static Object[][] getLoginDatafromAno(Method mth) {
		log.info("Data Provider");
		ExcelFileLocation location = mth.getAnnotation(ExcelFileLocation.class);
		ExcelReaderHelper helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/" + location.xlFileName()), location.sheetName());
		return helper.getData();
	}

}
