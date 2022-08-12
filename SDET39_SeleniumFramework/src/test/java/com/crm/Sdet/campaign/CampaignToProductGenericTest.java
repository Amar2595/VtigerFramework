package com.crm.Sdet.campaign;

import org.testng.annotations.Test;

import com.cast.vtiger.genericUtility.BaseClass;
import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.WebDriver_utility;
import com.cast.vtiger.objectRepository.CampaignPage;
import com.cast.vtiger.objectRepository.CampaignToproductWind;
import com.cast.vtiger.objectRepository.HomePage;
import com.cast.vtiger.objectRepository.ProductPage;

public class CampaignToProductGenericTest extends BaseClass {
@Test(groups = {"regression"})
	public void CreateCampaignToProduct() throws Throwable {
//Launch Browser And LoginPage Call From BaseClass
// Homepage by Object Repository---> Product
					HomePage home = new HomePage(driver);
					home.ClickProduct();
// Product Page Open By POM repository
					ProductPage product = new ProductPage(driver);
					product.createNewProduct();
//Java Utility to generate Random number	
					Java_utility ju = new Java_utility();
					int random = ju.getRandomNum();
//EXCEL FILE UTILITY  to get Productname
    				Excel_utility eu = new Excel_utility();	
					String pc = eu.GetDatafromExcel("PRODUCT", 0, 0);
					String productname = pc+random;	
					product.AddProductName(productname);
					product.SaveProduct();
//PRODUCT IS CREATED 
					home.Clickmore();
					home.ClickCampaign();
					String campaignames = eu.GetDatafromExcel("campaign", 0, 0);
					String campaignname = campaignames+random;
//Campaign Page Should Be Display
					CampaignPage campaign = new CampaignPage(driver);
					campaign.CreateCampaign();
					campaign.AddCampaignName(campaignname);
					CampaignToproductWind childWind = new CampaignToproductWind(driver);
					childWind.AddProduct();
					WebDriver_utility wlib =  new WebDriver_utility();
					wlib.switchWindowHandle(driver, "Products&action");
					childWind.SearchProduct(productname);
					childWind.searchButton(driver, productname);
//AGAIN COME BACK TO CAMPAIGNPAGE WITH SWITCH WINDOW ID
					wlib.switchWindowHandle(driver, "Campaigns&action");
					campaign.ClickOnSaveButton();
					home.ClickAdministration();
					home.ClickSignOut();
					driver.quit();
	}
}