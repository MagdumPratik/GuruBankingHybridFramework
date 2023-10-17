package BaseClassess;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import PageObject.AddCustomer;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerBaseClass {
	public Faker faker;
	public WebDriver driver;
	public static AddCustomer ad;
	public LoginPage lp;
	public String base_urlBS="https://demo.guru99.com/v4/index.php";
	public String usernameBS="mngr524719";
	public String passwordBS="qUsUdAr";
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

	@BeforeMethod
	public void loginData()
	{
		driver.get(base_urlBS);
		lp=new LoginPage(driver);
		lp.setUSername(usernameBS);
		lp.setPassword(passwordBS);
		lp.clickLoginBtn();
		
	}
	
	public String generateEmail()
	{
		faker=new Faker();
		return faker.internet().emailAddress();
		
	}
	@AfterClass
	public void tearUp()
	{
		driver.quit();
	}
}
