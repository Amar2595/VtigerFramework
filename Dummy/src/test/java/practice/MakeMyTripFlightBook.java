package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cast.vtiger.genericUtility.WebDriver_utility;

public class MakeMyTripFlightBook {

	public static void main(String[] args) {
		// Make My Trip Flight Booking From delhi To Bengaluru
		 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 WebDriver_utility wlib =new WebDriver_utility();
		 wlib.waitforpageToload(driver);
		 driver.get("https://www.makemytrip.com/flights/");
			/*HARD CODED
			 * driver.findElement(By.xpath("//span[text()='From']")).click();
			 * 
			 * driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).
			 * sendKeys("Pune, India");
			 * driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
			 * 
			 * driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).
			 * sendKeys("Chicago, United States");
			 * driver.findElement(By.xpath("//p[text()='Chicago, United States']")).click();
			 * driver.findElement(By.xpath("//p[text()='20']")).click();
			 * driver.findElement(By.xpath("//span[text()='RETURN']")).click();
			 * driver.findElement(By.xpath("//p[text()='27']")).click();
			 */
		 WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		 WebElement des = driver.findElement(By.xpath("//input[@id='toCity']"));
		 
		 src.sendKeys("Pune");
		 driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
		 des.sendKeys("Chicago");
		 driver.findElement(By.xpath("//p[text()='Chicago, United States']")).click();
		 driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();
		 
		 driver.findElement(By.xpath("//label[@for='departure']")).click();
		 String Month="September";
		 String year="2022";
		 String Date="15";
		 
		// String CurrentMonthYear  = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		// String CurrentMonth = CurrentMonthYear.split(" ")[0];
		// String Currentyear = CurrentMonthYear.split(" ")[1];
		 driver.findElement(By.xpath("//div[text()='"+Month+" "+year+"']")).click();
		 driver.findElement(By.xpath("(//p[text()='"+Date+"'])[2]")).click();
		  
		    // while(!(CurrentMonth.equalsIgnoreCase(Month)&& Currentyear.equals(year))) {
			//driver.findElement(By.xpath("//span[@class='DayPicker-NavButton Daypicker-NavButton--next']")).click();
			//String CurrentMonthYear  = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			// String CurrentMonth = CurrentMonthYear.split(" ")[0];
			// String Currentyear = CurrentMonthYear.split(" ")[1];
			// driver.findElement(By.xpath("//p[text()='"+Date+"']")).click();
		
		}
		 
	}
