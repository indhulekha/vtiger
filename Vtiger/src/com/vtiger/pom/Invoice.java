package com.vtiger.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice 
{
	WebDriver driver;
	public  Invoice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement org;
	@FindBy(xpath="//input[@name='account_name']//following::img[@title='Select']")
	private WebElement add;
	
	//@FindBy(xpath="//tr//input[@name='cpy']")
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement radio;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement item;
	@FindBy(xpath="//a[text()='Rubber']")
	private WebElement selitem;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement save;
	
	
	public void subjectName(String user)
	{
		subject.click();
		subject.sendKeys(user);
	}
	public void addorg()
	{
		add.click();
	}
	public void clickorg() throws Exception
	{
		org.click();	
	}
	public void radioclick()
	{
		radio.click();
	}
	public void additem()
	{
		item.click();
	}
	public void selectitem()
	{
		selitem.click();
	}
	
	public void saveoption()
	{
		save.click();
	}
	

}
