package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CampaigntoProduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		FileInputStream fis = new FileInputStream("./TestData/ExcelData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("NAVIGATION");
		 Row row = sheet.getRow(1);
		   Cell cell = row.getCell(0); Cell cell1 = row.getCell(1);  Cell cell2 = row.getCell(2);
		   Sheet campaignsheet = wb.getSheet("campaign"); Row cr = campaignsheet.getRow(0);  Cell cc= cr.getCell(0);
		   Sheet product = wb.getSheet("PRODUCT"); Row pr = product.getRow(0);   Cell pc= pr.getCell(0);
		 String cellvalueUrl = cell.getStringCellValue();
	     String username = cell1.getStringCellValue();
		 String password = cell2.getStringCellValue();
		 String campaign = cc.getStringCellValue();
		 System.out.println(cellvalueUrl);
		 WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);driver.manage().window().maximize();driver.get(cellvalueUrl);
			String wid = driver.getWindowHandle();//System.out.println(wid);//1
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.xpath("//img[@alt='Select']")).click();//switch window handle	
			Set<String> chiwid = driver.getWindowHandles();
			System.out.println(chiwid);//[CDwindow-1E232E042D8BE9E3B38C5DA00E26D64A, CDwindow-2120A854281485C90D8CC9E0225ADC3E]
			for(String windo :chiwid) {
				System.out.println(windo);//same parent 
				driver.switchTo().window(windo);
				System.out.println(windo);//i am getting parent id CDwindow-1E232E042D8BE9E3B38C5DA00E26D64A
				//System.out.println(chiwid);//i am getting two id
			if(!windo.equals(wid)) {
				String productname = pc.toString();
				System.out.println(productname);
				String wid2 = driver.getWindowHandle();System.out.println(wid2);
			driver.findElement(By.id("search_txt")).sendKeys(productname);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("(//td)[42]")).click();
			driver.findElement(By.linkText("COFEE510")).click();
			 driver.switchTo().window(wid);
			 String wid1 = driver.getWindowHandle();System.out.println(wid1);//1
			 Random r = new Random(); int random = r.nextInt(1000);
			  String campaignname = cc.getStringCellValue()+random;
			  driver.findElement(By.name("campaignname")).sendKeys(campaignname);
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).
			  click(); driver.findElement(By.linkText("Sign Out")).click();

			}}
}}
