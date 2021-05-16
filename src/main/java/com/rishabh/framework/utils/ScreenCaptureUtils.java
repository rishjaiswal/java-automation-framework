package com.rishabh.framework.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCaptureUtils {

	/**
	 * Captures screenshot of the current page and return to the caller.
	 * 
	 * @webdriver : WebDriver
	 * @return Image
	 */

	public static File takeSnapShot(WebDriver webdriver) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		return SrcFile;
	}

}