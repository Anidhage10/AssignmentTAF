package com.exeevo.scripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.exeevo.generic.BaseTest;
import com.exeevo.generic.Pojo;
import com.exeevo.pageFactory.AmazonSearchResultPage;
import com.exeevo.pageFactory.FlipkartHomePage;

public class PriceCheckTest extends BaseTest {

	private FlipkartHomePage objFlipkartHomePage;
	private AmazonSearchResultPage objAmazonSearchResultPage;

	public void initPagesAndFlows() {
		objFlipkartHomePage = new FlipkartHomePage();
		objAmazonSearchResultPage = new AmazonSearchResultPage();
	}

	@BeforeClass
	public void setupEnv() {
		this.initializeWebEnv("flipkart");
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
	 * Note- In actual project and framework we have to remove SYSO messages and
	 * implement logger functionality for the demonstration purpose not removing the
	 * SYSO messages In this assignment, we are using test data directly in the Test
	 * Class. However, in an actual framework or project, test data is separated
	 * from the actual business logic and test scripts. In our project, we use an
	 * external test data Excel sheet.
	 */

	@Test(priority = 1)
	public void TCID_101_verifyTabletFilterFunctionality() {
		// URL comes from the property files
		String strURL = "https://www.amazon.in";
		objFlipkartHomePage.verifyHomePageIsDisplayed();
		objFlipkartHomePage.setTextOnSearchTxtField("iphone 15 promax");
		objFlipkartHomePage.clickOnSerachIconButton();
		String strProductNameAndPrice = objFlipkartHomePage.getAndSelectiPhone();
		System.out.println("strProductNameAndPrice :: " + strProductNameAndPrice);
		String striPhoneNameAndPrice[] = strProductNameAndPrice.split("@");
		Pojo.getObjSeleniumWrapperFunctions().waitFor(10);
		Pojo.getObjSeleniumWrapperFunctions().openNewWindowAndOpenURL(strURL);
		objAmazonSearchResultPage.verifyAmazonURLOpened();
		objAmazonSearchResultPage.setTextOnSearchTxtField(striPhoneNameAndPrice[0]);
		objAmazonSearchResultPage.clickOnSerachIconButton();
		String striPhoneFlipkartPrice = striPhoneNameAndPrice[1];
		String striPhoneAmazonPrice = objAmazonSearchResultPage.getAndSelectiPhone("iPhone 15 Pro Max");
		Assert.assertTrue(striPhoneFlipkartPrice.equals(striPhoneAmazonPrice));

	}

}
