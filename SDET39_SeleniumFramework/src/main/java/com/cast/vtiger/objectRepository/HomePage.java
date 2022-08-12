package com.cast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public   HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//a[text()='Calendar']")
	private WebElement Calender;
	@FindBy(xpath ="//a[text()='Leads']")
	private WebElement Lead;
	@FindBy(xpath ="//a[text()='Organizations']")
	private WebElement Organisation;
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement Contacts;
	@FindBy(xpath ="//a[text()='Opportunities']")
	private WebElement Opportunities;
	@FindBy(xpath ="//a[text()='Products']")
	private WebElement Products;
	@FindBy(xpath ="//a[text()='Documents']")
	private WebElement Documents;
	@FindBy(xpath ="//a[text()='Email']")
	private WebElement Email;
	@FindBy(xpath ="//a[text()='Trouble Tickets']")
	private WebElement TroubleTickets;
	@FindBy(xpath ="//a[text()='Dashboard']")
	private WebElement Dashboard;
	@FindBy(xpath ="//a[text()='More']")
	private WebElement More;
	@FindBy (linkText = "Sign Out")
	private WebElement SignOut;
	@FindBy (linkText = "Campaigns")
	private WebElement Campaigns;
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administration;
	
	//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();//not write 
	//driver.findElement(By.linkText("Sign Out")).click();
	
	
	
	
	public WebElement getAdministration() {
		return Administration;
	}
	public WebElement getCampaigns() {
		return Campaigns;
	}
	public WebElement getSignOut() {
		return SignOut;
	}
	public WebElement getCalender() {
		return Calender;
	}
	public WebElement getLead() {
		return Lead;
	}
	public WebElement getOrganisation() {
		return Organisation;
	}
	public WebElement getContacts() {
		return Contacts;
	}
	public WebElement getOpportunities() {
		return Opportunities;
	}
	public WebElement getProducts() {
		return Products;
	}
	public WebElement getDocuments() {
		return Documents;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}
	public WebElement getDashboard() {
		return Dashboard;
	}
	public WebElement getMore() {
		return More;
	}
/**
 * @param organisation
 * @param product
 * @author HI
 */
	public void ClickOrganisation()
	{ Organisation.click();
	}
	public void ClickProduct()
	{ Products.click();
	}
	public void Clickmore()
	{ More.click();
	}
	public void ClickCampaign()
	{
		Campaigns.click();
	}
	public void ClickSignOut() {
		SignOut.click();
	}
	public void ClickAdministration() {
		Administration.click();
	}
	
}
