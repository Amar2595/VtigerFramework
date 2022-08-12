package com.crm.Sdet.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.PropertyFile;
import com.cast.vtiger.genericUtility.WebDriver_utility;
import com.cast.vtiger.objectRepository.CampaignPage;
import com.cast.vtiger.objectRepository.HomePage;
import com.cast.vtiger.objectRepository.LoginPage;

public class CreateCampaignByGeneric {
@Test
	public void CreateCampaign() throws Throwable {
		
		 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//LOGIN PAGE AND PROPERTY FILE UTILITY USE 
				    PropertyFile pf = new PropertyFile();
				 String Url = pf.getpropertykeyvalue("url");
				    String username = pf.getpropertykeyvalue("un");
				    String password = pf.getpropertykeyvalue("pwd");
					WebDriver driver = new ChromeDriver();
		//WebDriver Utility
					WebDriver_utility wlib =  new WebDriver_utility();
					wlib.waitforpageToload(driver);
					//driver.manage().window().maximize();
					driver.get(Url);
		//Login By Object Repository
					LoginPage login = new LoginPage(driver);
					login.login(username, password);
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
					String ActualCampaignname = driver.findElement(By.className("dvHeaderText")).getText();
					if(ActualCampaignname.contains(campaignname)) {
						System.out.println("THE CAMPAIGN IS MATCHED");
					}else {
						System.out.println("OOHO! not matched");
					}
					home.ClickAdministration();
					home.ClickSignOut();
					driver.quit();
				}

					
			}



