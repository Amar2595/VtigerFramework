package com.cast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt= 'Create Product...']")
	private WebElement  CreateProduct;
	@FindBy(name ="productname")
	private WebElement  AddProductName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveProduct;
	@FindBy(name="Delete")
	private WebElement DeleteProduct;
	
    public WebElement getDeleteProduct() {
		return DeleteProduct;
	}
	public WebElement getCreateProduct() {
		return CreateProduct;
	}

	public WebElement getAddProductName() {
		return AddProductName;
	}
	
	public WebElement getSaveProduct() {
		return SaveProduct;
	}
	
/**Create Product By Click On Plus Button In side product
 * @author HI
 */
	public void createNewProduct() {
		CreateProduct.click();	
	}
	public void AddProductName(String ProductName) {
		AddProductName.sendKeys(ProductName);;	
	}
	public void SaveProduct() {
		SaveProduct.click();	
	}
	public void DeleteProduct() {
		DeleteProduct.click();
	}
	
	
	
	
	
}
