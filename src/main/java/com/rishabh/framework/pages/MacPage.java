package com.rishabh.framework.pages;

import com.rishabh.framework.utils.SeleniumUtils;

public class MacPage {

	// TO-DO : To use in future Nested Array and use the type accordingly
	static String elementType = "xpath";

	static String apple = "//a[@id='ac-gn-firstfocus']";

	public static void clickApple() {
		SeleniumUtils.click(SeleniumUtils.getElement(elementType, apple));
	}
}
