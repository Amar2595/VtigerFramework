package com.cast.vtiger.genericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.Duration;

public class WebDriver_utility {
	/** 1.waitforpageToload  line no 36
	 *  2.ScriptTimeout  line no 43
	 *  3.waitforElementTobeClickable lno51
	 *  4.waitforElemenentTimeout ln0 58
	 *  5.switchWindowHandle line no 66
	 *  6.switchToAlertAndAccept line no 77
	 *  7.switchToAlertDismiss line no 85
	 *  8.switchToFrame index line no 93
	 *  9.switchToFrame text  line no 97
	 *  10.Select By index   line no 103
	 *  11. Select By text   line no 111
	 *  12. MouseOverOnElement ByActionclass line no 119
	 *  13. RightClickOnElement ByActionclass  line no 139
	*@author HI
	 */
public void waitforpageToload(WebDriver driver)
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
}
/**wait element Timeout exception
*@author HI
 */
public void ScriptTimeout(WebDriver driver) {
driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
}
/**wait Element to be clickable
 * @param driver
 * @param element
 * @Amarkumar
 */
public void waitforElementTobeClickable(WebDriver driver,WebElement Element)
{
	WebDriverWait wait  = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(Element));
}/**wait ElementTimeout
 * @Amarkumar
 */
public void waitforElemenentTimeout(WebDriver driver,WebElement Element,int pollingTime) {
	//FluentWait wait = new FluentWait(driver);
    //wait.pollingEvery(driver,20);
   // wait.until(ExpectedConditions.elementToBeClickable(Element));
}
/** Switching Window parent to  child iD
*@author HI
 */
public void switchWindowHandle(WebDriver driver,String PartialWindowTittle) {
	Set<String> allid = driver.getWindowHandles();
    Iterator<String> it = allid.iterator();
	while(it.hasNext()) {
	String wid = it.next();
	driver.switchTo().window(wid);
   if(driver.getTitle().contains("PartialWindowTittle"))
		{ 
			break;
		}}}
/**Switch alertWindow And Accept click and ok button
*@author HI
 */
public void switchToAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**Switch alertWindow And Dismiss click and cancel button
 *@author HI
 */
public void switchToAlertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**Switch Frame Window based by index value 
 * @param driver
 * @param id
 *@author HI
*/
public void switchToFrame(WebDriver driver,int index) 
{
	driver.switchTo().frame(index);
	}
/**Switch Frame Window based  by attributes
 * @param driver
 * @param id
 *@author HI
*/

public void switchToFrame(WebDriver driver,String id_name_attribute) 
{
	driver.switchTo().frame(id_name_attribute);
}
/**Select the values from Dropdown based on index value
 * @param
 *@author HI
*/
public void select(WebElement element , int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**Select the values from Dropdown based on text
 * @param
 *@author HI
*/
public void select(WebElement element ,String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}

/** Used MouseCurser on specified Element
 * @param driver
 * @param element
 * @author HI
 */
public void mouseOverOnelement(WebDriver driver ,WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/** Used Right click on specified Element
 * @param driver
 * @param element
 * @author HI
 */
public void rightClickOnElement(WebDriver driver ,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
}