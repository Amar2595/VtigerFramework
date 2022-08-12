package practice;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFlipkartByPropertyFile {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe"); 
		FileInputStream fis = new FileInputStream("./TestData/Common.properties");
		Properties pboj = new Properties();
		pboj.load(fis);
		String url = pboj.getProperty("flipkarturl");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	
	}

	}
