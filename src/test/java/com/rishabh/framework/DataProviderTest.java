package com.rishabh.framework;

import java.io.File;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rishabh.framework.constants.Constants;
import com.rishabh.framework.utils.ConfigReader;
import com.rishabh.framework.utils.ExcelUtils;

public class DataProviderTest {

	private static Logger log = LogManager.getLogger(DataProviderTest.class.getName());

	/**
	 * Test cases from Apple Home Page
	 */
	@Test(dataProvider = "TestData")
	public void runTestData(String FirstName, String LastName, String Gender) {
		log.debug("Data : " + FirstName + " " + LastName + " " + Gender);
		log.info("runTestData() TC gets completed");
	}

	@DataProvider(name = "TestData")
	public Object[][] getData() throws URISyntaxException {

		String excel_path = Constants.EXCELPATH + File.separator + ConfigReader.getConfigData().get("test_excel_name");
		log.info(excel_path);
		return ExcelUtils.getTestData(excel_path);

	}

}
