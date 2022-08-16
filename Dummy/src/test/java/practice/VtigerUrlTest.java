package practice;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerUrlTest {
@Test

	public void VtigerUrlTest ()  throws Throwable {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		    FileInputStream fis = new FileInputStream("./TestData/Common.properties");
			Properties pf = new Properties();
			pf.load(fis);
		    String browser = pf.getProperty("url");
			
			driver.get(browser);
			System.out.println(browser);
	
		
	
}}