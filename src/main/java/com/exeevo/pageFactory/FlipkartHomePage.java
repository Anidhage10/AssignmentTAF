package com.exeevo.pageFactory;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.exeevo.generic.Pojo;

public class FlipkartHomePage {

	By loc_Logo = By.xpath("//img[@title='Flipkart']");
	By loc_search = By.xpath("//input[contains(@placeholder,'Search for')]");
	By loc_btn_close = By.xpath("//span[@role='button']");
	By loc_LoginPopUp = By.xpath("//p[text()='Get access to your Orders, Wishlist and Recommendations']");
	By loc_btn_icon_search = By.xpath("//button[@type='submit']");
	By loc_txt_iphoneDetails = By.xpath(
			"//img[contains(@alt,'Apple iPhone 15 Pro Max')]/parent::div/following::div[contains(.,'Apple iPhone 15 Pro Max')]");

	
	// need to add regular expression in external files
	String regexIphoneName = "Apple iPhone \\d{1,2} (?:Pro Max|Pro|Plus|Mini|SE|\\d{1,2}) \\(.*?\\)";
	String regexPrice = "₹[\\d,]+";

	public void verifyHomePageIsDisplayed() {

		assertTrue(Pojo.getObjSeleniumWrapperFunctions().checkElementIsDisplayed(loc_Logo));

	}

	public void clickOnCloseButton() {
		if (Pojo.getObjSeleniumWrapperFunctions().checkElementIsDisplayed(loc_LoginPopUp))
			assertTrue(Pojo.getObjSeleniumWrapperFunctions().click(loc_btn_close));
	}

	public void setTextOnSearchTxtField(String product) {
		assertTrue(Pojo.getObjSeleniumWrapperFunctions().setText(loc_search, product));
	}

	public void clickOnSerachIconButton() {
		assertTrue(Pojo.getObjSeleniumWrapperFunctions().click(loc_btn_icon_search));
	}

	public String getAndSelectiPhone() {

		List<WebElement> listOfProduct = Pojo.getDriver().findElements(loc_txt_iphoneDetails);
		String striPhoneDetails = "";

		for (WebElement webElement : listOfProduct) {
			striPhoneDetails = webElement.getText();
			if (!striPhoneDetails.equals("") && !striPhoneDetails.isEmpty()) {
				break;
			}
			System.out.println("iPhoneDetails :: " + striPhoneDetails);

		}
		String strProductName = Pojo.getObjUtilities().getDataUsingRegex(regexIphoneName, striPhoneDetails);
		// System.out.println("Product Name :: "+strProductName);
		String strProductPrice = Pojo.getObjUtilities().getDataUsingRegex(regexPrice, striPhoneDetails);
		// System.out.println("strProductPrice :: "+strProductPrice);
		return strProductName + "@" + strProductPrice;
	}

}
