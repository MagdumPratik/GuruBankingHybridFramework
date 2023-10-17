package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	public void setUSername(String user)
	{
		username.sendKeys(user);
	}

	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}

	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement clickLoginBtn;
	
	public void clickLoginBtn()
	{
		clickLoginBtn.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement clickLogoutBtn;
	
	public void clickLogoutBtn()
	{
		clickLogoutBtn.click();
	}
	
	@FindBy(xpath="//td[normalize-space()='Manger Id : mngr524719']")
	WebElement headerline;
	
	public String getHeaderLine()
	{
		String head=headerline.getText();
		return head;
	}
}
