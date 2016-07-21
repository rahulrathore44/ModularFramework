/**
 * rsr 
 *
 *Jul 21, 2016
 */
package com.modular.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author rsr
 *
 *         Jul 21, 2016
 */
public class FirefoxBrowser {

	public static Capabilities getFirefoxCapabilities() {

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		return cap;
	}

	public static WebDriver getFirefoxDriver(Capabilities cap) {
		FirefoxDriver driver = new FirefoxDriver(cap);
		return driver;
	}

}
