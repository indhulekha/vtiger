package com.vtiger.generics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	}
	public static void main(String[] args) throws Exception
	{
		
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("localhost:8888");
			String mainwh = driver.getWindowHandle();
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("manager");
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='More']")).click();
			driver.findElement(By.name("Invoice")).click();
			driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
			driver.findElement(By.xpath("//input[@name='account_name']//following::img[@title='Select']")).click();
			Set<String> win = driver.getWindowHandles();
			for(String window : win)
			{
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
			}
			driver.findElement(By.xpath("//a[@id='1']")).click();
			driver.switchTo().window(mainwh);
	}

}
