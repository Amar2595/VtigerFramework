package com.crm.Sdet.organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.PropertyFile;
import com.cast.vtiger.genericUtility.WebDriver_utility;
import com.cast.vtiger.objectRepository.HomePage;
import com.cast.vtiger.objectRepository.LoginPage;
import com.cast.vtiger.objectRepository.OrganisationPage;

public class CreateOrganisationByGeneric {
@Test
	public  void CreateOrganisation() throws Throwable {
		// TODO Auto-generated method stub
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
					home.ClickOrganisation();
//Create Organisation by Repository
					OrganisationPage organisation = new OrganisationPage(driver);
					organisation.orgPlusButton();
//JAVA UTILITY USED		
					Java_utility ju = new Java_utility();
					int random = ju.getRandomNum();
//EXCEL FILE UTILITY 
					Excel_utility eu = new Excel_utility();
					String ORGANISATION = eu.GetDatafromExcel("ORGANISATION", 0, 0);
					 String orgname = ORGANISATION+random;
					 organisation.AddOrganisationName(orgname);
				     organisation.ClickOnSaveButton();
                     
				    String Actualorganisationname = driver.findElement(By.className("dvHeaderText")).getText();
					if(Actualorganisationname.contains(orgname)) {
					System.out.println("THE ORG IS CREATED THAT IS: "+orgname);
					}else {
							System.out.println("OOHO! not matched");
						}
						//home.ClickAdministration();
					//	home.ClickSignOut();
					//	driver.quit();
	}
	}


