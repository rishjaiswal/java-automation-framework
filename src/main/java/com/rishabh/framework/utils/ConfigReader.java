package com.rishabh.framework.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.rishabh.framework.constants.Constants;

public class ConfigReader {

	public static Map<String, String> configData = new HashMap<>();

	/**
	 * To read the properties from config file and load as key-value in HashMap
	 */
	public static void configReader() {

		Properties property = new Properties();
		try (FileInputStream file = new FileInputStream(Constants.CONFIGFILEPATH)) {
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				configData.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	/**
	 * To use a singleton instance and return it same HashMap
	 */
	public HashMap<String, String> getConfigData() {
		return (HashMap<String, String>) configData;
	}

}
