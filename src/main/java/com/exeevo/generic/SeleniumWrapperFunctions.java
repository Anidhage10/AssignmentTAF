package com.exeevo.generic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapperFunctions {
	


	public SeleniumWrapperFunctions() {
	}

	
	/**
	 * clickUsingJavascript - method is used for clicking the webelement using javaScripts
	 * @param locator
	 * @return
	 */
	public boolean clickUsingJavascript(By locator) {
		try {
			// need to handle synchronization using explicit wiat/implicit wait/fluent wiat
			waitForElementVisibility(locator);
			WebElement webElement = Pojo.getDriver().findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) Pojo.getDriver();
			js.executeScript("return arguments[0].click()", webElement);

			return true;
		} catch (Exception e) {
			System.out.println("I got Exception - ::" + e.getMessage());
			return false;
		}
	}

	/**
	 * click - method is used for clicking the web element using selenium
	 * @param locator
	 * @return
	 */
	public boolean click(By locator) {
		try {
			// need to handle synchronization using explicit wiat/implicit wait/fluent wiat
			waitForElementVisibility(locator);
			WebElement webElement = Pojo.getDriver().findElement(locator);	
			webElement.click();
			return true;
		} catch (Exception e) {
			System.out.println("I got Exception - ::" + e.getMessage());
			return false;
		}
	}

	/**
	 * setText - method is used to set the text value in input fields
	 * @param locator
	 * @param inputValue
	 * @return
	 */
	public boolean setText(By locator, String inputValue) {
		try {
			// need to handle synchronization using explicit wiat/implicit wait/fluent wiat
			waitForElementVisibility(locator);
			WebElement webElement = Pojo.getDriver().findElement(locator);
			webElement.clear();
			webElement.sendKeys(inputValue);
			return true;
		} catch (Exception e) {
			System.out.println("I got Exception - ::" + e.getMessage());
			return false;
		}
	}

	/**
	 * checkElementIsDisplayed - method is used for to verify the element is displayed or not
	 * @param locator
	 * @return
	 */
	public boolean checkElementIsDisplayed(By locator) {

		try {
			waitForElementVisibility(locator);
			WebElement element = Pojo.getDriver().findElement(locator);
			return element.isDisplayed();
		} catch (Exception exception) {
			exception.getStackTrace();
			return false;
		}
	}


	/**
	 * scrollToViewElement - method is used for to scroll the page as per the web element position on page
	 * @param locator
	 * @return
	 */
	public boolean scrollToViewElement(By locator) {

		try {
			WebElement webElement = Pojo.getDriver().findElement(locator);
			Actions action = new Actions(Pojo.getDriver());
			action.scrollToElement(webElement).perform();
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	/**
	 *  Customized get web element
	 * @param locator
	 * @return
	 */
	public WebElement getWebElement(By locator) {

		try {
			// need to handle wait mechanism
			return Pojo.getDriver().findElement(locator);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	
	/**
	 * isElementSelected - method is used for the checking element is selected or not.
	 * @param locator
	 * @return
	 */
	public boolean isElementSelected(By locator) {

		try {
			WebElement webElement = Pojo.getDriver().findElement(locator);
			return webElement.isSelected();
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * waitForElementVisibility - Checking visibility of the Element
	 * @param locator
	 * @throws NotFoundException
	 */
	public void waitForElementVisibility(By locator) throws NotFoundException {

		WebDriverWait wait = new WebDriverWait(Pojo.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * openNewWindowAndOpenURL - method is used for to open the new tab and URL in browser using JavaScript executor and getWindowhandles
	 * @param strURL
	 */
	public void openNewWindowAndOpenURL(String strURL) {
        try {
        	((JavascriptExecutor) Pojo.getDriver()).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<>(Pojo.getDriver().getWindowHandles());
            Pojo.getDriver().switchTo().window(tabs.get(1));
            Pojo.getDriver().get(strURL);
            System.out.println("Open URL :: "+strURL);
			
		} catch (Exception exception) {
			System.out.println("I got exception while opening the URL :: "+exception.getMessage());
		}
	}
	
	
	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			System.out.println("I got Exception: "+exception.getMessage());
			return false;
		}
	}
	
	
	
	
	
	
	
	
}
