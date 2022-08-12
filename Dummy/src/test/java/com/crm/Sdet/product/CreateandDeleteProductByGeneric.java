package com.crm.Sdet.product;

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
import com.cast.vtiger.objectRepository.ProductPage;

public class CreateandDeleteProductByGeneric {
@Test
	public  void CreateAndDeleteProduct() throws Throwable {
		// Create And Delete The Product
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
							String ActualProductname = driver.findElement(By.className("lvtHeaderText")).getText();
							if(ActualProductname.contains(productname)) {
								System.out.println("THE PRODUCT IS MATCHED");
								
							}else {
								System.out.println("OOHO! not matched");
							}
//Know We Delete The Product
							product.DeleteProduct();
							wlib.switchToAlertAndAccept(driver);
							home.ClickAdministration();
							home.ClickSignOut();
							driver.quit();
	}
}
