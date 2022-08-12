package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchActitimeByPropertyFile{

	public static void main(String[] args) throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe"); 
			FileInputStream fis = new FileInputStream("./TestData/Common.properties");
			Properties pboj = new Properties();
			pboj.load(fis);
			String url = pboj.getProperty("acttimeurl");
			String un = pboj.getProperty("username");
			String pwd= pboj.getProperty("password");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.findElement(By.name("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pwd);
			driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
	}

}
