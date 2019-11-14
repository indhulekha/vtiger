package com.vtiger.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import com.vtiger.generics.XL;

public class BaseTest implements Constants
{
	public static WebDriver driver;
	static Properties con;
	static FileInputStream fis;
	static String b_name = " ";
	int r=1,c=0;
	static 
	{
		try 
		{
			//XL.createExcel("Sheet1", REPORTPATH);
			con = new Properties();
			fis = new FileInputStream(CONFIG_PATH);
			con.load(fis);
			b_name = con.getProperty("browser");
			if (b_name.contains("chrome")) {
				System.setProperty(CHROME_KEY, CHROME_VALUE);
			}
			else
			{
				System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void OpenApp() 
	{
		if ((b_name.contains("chrome"))) {
			driver = new ChromeDriver();
		} 
		else 
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL);
	}
	@AfterMethod
	public void closeApp(ITestResult ITestresult) throws Exception
	{

		int status = ITestresult.getStatus();
		String name1 = ITestresult.getName();
		if (status == 1) 
		{

			Reporter.log("Test " + name1 + " is passed", true);
		}
		else 
		{
			Reporter.log("test" + name1 + " is failed", true);
		
		}
	//	driver.close();
	}



}
