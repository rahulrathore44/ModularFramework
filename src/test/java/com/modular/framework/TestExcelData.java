/**
 * rsr 
 *
 *Jul 28, 2016
 */
package com.modular.framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.ExcelReader.ExcelReaderHelper;
import com.modular.framework.utility.ResourceHelper;

/**
 * @author rsr
 *
 * Jul 28, 2016
 */
public class TestExcelData extends InitWebdriver {
	
	@Test
	public void testExcelProvider() {
		ExcelReaderHelper helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/Login.xlsx"), "LoginDetails");
		Assert.assertEquals(helper.getData().length,3);
		Assert.assertEquals(helper.getData("Details").length,4);
	}

}
