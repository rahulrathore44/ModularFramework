/**
 * rsr 
 *
 *Jul 25, 2016
 */
package com.modular.framework;

import java.io.IOException;

import org.testng.annotations.Test;

import com.modular.framework.helper.InitWebdriver;
import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.utility.DateTimeHelper;

/**
 * @author rsr
 *
 * Jul 25, 2016
 */
public class TestScreenShot extends InitWebdriver {
	
	@Test
	public void testTakeScreenShor() throws IOException {
		Driver.get("https://www.youtube.com/");
		System.out.println(GenericHelper.takeScreenShot(DateTimeHelper.getCurrentDateTime()));
	}
}
