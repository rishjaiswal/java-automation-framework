package com.rishabh.framework.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rishabh.framework.utils.ConfigReader;
import com.rishabh.framework.constants.Constants;
import org.openqa.selenium.safari.SafariDriver;
import com.rishabh.framework.utils.OsUtils;

public class DriverUtils {

	private static WebDriver driver;

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverUtils() {
	};

	/**
	 * Initialize the browser
	 */
	public static WebDriver initializeDriver() {
		if (driver == null) {

			if (ConfigReader.getConfigData().get("browser").equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			} else if (ConfigReader.getConfigData().get("browser").equalsIgnoreCase("chrome")) {
				String CHROMEDRIVERPATH;
				if (OsUtils.isMac())
					CHROMEDRIVERPATH = Constants.DRIVERPATH + File.separator + "chromedriver";
				else
					CHROMEDRIVERPATH = Constants.DRIVERPATH + File.separator + "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("-disabled-backgrounding-occluded-windows");
				driver = new ChromeDriver(options);
			} else {
				String GECKODRIVERPATH;
				if (OsUtils.isMac())
					GECKODRIVERPATH = Constants.DRIVERPATH + File.separator + "geckodriver";
				else
					GECKODRIVERPATH = Constants.DRIVERPATH + File.separator + "geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", GECKODRIVERPATH);
				driver = new FirefoxDriver();
			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		return driver;

	}

	/**
	 * Closes the browser and quit it.
	 */
	public static void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

}