package com.crm.Sdet.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
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

public class CreateProduct {
	/*This is used to create product
	 * @author AmarKumar
	 */
	public static void main(String[] args) throws Throwable {
// SCENARIO 2: CREATE NEW PRODUCT 
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
//PRODUCT IS CREATED 
					String ActualProductname = driver.findElement(By.className("lvtHeaderText")).getText();
					if(ActualProductname.contains(productname)) {
						System.out.println("THE PRODUCT IS MATCHED");
						
					}else {
						System.out.println("OOHO! not matched");
					}
				
		}
	}
	

