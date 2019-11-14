package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement more;
	
	@FindBy(name="Invoice")
	private WebElement invoice;
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createinvoice;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void moremodule()
	{
		more.click();
	}
	public void invoiceModule()
	{
		invoice.click();
	}
	public void createinvoicepage()
	{
		createinvoice.click();
	}
}
