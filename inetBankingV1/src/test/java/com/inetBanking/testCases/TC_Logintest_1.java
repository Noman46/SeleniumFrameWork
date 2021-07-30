package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilites.AllureListener;



@Listeners({AllureListener.class})
public class TC_Logintest_1 extends BaseClass {
	
	
	
	@Test(priority = 0)
	public void loginWithValidCred() throws InterruptedException {
		driver.get(properties.getProperty("BASEURL"));
		Thread.sleep(5000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendKeysToUserName(properties.getProperty("USERNAME"));
		loginPage.sendKeysToPassword(properties.getProperty("PASSWORD"));
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	}
	
	@Test(priority = 1)
	public void logout() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogout();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
	}
}
