package com.rishabh.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rishabh.framework.constants.Constants;
import com.rishabh.framework.utils.ConfigReader;

public class ExtentReportUtils {

	static ExtentReports extent;

	/**
	 * Create the Report Template
	 */
	public static ExtentReports getReportObject() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.REPORTPATH);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Assignee", "Rishabh Jaiswal");
		extent.setSystemInfo("OS Version", OsUtils.getOsName());
		return extent;

	}
}
