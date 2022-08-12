package com.crm.Sdet.product;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cast.vtiger.genericUtility.BaseClass;
import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.WebDriver_utility;
import com.cast.vtiger.objectRepository.HomePage;
import com.cast.vtiger.objectRepository.ProductPage;
import com.cast.vtiger.objectRepository.ProductValidation;

public class CreateandDeleteProductByGenericTest extends BaseClass {
@Test(groups = {"smokeTest"}, priority=1)
	public  void CreateAndDeleteProduct() throws Throwable {
// Create And Delete The Product
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
					ProductValidation ActualData = new ProductValidation(driver);
					String ActualProductData = ActualData.actualProductName();
					Assert.assertEquals(ActualProductData.contains(productname), true);
//Know We Delete The Product
							product.DeleteProduct();
							WebDriver_utility wlib =  new WebDriver_utility();
							wlib.switchToAlertAndAccept(driver);
							home.ClickAdministration();
							home.ClickSignOut();
							driver.quit();
	}
}
