package com.rishabh.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rishabh.framework.BaseTest;
import com.rishabh.framework.pages.HomePage;
import com.rishabh.framework.pages.MacPage;
import com.rishabh.framework.utils.DriverUtils;

public class ApplePageTest extends BaseTest {

	private static Logger log = LogManager.getLogger(ApplePageTest.class.getName());

	/**
	 * Test cases from Apple Home Page
	 */

	@Test(priority = 1)
	public void validateMacPageTitle() {
		HomePage.macClick();
		log.debug("Mac Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Mac - Apple", DriverUtils.initializeDriver().getTitle());
		log.info("validateMacPageTitle() TC gets completed");

	}

	@Test(priority = 2)
	public void clickApple() {
		MacPage.clickApple();
		log.debug("Apple Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Apple", DriverUtils.initializeDriver().getTitle());
		log.info("clickApple() TC gets completed");
	}

	@Test(priority = 3)
	public void validateiPhonePageTitle() {
		HomePage.iPhoneClick();
		log.debug("iPhone Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("iPhone - Apple", DriverUtils.initializeDriver().getTitle());
		log.info("validateiPhonePageTitle() TC gets completed");
	}

}
