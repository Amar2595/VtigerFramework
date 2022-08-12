package com.cast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);}
	
@FindBy(xpath ="//img[@alt='Create Organization...']")
private  WebElement CreateOrganization;
@FindBy(xpath ="//input[@title='Save [Alt+S]']")
private WebElement ClickSaveOrganisation;
@FindBy(xpath ="//input[@name='accountname']")
private WebElement AddOrganisationName;



public WebElement getAddOrganisationName() {
	return AddOrganisationName;
}
public WebElement getClickSaveOrganisation() {
	return ClickSaveOrganisation;
}
public WebElement getCreateOrganization() {
	return CreateOrganization;
}
/** New Organization create By clicking on plus button
 * @param click
 *@author HI		
 */
public void orgPlusButton(){
	CreateOrganization.click();
}
public void AddOrganisationName(String orgname) {
	AddOrganisationName.sendKeys(orgname);
}
public void ClickOnSaveButton() {
	ClickSaveOrganisation.click();
}

	}

