package com.cast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	
public  LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="user_name")
private  WebElement usernameTextfield1;
	
@FindBy(name="user_password")
	private  WebElement passwordTextfield;

@FindBy(id="submitButton")
private  WebElement loginbutton;    
//getter method to read that item
public WebElement getUsernameTextfield1() {
	return usernameTextfield1;
}
public WebElement getPasswordTextfield() {
	return passwordTextfield;
}
public WebElement getLoginbutton() {
	return loginbutton;
}
//Business logic
/** 
 * Used For Login 
 * @param username
 * @param password
 * @author HI
 */
public void login(String username,String password)
{ usernameTextfield1.sendKeys(username);
passwordTextfield.sendKeys(password);
loginbutton.click();
}
	}
