package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	WebDriver ldriver;
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement clckNC;
	
	public void clickNewCustomer()
	{
		clckNC.click();
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	public void setNAme(String nm)
	{
		name.sendKeys(nm);
	}
	
	@FindBy(xpath="//input[@value='f']")
	WebElement female;
	
	public void selectGender()
	{
		female.click();
	}
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	
	public void setDate(String date)
	{
		dob.sendKeys(date);
	}
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	public void setCity(String cty)
	{
		city.sendKeys(cty);
	}
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	public void setState(String st)
	{
		state.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pincode;
	
	public void setPinCode(String pn)
	{
		pincode.sendKeys(pn);
	}
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobileNumber;
	
	public void setMobileNumber(String mob)
	{
		mobileNumber.sendKeys(mob);
	}
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailid;
	
	public void setEmail(String em)
	{
		emailid.sendKeys(em);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	public void setPassword(String ps)
	{
		password.sendKeys(ps);
	}
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submit;
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	@FindBy(xpath="//p[@class='heading3']")
	WebElement headline;
	
	public String getHeadline()
	{
	String head=headline.getText();
	return head;
	}
	
}
