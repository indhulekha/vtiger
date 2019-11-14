package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delete 
{
	WebDriver driver;
	public  Delete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr[@id='row_6']//input")
	private WebElement delchek;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/input[@value='Delete']")
	private WebElement delbutton;
	public void delcheckbox()
	{
		delchek.click();
	}
	
	public void deletebutton()
	{
		delbutton.click();
	}

}
