package com.exeevo.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {
	
	/**
	 * Pojo is our centralized class using Pojo class we can access the all centralized objects and properties
	 */

	private static WebDriver driver;
	private static SeleniumWrapperFunctions objSeleniumWrapperFunctions;
	private static Utilities objUtilities;
	private static ExcelDataProvider objExcelDataProvider;
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Pojo.driver = driver;
	}
	public static SeleniumWrapperFunctions getObjSeleniumWrapperFunctions() {
		return objSeleniumWrapperFunctions;
	}
	public static void setObjSeleniumWrapperFunctions(SeleniumWrapperFunctions objSeleniumWrapperFunctions) {
		Pojo.objSeleniumWrapperFunctions = objSeleniumWrapperFunctions;
	}
	public static Utilities getObjUtilities() {
		return objUtilities;
	}
	public static void setObjUtilities(Utilities objUtilities) {
		Pojo.objUtilities = objUtilities;
	}
	public static ExcelDataProvider getObjExcelDataProvider() {
		return objExcelDataProvider;
	}
	public static void setObjExcelDataProvider(ExcelDataProvider objExcelDataProvider) {
		Pojo.objExcelDataProvider = objExcelDataProvider;
	}
	
}
