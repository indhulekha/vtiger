package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CreatingNewInvoice
{
	public CreatingNewInvoice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void verifypage(WebDriver driver, long ETO, String title)
	{
	try
	{
		WebDriverWait ww= new WebDriverWait(driver, ETO);
		ww.until(ExpectedConditions.titleContains(title));
		Reporter.log("Creating New Invoice page is displayed", true);
	}
	catch(Exception e)
	{
		Reporter.log("Creating New Invoice page is not displayed", true);
		Assert.fail();
	}
}

}
