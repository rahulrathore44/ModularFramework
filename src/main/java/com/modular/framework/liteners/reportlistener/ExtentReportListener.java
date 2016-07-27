/**
 * @author rahul.rathore
 *	
 *	24-Jul-2016
 */
package com.modular.framework.liteners.reportlistener;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.modular.framework.helper.Generic.GenericHelper;
import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.utility.DateTimeHelper;
import com.modular.framework.utility.ResourceHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author rahul.rathore
 *
 *         24-Jul-2016
 *
 */
public class ExtentReportListener implements ISuiteListener,ITestListener {

	public static final Logger log = LoggerHelper
			.getLogger(ExtentReportListener.class);

	private ExtentReports exReport = null;
	private ExtentTest exTest = null;

	public void onFinish(ISuite arg0) {
		try {
			exReport.flush();
		} finally {
			exReport.close();
		}
	}

	public void onStart(ISuite suite) {
		exReport = new ExtentReports(
				ResourceHelper.getResourcePath("reports/extentreport/")
						+ suite.getName() + DateTimeHelper.getCurrentDateTime()
						+ ".html");

	}

	public void onFinish(ITestContext test) {
		exReport.endTest(exTest);
	}

	public void onStart(ITestContext test) {
		exTest = exReport.startTest(test.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult test) {
		exTest.log(LogStatus.FAIL, test.getMethod().getMethodName());
		exTest.log(LogStatus.FAIL, test.getThrowable());
		try {
			exTest.log(LogStatus.INFO, exTest.addScreenCapture(GenericHelper.takeScreenShot(test.getMethod().getMethodName())));
		}catch (IOException e) {
			log.error("Cannot Add the ScreenShot", e);
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult test) {
		exTest.log(LogStatus.PASS, test.getMethod().getMethodName());
		
	}

}
