package com.cast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.cast.vtiger.objectRepository.LoginPage;
public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sDriver;
	 PropertyFile pf = new PropertyFile();
	 
@BeforeSuite(groups = {"smokeTest"})
public void BS() {
	System.out.println("Database Connectivity");
}
@BeforeTest(groups = {"smokeTest"})
public void BT(){
	System.out.println("Execute Script in Parellel Mode");
}
//@Parameters("BROWSER") 
@BeforeClass(groups = {"smokeTest"})
            //  public void BC(String BROWSER) throws Throwable {  //cross browser
public void BC() throws Throwable {
	System.out.println("Launching Browser");
	String BROWSER = pf.getpropertykeyvalue("browser");         //put in comment during cross
	if(BROWSER.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
	}
	sDriver= driver;
	WebDriver_utility wlib =  new WebDriver_utility();
	wlib.waitforpageToload(driver);
}
@BeforeMethod(groups = {"smokeTest"})
public void BM() throws Throwable {
	System.out.println("Login to Vtiger Application");
	String Url = pf.getpropertykeyvalue("url");
	String username = pf.getpropertykeyvalue("username");
	String password = pf.getpropertykeyvalue("password");
	driver.get(Url);
	//Login By Object Repository
	LoginPage login = new LoginPage(driver);
	login.login(username, password);
}
@AfterMethod(groups = {"smokeTest"})
public void AM() {
	System.out.println("Logout from App");
}
@AfterClass(groups = {"smokeTest"})
public void AC() {
	System.out.println("Closing The Browser");
}
@AfterTest(groups = {"smokeTest"})
public void AT() {
	System.out.println("Parellel Execution Is Done");
}
@AfterSuite(groups = {"smokeTest"})
public void AS() {
	System.out.println("Dissconect DataBase Connectivity");
}

}
