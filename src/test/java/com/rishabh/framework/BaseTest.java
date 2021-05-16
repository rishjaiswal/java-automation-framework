package com.rishabh.framework;

import org.testng.annotations.AfterSuite;
import com.rishabh.framework.utils.ConfigReader;
import org.testng.annotations.BeforeSuite;
import com.rishabh.framework.utils.DriverUtils;

public class BaseTest {

	/*
	 * To Set-up the Pre-conditions for the Test
	 */
	@BeforeSuite
	public void setUp() {
		ConfigReader.configReader();
		DriverUtils.initializeDriver().get(ConfigReader.configData.get("url"));
		System.out.println("Home Page Title is " + DriverUtils.initializeDriver().getTitle());
	}

	/*
	 * To Tear-down the Test activity
	 */
	@AfterSuite
	public void cleanUp() {
		DriverUtils.quit();
		System.out.println("Closing the Home Page");
	}

}
