package MultiBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest {
	WebDriver driver =null;
	
	
@Parameters("browserName")	
@BeforeTest
public void setup(String browserName) {
 System.out.println("Browser Name Is : "+browserName);
 
 if(browserName.contains("chrome")) {
	 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe"); 
	driver = new ChromeDriver();
 }
 else if (browserName.contains("firefox")) {
	 System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		driver = new FirefoxDriver(); 
 }
 else if (browserName.contains("microsoftedge")) {
	 System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
	driver = new EdgeDriver();
 }
 else if (browserName.contains("ie")) {
	 System.setProperty("webdriver.ie.driver","./drivers/IEdriverServer.exe");
	driver= new InternetExplorerDriver();
 }
}
//test method
@Test
public void test1() throws Throwable   {
	driver.get("https://google.com");
	Thread.sleep(1000);
}

@AfterTest
public void teardown() {
	driver.close();
	System.out.println("Test is completed Succesfully");
}




}
