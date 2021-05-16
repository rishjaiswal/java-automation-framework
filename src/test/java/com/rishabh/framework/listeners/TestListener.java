package com.rishabh.framework.listeners;

import java.io.File;

import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rishabh.framework.utils.DriverUtils;
import com.rishabh.framework.utils.ScreenCaptureUtils;
import com.rishabh.framework.constants.Constants;

public class TestListener implements ITestListener {

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is : " + result.getName());

		// Move image file to new destination
		File DestFile = new File(Constants.SCREENSHOTFILEPATH + File.separator + result.getName() + ".png");

		// Copy file at destination
		try {
			FileHandler.copy(ScreenCaptureUtils.takeSnapShot(DriverUtils.initializeDriver()), DestFile);
			System.out.println("Sucessfully copy the screenshot in directory : "+ Constants.SCREENSHOTFILEPATH);
		} catch (Exception e) {
			System.out.println("Error in Screenshot Copy Utility");
			e.printStackTrace();
		}
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is : " + result.getName());
	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case started");
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The name of the testcase failed but in success ratio : " + result.getName());

	}

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("I am onFinish Method  : " + result.getName());
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("I am onStart Method  : " + result.getName());
	}
}
