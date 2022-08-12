package com.crm.Sdet.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.PropertyFile;
import com.cast.vtiger.genericUtility.WebDriver_utility;
import com.mysql.jdbc.Driver;

public class CampaignToProducts {
/*This is used to add product in campaign
 * @author AmarKumar
 */
	public static void main(String[] args) throws Throwable {
		// SCENARIO 4: GO TO CRAETE PRODUCT AND GOTO CAMPAIGN ADD THAT PRODUCTT
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//LOGIN PAGE AND PROPERTY FILE UTILITY USE 
		    PropertyFile pf = new PropertyFile();
		    String browser = pf.getpropertykeyvalue("url");
		    String username = pf.getpropertykeyvalue("un");
		    String password = pf.getpropertykeyvalue("pwd");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(browser);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
//EXCEL FILE UTILITY 
			Excel_utility eu = new Excel_utility();
			String campaign = eu.GetDatafromExcel("campaign", 0, 0);
			String pc = eu.GetDatafromExcel("PRODUCT", 0, 0);
//WebDriver_utility call
			WebDriver_utility wlib =  new WebDriver_utility();
			wlib.waitforpageToload(driver);
			driver.manage().window().maximize();
//HOMEPAGE--->PRODUCT
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//JAVA UTILITY USED		
			Java_utility ju = new Java_utility();
			int random = ju.getRandomNum();
			 String productname = pc+random;	
			driver.findElement(By.name("productname")).sendKeys(productname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//HOMEPAGE--->MORE--->CAMPAIGN
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			    
//CREATE CAMPAIGN
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			    String campaignname = campaign+random;
		    driver.findElement(By.name("campaignname")).sendKeys(campaignname);
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
//SWITCH WINDOW HANDLE---->CHILD WINDOW ID BY HELP OF WEBUTILITY
			wlib.switchWindowHandle(driver, "Products&action");
			driver.findElement(By.name("search_text")).sendKeys(productname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
//AGAIN COME BACK TO CAMPAIGNPAGE WITH SWITCH WINDOW ID
				wlib.switchWindowHandle(driver, "Campaigns&action");
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
//CAMPAIGN TO PRODUCT IS CREATED 
				if(actData.contains(campaign)) {
					System.out.println("pass"+productname+"this product is added in campaign");
				}else {
					System.out.println("fail");
				}
			}		
	         //logout action needed.
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
			}
