/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 */
package com.modular.framework;

import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.PageObject.BugzilaPage.DetailPage;
import com.modular.framework.helper.PageObject.BugzilaPage.HomePage;
import com.modular.framework.helper.PageObject.BugzilaPage.LoginPage;

/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 *
 */
public class TestPageObject extends InitWebdriver {
	
	@Test
	public void testPageObjectModel() throws SecurityException, NoSuchFieldException  {
		
		HomePage hPage = new HomePage(Driver);
		System.out.println(hPage.get(""));
		LoginPage lPage = hPage.clickNewBug();
		lPage.waitForElement(lPage.LoginTxtBx, 60);
		lPage.LoginTxtBx.sendKeys(reader.getUserName());
		lPage.PassTxtBx.sendKeys(reader.getPassword());
		lPage.RestricChk.click();
		DetailPage dPage = lPage.clickLogin();
		dPage.LogoutBtn.click();
		
	}
}
