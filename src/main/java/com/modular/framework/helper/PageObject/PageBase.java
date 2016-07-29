/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 */
package com.modular.framework.helper.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 *
 */
public abstract class PageBase {
	
	
	public PageBase(WebDriver driver) {
		if(driver == null)
			throw new IllegalArgumentException("Driver object is null");
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='header']/ul[1]/li[11]/a")
	public WebElement LogoutBtn;

}
