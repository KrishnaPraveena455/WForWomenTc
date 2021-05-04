package com.testCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pages.WPages;
import com.testBase.TestBase;
import com.utilities.ExcelUtility;

public class TestCase_W extends TestBase
{

	@Test(dataProvider = "getData")
	public void getItems(String inp) throws InterruptedException
	{

		WPages big = new WPages(driver);
		big.getSearchBox().clear();
		big.getSearchBox().sendKeys(inp);
		big.getSearchBox().sendKeys(Keys.ENTER);
		
		
		Thread.sleep(7000);
		boolean noResults;
		try {
			big.getIsNoResult().isDisplayed();
			noResults = true;
		} catch (NoSuchElementException e) {
			noResults = false;
		}
		if (noResults) {
			Reporter.log("No Item Found", true);

		}
		else {
			List<WebElement> items = big.getItemNames();
			 Reporter.log("INPUT " +inp,true);
			for (WebElement item : items) 
	        {
		    	
		    	Reporter.log(item.getText(), true);
					
			}
		}
		
		
	
	 }

	@DataProvider
	public String[][] getData() throws IOException {
		String path = "C:\\work\\BigBasketcasestudy\\src\\test\\java\\com\\utilities\\W.xlsx";
		String sheet = "Sheet1";
		int rowCount = ExcelUtility.getRowCount(path, sheet);
		int cellCount = ExcelUtility.getCellCount(path, sheet, rowCount);
		System.out.println("rowcount : "+rowCount);
		System.out.println("cellCount : "+cellCount);
		String[][] data = new String[rowCount][cellCount];
		for  (int i = 1; i<= rowCount; i++) {
			for(int j = 0; j< cellCount ; j++) {
				System.out.println("In loop Value of I : "+ i +"Value of J: "+j);
				data[i-1][j] =  ExcelUtility.getCellData(path, sheet, i, j);
			}		
		}	
		return data;
	}	

}
