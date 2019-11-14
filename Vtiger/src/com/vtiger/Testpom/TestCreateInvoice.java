package com.vtiger.Testpom;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generics.BaseTest;
import com.vtiger.generics.XL;
import com.vtiger.pom.CreatingNewInvoice;
import com.vtiger.pom.Delete;
import com.vtiger.pom.HomePage;
import com.vtiger.pom.Invoice;
 import com.vtiger.pom.VtigerLogin;

public class TestCreateInvoice extends BaseTest
{
	@Test
	public void validTitle() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		String title = XL.getData(XLPATH, LoginSheet, 1, 2);
		String invoiceorg=XL.getData(XLPATH, invoiceSheet, 1, 0);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.moremodule();
		hm.invoiceModule();
		hm.createinvoicepage();
		System.out.println("Creating invoice page displayed");
		
		Invoice ic = new Invoice(driver);
		ic.subjectName(invoiceorg);
		Thread.sleep(4000);
		ic.addorg();
		String mainwh = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		win.remove(mainwh);
		for(String window : win)
		{
			
			driver.switchTo().window(window).switchTo();
		}
		ic.clickorg();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(mainwh);
		Thread.sleep(4000);
		System.out.println("organisation added!!");
		ic.radioclick();
		ic.additem();
		String mainitemwin = driver.getWindowHandle();
		Set<String> iwin = driver.getWindowHandles();
		iwin.remove(mainitemwin);
		for(String itemwin : iwin)
		{
			driver.switchTo().window(itemwin).switchTo();
		}
		ic.selectitem();
		Thread.sleep(2000);
		driver.switchTo().window(mainitemwin);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("3");
		System.out.println("items added successfully");
		ic.saveoption();
		CreatingNewInvoice ni = new CreatingNewInvoice(driver);
		ni.verifypage(driver, 5, title);
		
		
	}
	
	@Test
	public void testcase2() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.moremodule();
		hm.invoiceModule();
		hm.createinvoicepage();
		String title = driver.findElement(By.xpath("//span[text()='Creating New Invoice']")).getText();
		String expect = "Creating New Invoice";
		Assert.assertEquals(expect, title);
		System.out.println("title matched");
		
		
		
	}
	
	
	@Test
	public void testcase3() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.moremodule();
		hm.invoiceModule();
		driver.findElement(By.xpath("//input[@id='5']")).click();
		driver.findElement(By.xpath("//table[@class='small']//input[@value='Mass Edit']")).click();
		
	}
	
	@Test
	public void testcase4() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.moremodule();
		hm.invoiceModule();
		
		Delete de = new Delete(driver);
		de.delcheckbox();
		de.deletebutton();
		driver.switchTo().alert().accept();
	}
	
	
	@Test
	public void testcase5() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td/img[@title='Last Viewed']")).click();
		driver.findElement(By.xpath("//a[text()='Tata motors biling']")).click();
	}
	
	@Test
	public void testcase6() throws Exception
	{
		String username = XL.getData(XLPATH, LoginSheet, 1, 0);
		String password = XL.getData(XLPATH, LoginSheet, 1, 1);
		
		VtigerLogin vl = new VtigerLogin(driver);
		vl.username(username);
		vl.password(password);
		vl.login();
		System.out.println("Loggined successfully");
		Thread.sleep(3000);
		
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.moremodule();
		hm.invoiceModule();
		String tayota = driver.findElement(By.xpath("//tr[@bgcolor='white']//a[text()='tayota bill']")).getText();
		System.out.println(tayota);
		driver.findElement(By.xpath("//select[@id='bas_searchfield']")).click();
		driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']//option[@label='Subject']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("tayota bill",Keys.ENTER);
		Thread.sleep(10000);
		String newtayota = driver.findElement(By.xpath("//tr[@bgcolor='white']/td[3]")).getText();
		System.out.println(newtayota);
		Assert.assertEquals(tayota, newtayota);
		System.out.println("created invoice found");
	}

}
