package com.rishabh.framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.rishabh.framework.BaseTest;
import com.rishabh.framework.utils.DriverUtils;

public class HomePageTest extends BaseTest {
	/**
	 * Test cases from Apple Home Page
	 */
	@Test
	public void getHomePageTitle() {
		System.out.println("Apple Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Apple", DriverUtils.initializeDriver().getTitle());
	}
	@Test
	public void getFullHomePageTitle() {
		System.out.println("Apple Home Page Title is :" + DriverUtils.initializeDriver().getTitle());
		Assert.assertEquals("Appl", DriverUtils.initializeDriver().getTitle());
	}

}
