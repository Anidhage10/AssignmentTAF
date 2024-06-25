package com.exeevo.pageFactory;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.exeevo.generic.Pojo;

public class AmazonSearchResultPage {
	
	
	
	By loc_inp_search = By.xpath("//input[@id='twotabsearchtextbox'][@name='field-keywords']");
	By loc_txt_iphoneDetails = By.xpath("//span[text()='Results']/following::div[@class='a-section a-spacing-small a-spacing-top-small']");
	By loc_btn_icon_Search=By.xpath("//input[@id='nav-search-submit-button'][@type='submit']");

	//need to add regular expression in external files
	 String regexIphoneName = "Apple iPhone \\d{1,2} (?:Pro Max|Pro|Plus|Mini|SE|\\d{1,2}) \\(.*?\\)";
	 String regexPrice = "₹[\\d,]+";
	 
	 
	 
	 public void verifyAmazonURLOpened() {
		 if (Pojo.getDriver().getTitle().contains("Amazon")) {
	            assertTrue(true);
	        } else {
	        	assertTrue(false);
	        }
	 }
	 
	 
		public void setTextOnSearchTxtField(String product) {
			assertTrue(Pojo.getObjSeleniumWrapperFunctions().setText(loc_inp_search, product));
		}

		public void clickOnSerachIconButton() {
			assertTrue(Pojo.getObjSeleniumWrapperFunctions().click(loc_btn_icon_Search));
		}
	 
	
	 public String getAndSelectiPhone(String strPName) {
		
		List<WebElement> listOfProduct = Pojo.getDriver().findElements(loc_txt_iphoneDetails);
		String striPhoneDetails="",strProductName="", strProductPrice="";
		
		for (WebElement webElement : listOfProduct) {
			striPhoneDetails = webElement.getText();
			strProductName = Pojo.getObjUtilities().getDataUsingRegex(regexIphoneName, striPhoneDetails);
			strProductPrice = Pojo.getObjUtilities().getDataUsingRegex(regexPrice, striPhoneDetails);
			if(!striPhoneDetails.equals("") && !striPhoneDetails.isEmpty() && strProductName.contains(strPName)) {
				break;
			}
			
		}
		
		return strProductPrice;
	}

}
