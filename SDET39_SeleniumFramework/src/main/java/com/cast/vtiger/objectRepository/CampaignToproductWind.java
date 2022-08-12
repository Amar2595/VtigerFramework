package com.cast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignToproductWind {
public CampaignToproductWind(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@alt='Select']")
 private WebElement ClickOnAddProductButton;
@FindBy (name ="search_text")
	private WebElement searchProduct;
@FindBy (name="search")
   private WebElement searchButton;



public WebElement getClickOnAddProductButton() {
	return ClickOnAddProductButton;
}
public WebElement getSearchProduct() {
	return searchProduct;
}

public WebElement getSearchButton() {
	return searchButton;
}


/**Add Product in campaign 
 * searchProduct
 * Click on search
 * clickInproduct
 * AddProduct
 * @author HI
 */
public void AddProduct()
{
	ClickOnAddProductButton.click();
}
public void SearchProduct(String Productname) {
	searchProduct.sendKeys(Productname);;
}
public void searchButton(WebDriver driver,String productName) {
	searchButton.click();
	driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
}




}


