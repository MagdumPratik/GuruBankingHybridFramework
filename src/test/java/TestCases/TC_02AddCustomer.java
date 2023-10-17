package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassess.AddCustomerBaseClass;
import PageObject.AddCustomer;

public class TC_02AddCustomer extends AddCustomerBaseClass{

	@Test
	public void addCustomer() throws InterruptedException
	{
		ad=new AddCustomer(driver);
		ad.clickNewCustomer();
		Thread.sleep(2000);
		logger.info("click on new cutomer tab");
		ad.setNAme("Pratik Namdev Magdum");
		Thread.sleep(2000);
		logger.info("Name set");
		ad.selectGender();
		Thread.sleep(2000);
		logger.info("Female gender is selected");
		ad.setDate("12-12-1998");
		Thread.sleep(2000);
		logger.info("DAte set");
		ad.setAddress("Waghave");
		Thread.sleep(2000);
		logger.info("Address set");
		ad.setCity("Kolhapur");
		Thread.sleep(2000);
		logger.info("City set");
		ad.setState("Maharashtr");
		Thread.sleep(2000);
		ad.setPinCode("416230");
		Thread.sleep(2000);
		logger.info("Pincode set");
		ad.setMobileNumber("1234567894");
		Thread.sleep(2000);
		logger.info("Mobile Number set");
		ad.setEmail(generateEmail());
		Thread.sleep(2000);
		logger.info("Email set");
		ad.setPassword("Gmail@7458");
		Thread.sleep(2000);
		logger.info("Password set");
		ad.clickSubmit();
		Thread.sleep(2000);
		String expected="Customer Registered Successfully!!!";
		String actual=ad.getHeadline();
		Thread.sleep(3000);
		if(actual.equals(expected))
		{
			logger.info("Customer aded successfully.....");
			
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Customer not added....");
		}
	}
	
}
