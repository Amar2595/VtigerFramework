package com.crm.Sdet.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cast.vtiger.genericUtility.BaseClass;
import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.objectRepository.CampaignPage;
import com.cast.vtiger.objectRepository.CampaignValidation;
import com.cast.vtiger.objectRepository.HomePage;


public class CreateCampaignByGenericTest extends BaseClass{
@Test(groups = {"smokeTest"})
	public void CreateCampaign() throws Throwable {
		
	    //Launch Browser And LoginPage Call From BaseClass
		// Homepage by Object Repository---> Product	
					HomePage home = new HomePage(driver);
					home.Clickmore();
					home.ClickCampaign();
		//EXCEL FILE UTILITY 
					Excel_utility eu = new Excel_utility();
					String campaignames = eu.GetDatafromExcel("campaign", 0, 0);
					//JAVA UTILITY USED		
					Java_utility ju = new Java_utility();
					int random = ju.getRandomNum();
					  String campaignname = campaignames+random;
		//Campaign Page Should Be Display
					CampaignPage campaign = new CampaignPage(driver);
					campaign.CreateCampaign();
					campaign.AddCampaignName(campaignname);
					campaign.ClickOnSaveButton();
					CampaignValidation ActualData = new CampaignValidation(driver);
					String ActualCampaignData = ActualData.actualCampaignName();
					Assert.assertEquals(ActualCampaignData.contains(campaignname), true);
					home.ClickAdministration();
					home.ClickSignOut();
					driver.quit();
				}		
			}



