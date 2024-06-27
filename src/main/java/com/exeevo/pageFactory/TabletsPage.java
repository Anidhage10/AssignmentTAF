package com.exeevo.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.exeevo.generic.Pojo;

public class TabletsPage {

	By loc_txt_tablets = By.xpath("//h1[@x-data='productCategories'][contains(.,'Shop')]//span[text()='Tablets']");
	By loc_btn_clearAll = By.xpath("//button[text()='Clear all']");

	/**
	 * We are using assertions at each step with the logger. In the actual project, as per standards, 
	 * all System.out messages will be removed and replaced with logger statements.
	 * Currently, we are using System.out messages for display purposes only.
	 */
	public void verifyTabletsPageIsDisplayed() {

		Assert.assertTrue(Pojo.getObjSeleniumWrapperFunctions().checkElementIsDisplayed(loc_txt_tablets));
		System.out.println("verified 'shop tablets' header name is displyed on tablet page");
	}

	public void clickOnClearAll() {

		Assert.assertTrue(Pojo.getObjSeleniumWrapperFunctions().clickUsingJavascript(loc_btn_clearAll));
		System.out.println("clicked on clear all button");
	}

	/**
	 * applyFilter - is reusable method to use for the filter as per requirement it is used in flow business logic layer 
	 * @param filter
	 * @param option
	 */
	public void applyFilter(String filter, String option) {
		By loc_filterOptions = By.xpath(
				"//legend[contains(.,'" + filter + "')]//input[contains(@name,'" + option + "')][@type='checkbox']");
		if (!Pojo.getObjSeleniumWrapperFunctions().isElementSelected(loc_filterOptions)) {
			Assert.assertTrue(Pojo.getObjSeleniumWrapperFunctions().clickUsingJavascript(loc_filterOptions));
			System.out.println(option + ": Option is selected.");
		}
	}
}
