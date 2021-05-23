package com.rishabh.framework.pages;

import com.rishabh.framework.utils.SeleniumUtils;

public class iPhonePage {
	
	// TO-DO : To use in future Nested Array and use the type accordingly
	static String elementType = "xpath";

	static String learnMoreLink = "//a[@aria-label='learn more about trading in your iphone for a newer one']";

	public static void clickLearnMore() {
		SeleniumUtils.click(SeleniumUtils.getElement(elementType, learnMoreLink));
	}

}