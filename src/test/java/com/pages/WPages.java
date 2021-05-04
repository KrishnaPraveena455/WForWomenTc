package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WPages
{
 WebDriver driver;
     
     public WPages(WebDriver driver)
     {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
     }
     @FindBy(className="error-bg")
     WebElement noResult;
     
     public WebElement getIsNoResult()
     {
    	 return noResult;
     }
     
   
	@FindBy(xpath="//*[@id=\"search\"]")
	WebElement searchBox;
	
	public WebElement getSearchBox()
	{
		return searchBox;
	}
	
	@FindAll(@FindBy(xpath="//*[@id=\"searchModal\"]/div[1]/div[2]/div[2]/div[4]/div/div[1]/div/div[2]/div[2]/p/a"))
	List <WebElement> itemNames;
	
	public List<WebElement> getItemNames()
	{
		return itemNames;
	}
}

//*[@id="home-page-wrapper"]/div[4]/app-search-items/div/div/div/div[3]/app-menu-items/div/app-menu-item[4]/div/div/div/div[2]/div[1]/div
//*[@id="home-page-wrapper"]/div[4]/app-search-items/div/div/div/div[3]/app-menu-items/div/app-menu-item/div/div/div/div[2]/div[1]/div