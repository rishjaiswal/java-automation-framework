package com.rishabh.framework.constants;

import java.io.File;

public class Constants {

	public static final String PROJECTPATH = System.getProperty("user.dir");
	public static final String RESOURCESPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources";
	public static final String CONFIGFILEPATH = RESOURCESPATH + File.separator + "config" + File.separator
			+ "config.properties";
	public static final String SCREENSHOTFILEPATH = RESOURCESPATH + File.separator + "screenshots" + File.separator;
	public static String EXCELPATH = RESOURCESPATH + File.separator + "testdata";
	public static String DRIVERPATH = RESOURCESPATH + File.separator + "driver";
	public static final String REPORTPATH = System.getProperty("user.dir") + File.separator + "reports" + File.separator
			+ "index.html";

	public static final int EXPLICITWAIT = 70;
	public static final int IMPLICITWAIT = 20;

}