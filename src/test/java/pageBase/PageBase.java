package pageBase;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.AddCustomer;
import pageObjects.LoginPage;

public class PageBase 
{
	public static WebDriver driver;
	public LoginPage lp;
	public AddCustomer ac;
	public static Logger logger;
	public Properties configProp;
	
	  public static void launchingUrl()
	  { driver= new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get("https://admin-demo.nopcommerce.com/login");
	  }
	
	public static String getrandomeString()
	{
		String generateString1= RandomStringUtils.randomAlphabetic(5);
		return null;
	}
}
