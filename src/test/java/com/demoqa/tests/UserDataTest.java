package com.demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.pageobjects.ElementsPage;
import com.demoqa.pageobjects.LandingPage;
import com.demoqa.pageobjects.WebTablePage;

public class UserDataTest extends RunnerTest{

	LandingPage landingPage;
	ElementsPage elementsPage;
	WebTablePage webTablePage;
	
	@Test
	public void userDataTest() {
		landingPage=new LandingPage(getDriver());
		elementsPage=new ElementsPage(getDriver());
		webTablePage=new WebTablePage(getDriver());
		
		landingPage.clickOnCard("Elements");
		elementsPage.clickWebtableTab();
		String userEmail=webTablePage.getUserEmail("Kierra");
		Assert.assertEquals(userEmail, "kierra@example.com");
	}
}
