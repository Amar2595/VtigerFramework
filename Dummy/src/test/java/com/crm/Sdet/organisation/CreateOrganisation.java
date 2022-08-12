package com.crm.Sdet.organisation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
import org.openqa.selenium.interactions.Actions;

import com.cast.vtiger.genericUtility.Excel_utility;
import com.cast.vtiger.genericUtility.Java_utility;
import com.cast.vtiger.genericUtility.PropertyFile;
import com.cast.vtiger.genericUtility.WebDriver_utility;

public class CreateOrganisation {
	/*This is used to create organisation
	 * @author AmarKumar
	 */
	public static void main(String[] args) throws Throwable {
		// SCENARIO 1:CREATE NEW ORGANISATION
		 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//LOGINPAGE	   VIA  PROPERTY FILE UTILITY USE 
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
			String ORGANISATION = eu.GetDatafromExcel("ORGANISATION", 0, 0);
//wb utility used 
			WebDriver_utility wlib =  new WebDriver_utility();
			wlib.waitforpageToload(driver);
			driver.manage().window().maximize();
//HOMEPAGE-->ORGANISATION
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//JAVA UTILITY USED		
				Java_utility ju = new Java_utility();
				int random = ju.getRandomNum();
	    String orgname = ORGANISATION+random;	
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String Actualorganisationname = driver.findElement(By.className("dvHeaderText")).getText();
		if(Actualorganisationname.contains(orgname)) {
			System.out.println("THE ORG IS CREATED THAT IS: "+orgname);
		}else {
			System.out.println("OOHO! not matched");
		}
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();//not write 
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
