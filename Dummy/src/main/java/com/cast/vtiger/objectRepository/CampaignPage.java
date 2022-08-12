package com.cast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
public CampaignPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
// To click on + button
@FindBy (xpath ="//img[@alt='Create Campaign...']")
private WebElement createCampaign;
//Add campaign name
@FindBy (name = "campaignname")    
private WebElement addCampaignName;
//Click On Add Product + Button
@FindBy (xpath="//img[@alt='Select']")
private WebElement clickOnAddProduct;
@FindBy (xpath = "//input[@title='Save [Alt+S]']")
private WebElement clickOnSaveButton;

public WebElement getClickOnSaveButton(){
	return clickOnSaveButton;
}
public WebElement getCreateCampaign(){
	return createCampaign;
}
public WebElement getAddCampaignName(){
	return addCampaignName;
}
public WebElement getClickOnAddProduct(){
	return clickOnAddProduct;
}

/**To create Campaign click on plus button
 * Create Campaign
 * ClickonAddProduct
 * ClickOnSaveButton
 * @author HI
 */

public void CreateCampaign(){  
	createCampaign.click();
}
public void AddCampaignName(String campaignname){
	addCampaignName.sendKeys(campaignname);
}
public void clickOnAddProduct(){
	clickOnAddProduct.click();
}
public void ClickOnSaveButton(){
	clickOnSaveButton.click();
}
}
