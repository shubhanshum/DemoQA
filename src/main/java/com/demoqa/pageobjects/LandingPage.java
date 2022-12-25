package com.demoqa.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'mt-4')][1]")
	List<WebElement> cards;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCard(String cardName) {
		int cardsLen=cards.size();
		for (int i=0;i<cardsLen;i++) {
			if (cards.get(i).getText().equalsIgnoreCase(cardName)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", cards.get(i));
				break;
			}
		}
	}
	
	

}
