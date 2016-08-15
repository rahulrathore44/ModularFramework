###Modular Framework

Selenium Modular Framework using Testng. Classes to handle the web components are present and can be used directly in the code.
The framework has following features 

1. Modular Design
2. Maven based framework
3. Log4j enabled for logging
4. Report Generation (Excel & Extent reports) 
5. Helper class to handle web component such as (Button,Link etc)
6. Centralized Configuration (Using Properties file)
7. POM
8. Support reading the data form Excel and Database.

###Here is the basic code:

Extend your test class from InitWebdriver class.

```java
package com.modular.framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Browser.BrowserHelper;
import com.modular.framework.helper.Javascript.JavaScriptHelper;

/**
 * @author rsr
 *
 * Jul 27, 2016
 */
public class TestBrowserWindow extends InitWebdriver {
	
	@Test
	public void testBrowser() {
		Driver.get("http://www.gmail.com");
		JavaScriptHelper.executeScript("window.open('http://www.w3schools.com', '', 'width=100, height=100');");
		BrowserHelper.SwitchToWindow(1);
		BrowserHelper.browserMaximize();
		Assert.assertNotNull(Driver.getTitle());
		BrowserHelper.switchToParentWindow();
		Assert.assertNotNull(Driver.getTitle());
		BrowserHelper.switchToParentWithChildClose();
		Assert.assertNotNull(Driver.getTitle());
	}

}

```

### Use the testng.xml file to run the test cases 

```xml
<suite name="Suite">
	<listeners>
		<listener
			class-name="com.modular.framework.liteners.reportlistener.ExcelReportListener" />
		<listener
			class-name="com.modular.framework.liteners.reportlistener.ExtentReportListener" />
	</listeners>
	<test name="Test - 1">
		<classes>
			<class name="com.modular.framework.TestBrowserWindow" />
		</classes>
	</test>
</suite>
```

### To see this whole thing running simply checkout this project and run this command:

`mvn clean generate-sources test`
