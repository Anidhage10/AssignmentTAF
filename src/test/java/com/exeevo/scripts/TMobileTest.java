package com.exeevo.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exeevo.flows.TabletsFlow;
import com.exeevo.generic.BaseTest;
import com.exeevo.pageFactory.TabletsPage;

public class TMobileTest extends BaseTest {

	private TabletsFlow objTabletsFlow;
	private TabletsPage objTabletsPage;

	public void initPagesAndFlows() {
		objTabletsFlow = new TabletsFlow();
		objTabletsPage = new TabletsPage();
	}

	@BeforeClass
	public void setupEnv() {
		this.initializeWebEnv("tMobile");
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
	}
}
