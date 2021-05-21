package com.rishabh.framework.pages;

import com.rishabh.framework.utils.SeleniumUtils;

public class HomePage {


	// TO-DO : To use in future Nested Array and use the type accordingly
	static String elementType = "xpath";

	static String mac = "//a[@class='ac-gn-link ac-gn-link-mac']";
	static String iPad = "//a[@class='ac-gn-link ac-gn-link-ipad']";
	static String iPhone = "//a[@class='ac-gn-link ac-gn-link-iphone']";


	public static void macClick() {
		SeleniumUtils.click(SeleniumUtils.getElement(elementType, mac));
	}

	public static void iPadClick() {
		SeleniumUtils.click(SeleniumUtils.getElement(elementType, iPad));
	}

	public static iPhonePage iPhoneClick() {
		SeleniumUtils.click(SeleniumUtils.getElement(elementType, iPhone));
		return new iPhonePage();
	}

}