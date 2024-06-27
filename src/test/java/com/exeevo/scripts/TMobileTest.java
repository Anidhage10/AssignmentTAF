package com.exeevo.scripts;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.exeevo.flows.TabletsFlow;
import com.exeevo.generic.BaseTest;
import com.exeevo.generic.Pojo;
import com.exeevo.pageFactory.TabletsPage;

public class TMobileTest extends BaseTest {

	private TabletsFlow objTabletsFlow;
	private TabletsPage objTabletsPage;

	public void initPagesAndFlows() {
		objTabletsFlow = new TabletsFlow();
		objTabletsPage = new TabletsPage();
	}

	@BeforeClass
	@Parameters("browser")
	public void setupEnv(String browser) {
		this.initializeWebEnv("tMobile", browser);
		this.initPagesAndFlows();
	}

	@AfterClass
	public void tearDownEnv() {
		this.tearDownWebEnv();
	}

	@BeforeMethod
	public void preCondition() {

	}

	@AfterMethod
	public void postCondition() {

	}

	
	/**
	 * In this assignment, we are using test data directly in the Test Class. However, in an actual framework or project, 
	 * test data is separated from the actual business logic and test scripts.
	 * In our project, we use an external test data Excel sheet.
	 */
	
	@Test(priority = 1)
	public void TCID_101_verifyTabletFilterFunctionality() {

		objTabletsPage.verifyTabletsPageIsDisplayed();
		objTabletsFlow.selectFilter("Brands", "Apple", "Samsung", "TCL");
		objTabletsFlow.selectFilter("Brands", "TCL");
		objTabletsFlow.selectFilter("Deals", "New", "Special offer");
		objTabletsFlow.selectFilter("Operating system", "iPadOS", "Android");
		objTabletsFlow.selectFilter("Brands", "all");
		
//		Actions action = new Actions(Pojo.getDriver());
//		action.contextClick().build().perform();
		
		
	}
}
