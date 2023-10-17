package BaseClassess;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageObject.LoginPage;
import Utilities.ReadProperty;
import Utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageBaseClass {
	public static ReadProperty rp=new ReadProperty();
	public static XLUtils xl=new XLUtils();
	
	public WebDriver driver;
	public static LoginPage lp;
	public String base_urlBS=rp.getApllicationurl();
	public String usernameBS=rp.getUsername();
	public String passwordBS=rp.getPassword();
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger=logger.getLogger("GuruBanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	

	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			logger.info("Alert  is present");
			return true;
		}
		catch(Exception e)
		{
			logger.info("Alert not present");
			return false;
		}
	}

	@AfterClass
	public void tearUp()
	{
		driver.quit();
	}
}
