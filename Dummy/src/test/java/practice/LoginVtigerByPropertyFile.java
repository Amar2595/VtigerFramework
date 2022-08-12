package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cast.vtiger.genericUtility.PropertyFile;

public class LoginVtigerByPropertyFile {

	public static void main(String[] args) throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe"); 
		/*
		 * FileInputStream fis = new FileInputStream("./TestData/Common.properties");
		 * Properties pboj = new Properties(); pboj.load(fis); String url =
		 * pboj.getProperty("url"); String un = pboj.getProperty("un"); String pwd=
		 * pboj.getProperty("pwd");
		 */
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
	
	}

}
