package com.rishabh.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import com.rishabh.framework.utils.ConfigReader;
import org.testng.annotations.BeforeSuite;
import com.rishabh.framework.utils.DriverUtils;

public class BaseTest {

	private static Logger log = LogManager.getLogger(BaseTest.class.getName());

	/*
	 * To Set-up the Pre-conditions for the Test
	 */
	@BeforeSuite
	public void setUp() {
		ConfigReader.configReader();
		DriverUtils.initializeDriver().get(ConfigReader.configData.get("url"));
		log.info("Home Page Title is " + DriverUtils.initializeDriver().getTitle());
	}

	/*
	 * To Tear-down the Test activity
	 */
	@AfterSuite
	public void cleanUp() {
		DriverUtils.quit();
		log.info("Closing the Home Page");
	}

}
