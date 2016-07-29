/**
 * rsr 
 *
 *Jul 28, 2016
 */
package com.modular.framework;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Button.ButtonHelper;
import com.modular.framework.helper.DataProvider.DataProviderHelper;
import com.modular.framework.helper.DataProvider.ExcelFileLocation;
import com.modular.framework.helper.ExcelReader.ExcelReaderHelper;
import com.modular.framework.helper.HyperLink.LinkHelper;
import com.modular.framework.helper.TextBox.TextBoxHelper;
import com.modular.framework.helper.Waits.WaitHelper;
import com.modular.framework.helper.dropdown.DropDownHelper;
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
	
	@Test
	public void testExcelWithMap() {
		ExcelReaderHelper helper = new ExcelReaderHelper(ResourceHelper.getResourcePath("exceldata/Login.xlsx"), "CreateBug");
		Driver.get(reader.getWebsite());
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 250, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login"), reader.getUserName());
		TextBoxHelper.sendKeys(By.id("Bugzilla_password"), reader.getPassword());
		ButtonHelper.click(By.id("Bugzilla_restrictlogin"));
		ButtonHelper.click(By.id("log_in"));
		WaitHelper.waitForElement(By.partialLinkText("Testng"), 60, 250, TimeUnit.SECONDS, NoSuchElementException.class);
		List<Map<String, Object>> data = helper.getExcelData();
		
		for (Map<String, Object> map : data) {
			LinkHelper.clickPartialLink("Testng");
			WaitHelper.waitForElement(By.id("rep_platform"), 60, 250, TimeUnit.SECONDS, NoSuchElementException.class);
			DropDownHelper.SelectUsingVisibleValue(By.id("bug_severity"), map.get("Severity").toString());
			DropDownHelper.SelectUsingVisibleValue(By.id("rep_platform"), map.get("Hardware").toString());
			DropDownHelper.SelectUsingVisibleValue(By.id("op_sys"), map.get("OS").toString());
			TextBoxHelper.sendKeys(By.id("short_desc"), map.get("Summary").toString());
			TextBoxHelper.sendKeys(By.id("comment"), map.get("Description").toString());
			ButtonHelper.click(By.id("commit"));
			WaitHelper.waitForElement(By.id("commit_top"), 60, 250, TimeUnit.SECONDS, 
					NoSuchElementException.class,
					ElementNotFoundException.class);
			ButtonHelper.click(By.xpath("//div[@id='header']/ul[1]/li[2]/a"));
			WaitHelper.waitForElement(By.xpath("//div[@id='bugzilla-body']/table/tbody/tr[1]/th/a"), 60, 250, TimeUnit.SECONDS, 
					NoSuchElementException.class,
					ElementNotFoundException.class);
		}
		ButtonHelper.click(By.xpath("//div[@id='header']/ul[1]/li[11]/a"));
	}
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderHelper.class)
	public void testDataProvider(Map<String, Object> map) {
		Driver.get(reader.getWebsite());
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 250, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login"), map.get("UserName").toString());
		TextBoxHelper.sendKeys(By.id("Bugzilla_password"), map.get("Password").toString());
		ButtonHelper.click(By.id("Bugzilla_restrictlogin"));
		ButtonHelper.click(By.id("log_in"));
	}
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderHelper.class)
	@ExcelFileLocation(xlFileName="Login.xlsx",sheetName="LoginDetails")
	public void testDataProviderFromAno(Map<String, Object> map) {
		Driver.get(reader.getWebsite());
		LinkHelper.clickPartialLink("File a Bug");
		WaitHelper.waitForElement(By.id("Bugzilla_login"), 90, 250, TimeUnit.SECONDS, NoSuchElementException.class,
				ElementNotFoundException.class,
				ElementNotVisibleException.class);
		TextBoxHelper.sendKeys(By.id("Bugzilla_login"), map.get("UserName").toString());
		TextBoxHelper.sendKeys(By.id("Bugzilla_password"), map.get("Password").toString());
		ButtonHelper.click(By.id("Bugzilla_restrictlogin"));
		ButtonHelper.click(By.id("log_in"));
	}

}
