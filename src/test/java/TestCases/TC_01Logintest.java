package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassess.LoginPageBaseClass;
import PageObject.LoginPage;

public class TC_01Logintest extends LoginPageBaseClass{
	
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(base_urlBS);
		logger.info("Url open");
		lp=new LoginPage(driver);
		lp.setUSername(usernameBS);
		logger.info("Username set......");
		lp.setPassword(passwordBS);
		logger.info("Password set");
		lp.clickLoginBtn();
		Thread.sleep(3000);
		String expectedHEader="Manger Id : mngr524719";
		String acturlHeader=lp.getHeaderLine();
		if(expectedHEader.equals(acturlHeader))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed.......");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
		lp.clickLogoutBtn();
		if(alertIsPresent()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("Alert accepted");
		}
		else
		{
			logger.info("Not present");
		}
	}
	
}	
