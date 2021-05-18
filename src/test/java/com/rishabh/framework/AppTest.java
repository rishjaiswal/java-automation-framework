package com.rishabh.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private static Logger log = LogManager.getLogger(AppTest.class.getName());
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	@Test
	public AppTest(String testName) {
		log.debug("Hello Rishabh Jaiswal!");
		log.info("AppTest Completed");
	}

	@Test
	public void TestMethod() {
		log.debug("Hello Jaiswal!");
		log.info("TestMethod() Completed");
	}

}
