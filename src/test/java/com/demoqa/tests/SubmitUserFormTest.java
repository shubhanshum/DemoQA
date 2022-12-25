package com.demoqa.tests;

import org.testng.annotations.Test;

import com.demoqa.pageobjects.ElementsPage;
import com.demoqa.pageobjects.LandingPage;
import com.demoqa.pageobjects.TextBoxFormPage;

public class SubmitUserFormTest extends RunnerTest{

	LandingPage landingPage;
	ElementsPage elementsPage;
	TextBoxFormPage textBoxFormPage;
	
	@Test
	public void submitUserFormTest() {
		landingPage=new LandingPage(getDriver());
		elementsPage=new ElementsPage(getDriver());
		textBoxFormPage=new TextBoxFormPage(getDriver());
		
		landingPage.clickOnCard("Elements");
		elementsPage.clickTextBoxTab();
		textBoxFormPage.fillUserFormAndSubmit("Shubhanshu Mishra", "mishra.sr89@gmail.com", "current address",
				"permanent address");
	}
	
}
