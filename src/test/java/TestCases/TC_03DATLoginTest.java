package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClassess.LoginPageBaseClass;
import PageObject.LoginPage;

public class TC_03DATLoginTest extends LoginPageBaseClass{

	@Test(dataProvider="LoginData")
	public void loginData(String user, String pass)
	{
		driver.get(base_urlBS);
		logger.info("Url open");
		lp=new LoginPage(driver);
		lp.setUSername(user);
		logger.info("Username set");
		lp.setPassword(pass);
		logger.info("Password set");
		lp.clickLoginBtn();
		logger.info("Click on login Button");
		if(alertIsPresent()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("Alert acceped of to the login page");
			logger.info("Test Case Failed");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed");
			lp.clickLogoutBtn();
			driver.switchTo().alert().accept();
			logger.info("Successfully logged off");
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String ExcelFilePath=".//DATTestData//LoginData1.xlsx";
		int rowcount=xl.getRowCount(ExcelFilePath, "Sheet1");
		int cellcount=xl.getCellCount(ExcelFilePath, "Sheet1", 1);
		String[][] loginData=new String[rowcount][cellcount];
		
		for(int i=1; i<=rowcount; i++)
		{
			for(int c=0;c<cellcount;c++)
			{
				loginData[i-1][c]=xl.getCellData(ExcelFilePath, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}
