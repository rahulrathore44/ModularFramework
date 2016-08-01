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
import com.modular.framework.interfaces.IdataReader;
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
	public static Object[][] getLoginData() throws Exception {
		log.info("Data Provider");
		IdataReader helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/Login.xlsx"));
		return helper.getData("LoginDetails");
	}
	
	@DataProvider(name="getLoginDatafromAno")
	public static Object[][] getLoginDatafromAno(Method mth) throws Exception {
		log.info("Data Provider");
		ExcelFileLocation location = mth.getAnnotation(ExcelFileLocation.class);
		IdataReader helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/" + location.xlFileName()));
		return helper.getData(location.sheetName());
	}

}
