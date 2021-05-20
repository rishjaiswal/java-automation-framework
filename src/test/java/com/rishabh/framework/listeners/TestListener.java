package com.rishabh.framework.listeners;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rishabh.framework.utils.DriverUtils;
import com.rishabh.framework.utils.ExtentReportUtils;
import com.rishabh.framework.utils.ScreenCaptureUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rishabh.framework.constants.Constants;

public class TestListener implements ITestListener {

	public static String testName;
	private static Logger log = LogManager.getLogger(TestListener.class.getName());

	public static String getTestMethodName() {
		return testName;
	}

	public static void setTestMethodName(String name) {
		testName = name;
	}

	ExtentTest test;
	ExtentReports extent = ExtentReportUtils.getReportObject();
	// To use for Parallel Execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult result) {
		log.error("The name of the testcase failed is : " + result.getName());

		// Move image file to new destination
		File DestFile = new File(Constants.SCREENSHOTFILEPATH + File.separator + result.getName() + ".png");

		// Copy file at destination
		try {
			FileHandler.copy(ScreenCaptureUtils.takeSnapShot(DriverUtils.initializeDriver()), DestFile);
			log.info("Sucessfully copy the screenshot in directory : " + Constants.SCREENSHOTFILEPATH);
			extentTest.get().addScreenCaptureFromPath(
					Constants.SCREENSHOTFILEPATH + File.separator + result.getName() + ".png", getTestMethodName());
		} catch (Exception e) {
			log.error("Error in Screenshot Copy Utility");
			e.printStackTrace();
		}

		extentTest.get().fail(result.getThrowable());

	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult result) {
		log.debug("The name of the testcase Skipped is : " + result.getName());
	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult result) {
		log.info("The name of test case started is : " + result.getName());
		Object[] params = result.getParameters();
		if (params.length > 0)
			setTestMethodName(result.getMethod().getMethodName() + params[0]);
		else
			setTestMethodName(result.getMethod().getMethodName());
		log.debug("Test Method name is : " + getTestMethodName());
		test = extent.createTest(getTestMethodName());
		extentTest.set(test);
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("The name of the testcase passed is : " + result.getName());
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.debug("The name of the testcase failed but in success ratio : " + result.getName());

	}

	@Override
	public void onFinish(ITestContext result) {
		log.info("I am onFinish Method  : " + result.getName());
		extent.flush();
	}

	@Override
	public void onStart(ITestContext result) {
		log.info("I am onStart Method  : " + result.getName());
	}
}
