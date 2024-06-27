package com.exeevo.generic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	WebDriver driver = webDriver.get();
	private SeleniumWrapperFunctions objSeleniumWrapperFunctions;
	private Utilities objUtilities;
	private ExcelDataProvider objExcelDataProvider;
	private Properties objConfig;
	private FileInputStream fis;
	
	
	
	/**
	 * initializeWebEnv - method is used for to initialize the web environment and setup the framework centralized objects.
	 * @param appType
	 */
	public void initializeWebEnv(String appType, String browser) {
		this.loadPropertiesFiles();
//		String strBrowser = objConfig.getProperty("browser"); // config file

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		if (appType.equalsIgnoreCase("flipkart"))
			driver.get(objConfig.getProperty("base_URL_Flipkart"));
		if (appType.equalsIgnoreCase("amazon"))
			driver.get(objConfig.getProperty("base_URL_Amazon"));
		if(appType.equalsIgnoreCase("tMobile"))
			driver.get(objConfig.getProperty("base_URL_TMobile"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Pojo.setDriver(driver);
		objSeleniumWrapperFunctions = new SeleniumWrapperFunctions();
		Pojo.setObjSeleniumWrapperFunctions(objSeleniumWrapperFunctions);
		objUtilities = new Utilities();
		Pojo.setObjUtilities(objUtilities);
		objExcelDataProvider = new ExcelDataProvider();
		Pojo.setObjExcelDataProvider(objExcelDataProvider);

	}

	/**
	 * Closing browser
	 */
	public void tearDownWebEnv() {
		try {
			driver.quit();
		} catch (Exception exception) {
			System.out.println("I got exception while closing the browser");
		}
	}

	/**
	 * loadPropertiesFiles - method is used for to load the property files
	 */
	public void loadPropertiesFiles() {
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configFiles/config.properties");
			objConfig = new Properties();
			objConfig.load(fis);

		} catch (Exception exception) {
			System.out.println("I got exception while loading the properties :: " + exception.getMessage());
		}
	}

}
