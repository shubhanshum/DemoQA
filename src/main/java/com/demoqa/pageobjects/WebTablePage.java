package com.demoqa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='rt-tr-group']/div[contains(@class,'rt-tr') and not(contains(@class,'-padRow'))]/div[contains(@class,'rt-td')]")
	List<WebElement> userDataTable;
	
	public WebTablePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUserEmail(String userName) {
		int dataLen=userDataTable.size();
		String userEmail="";
		for (int i=0;i<dataLen;i++) {
			if (userDataTable.get(i).getText().equals(userName)) {
				userEmail=userDataTable.get(i+3).getText();
				break;
			}
		}
		return userEmail;
	}
}
