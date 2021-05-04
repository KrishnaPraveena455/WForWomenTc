package com.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	public WebDriver driver;

	   
	   @BeforeClass
	   @Parameters({"url"})
	   public void setup(String url)
	   {
		   
		   System.setProperty("webdriver.chrome.driver",
					"E:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			
	   }
		
		@AfterClass
		public void TearDown() {
			driver.close();
		}




}
