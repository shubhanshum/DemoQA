package com.demoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxFormPage {

	WebDriver driver;
	
	@FindBy(id="userName")
	WebElement fullNameTextBox;
	
	@FindBy(id="userEmail")
	WebElement emailTextBox;
	
	@FindBy(id="currentAddress")
	WebElement currentAddressTextBox;
	
	@FindBy(id="permanentAddress")
	WebElement permanentAddressTextBox;
	
	@FindBy(id="submit")
	WebElement submitButton;
	
	@FindBy(id="name")
	WebElement userNameText;
	
	@FindBy(id="name")
	WebElement userEmailText;
	
	public TextBoxFormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFullName(String fullName) {
		fullNameTextBox.sendKeys(fullName);
	}
	
	public void enterEmail(String userEmail) {
		emailTextBox.sendKeys(userEmail);
	}
	
	public void enterCurrentAddress(String currentAddress) {
		currentAddressTextBox.sendKeys(currentAddress);
	}
	
	public void enterPermanentAddress(String permanentAddress) {
		permanentAddressTextBox.sendKeys(permanentAddress);
	}
	
	public void clickSubmitButton() {
		Actions action=new Actions(driver);
		action.moveToElement(submitButton).click().perform();
	}
	
	public String getUserName() {
		return userNameText.getText();
	}
	
	public String getUserEmail() {
		return userEmailText.getText();
	}
	
	public void fillUserFormAndSubmit(String fullName,String userEmail,String currentAddress,String permanentAddress) {
		this.enterFullName(fullName);
		this.enterEmail(userEmail);
		this.enterCurrentAddress(currentAddress);
		this.enterPermanentAddress(permanentAddress);
		this.clickSubmitButton();
	}
}
