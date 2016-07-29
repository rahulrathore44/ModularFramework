/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 */
package com.modular.framework.helper.PageObject.BugzilaPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.PageObject.PageBase;
import com.modular.framework.helper.Waits.WaitHelper;

/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 *
 */
public class HomePage extends PageBase {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="File a Bug")
	private WebElement NewBug;
	
	@FindBy(how=How.ID,using="find")
	public WebElement QuickSearch;
	
	public LoginPage clickNewBug() {
		NewBug.click();
		WaitHelper.waitForElement(By.id("Bugzilla_login"), InitWebdriver.getReader().getExplicitWait()
				, 250
				, TimeUnit.SECONDS, NoSuchElementException.class
				,ElementNotVisibleException.class);
		return new LoginPage(driver);
	}

}
