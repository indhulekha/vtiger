package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLogin 
{
	@FindBy(name="user_name")
	private WebElement loginUsername;
	@FindBy(name="user_password")
	private WebElement loginPassword;
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public VtigerLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void username(String username)
	{
		loginUsername.sendKeys(username);
	}
	public void password(String password)
	{
		loginPassword.sendKeys(password);
	}
	public void login()
	{
		loginButton.click();
	}
	

}
