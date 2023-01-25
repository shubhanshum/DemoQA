package com.demoqa.pageobjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ElementsPage {

	WebDriver driver;
	
	@FindBy(id="item-0")
	WebElement textBoxTab;
	
	@FindBy(id="item-3")
	WebElement webTableTab;
	
	public ElementsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTextBoxTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", textBoxTab);
		//Actions action=new Actions(driver);
		//action.moveToElement(textBoxTab).click().perform();
	}
	
	public void clickWebtableTab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webTableTab);
	}

}
