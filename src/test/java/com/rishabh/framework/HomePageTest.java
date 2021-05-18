package com.rishabh.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rishabh.framework.BaseTest;
import com.rishabh.framework.utils.DriverUtils;

public class HomePageTest extends BaseTest {

	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	/**
	 * Test cases from Apple Home Page
	 */
	@Test
	public void getHomePageTitle() {
		log.debug("Apple Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Apple", DriverUtils.initializeDriver().getTitle());
		log.info("getHomePageTitle() TC gets completed");
	}

	@Test
	public void getFullHomePageTitle() {
		log.debug("Apple Full Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Appl", DriverUtils.initializeDriver().getTitle());
		log.info("getFullHomePageTitle() TC gets sucessfully completed");

	}

}
