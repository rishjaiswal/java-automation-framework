package com.rishabh.framework.utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rishabh.framework.constants.Constants;
import com.rishabh.framework.utils.DriverUtils;

public class SeleniumUtils {

	/**
	 * To get the By object from the below params:
	 * 
	 * @type : Locator Type
	 * @path : Locator Index
	 */
	public static By getElementBy(String type, String path) {
		By by = null;
		if (type.equalsIgnoreCase("class")) {
			by = new By.ByClassName(path);
		} else if (type.equalsIgnoreCase("css")) {
			by = new By.ByCssSelector(path);
		} else if (type.equalsIgnoreCase("id")) {
			by = new By.ById(path);
		} else if (type.equalsIgnoreCase("link")) {
			by = new By.ByLinkText(path);
		} else if (type.equalsIgnoreCase("name")) {
			by = new By.ByName(path);
		} else if (type.equalsIgnoreCase("partial_link")) {
			by = new By.ByPartialLinkText(path);
		} else if (type.equalsIgnoreCase("tag")) {
			by = new By.ByTagName(path);
		} else if (type.equalsIgnoreCase("xpath")) {
			by = new By.ByXPath(path);
		} else {
			System.out.println("Invalid Selector Type");
		}
		return by;
	}

	/**
	 * To get the WebElement from the below params :
	 * 
	 * @type : Locator Type
	 * @path : Locator Index
	 */
	public static WebElement getElement(String type, String path) {
		By by = getElementBy(type, path);
		if (by != null)
			return DriverUtils.initializeDriver().findElement(by);
		return null;
	}

	/**
	 * To get the list of WebElements from the below params :
	 * 
	 * @type : Locator Type
	 * @path : Locator Index
	 */
	public static List<WebElement> getElements(String type, String path) {
		By by = getElementBy(type, path);
		if (by != null)
			return DriverUtils.initializeDriver().findElements(by);
		return null;
	}

	/**
	 * To click on the webelement
	 * 
	 * @element : WebElement
	 */
	public static void click(WebElement element) {
		element.click();
	}

	/**
	 * To enter the text to WebElement
	 * 
	 * @element : WebElement
	 * @text : Text to enter in WebElement
	 */
	public static void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * To click on the webelement using JavaScript Executor
	 * 
	 * @element : WebElement
	 */
	public static void jsClck(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.initializeDriver();
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * To check webelement is visible or not
	 * 
	 * @element : WebElement
	 * @return : True if its visible else false
	 */
	public static boolean isVisible(WebElement element) {
		boolean flag = false;
		DriverUtils.initializeDriver().manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
		try {
			if (element.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Dynamic Wait for the Element on the visibility
	 * 
	 * @element : WebElement
	 */
	public static WebElement waitUntilElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverUtils.initializeDriver(), Constants.EXPLICITWAIT);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Switch to new Window
	 */
	public static void switchToNewWindow() {
		String parentWinHandle = DriverUtils.initializeDriver().getWindowHandle();
		Set<String> winHandles = DriverUtils.initializeDriver().getWindowHandles();
		for (String temp : winHandles) {
			if (!temp.equalsIgnoreCase(parentWinHandle)) {
				DriverUtils.initializeDriver().switchTo().window(temp);
			}
		}
	}

	/**
	 * To identify an select the option on basis of below params
	 * 
	 * @element : WebElement
	 * @text : Text
	 */
	public static void selectByValue(WebElement element, String text) {
		new Select(element).selectByValue(text);
	}

	/**
	 * To identify an select the option on basis of below params
	 * 
	 * @element : WebElement
	 * @text : Text
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * To identify an select the option on basis of below params
	 * 
	 * @element : WebElement
	 * @text : Text
	 */
	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

}