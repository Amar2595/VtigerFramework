package com.crm.Sdet.organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.cast.vtiger.genericUtility.BaseClass;
import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.objectRepository.HomePage;
import com.cast.vtiger.objectRepository.OrganisationPage;
import com.cast.vtiger.objectRepository.OrganisationValidation;
@Listeners(com.cast.vtiger.genericUtility.Listner.class)
public class CreateOrganisationByGenericTest extends BaseClass{
@Test(groups = {"smokeTest"}, priority=1)
	public  void CreateOrganisation() throws Throwable {
	 //Launch Browser And LoginPage Call From BaseClass
// Homepage by Object Repository---> Product	
					HomePage home = new HomePage(driver);
					home.ClickOrganisation();
//Create Organisations by Repository
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
					 //Assert.assertEquals(true, false);
				     organisation.ClickOnSaveButton();
				     OrganisationValidation ActualData = new OrganisationValidation(driver);
						 String ActualOrganisationData = ActualData.actualOrganisationName();
					   	Assert.assertEquals(ActualOrganisationData.contains(orgname), true);
				     
						home.ClickAdministration();
						home.ClickSignOut();
						driver.quit();
	}
	}


