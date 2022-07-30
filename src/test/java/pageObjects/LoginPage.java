package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver ldriver;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//title[normalize-space()='Dashboard / nopCommerce administration']")
	public WebElement dashboardtitle;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	public LoginPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}
	
	public void setPassword(String password)
	{
		pwd.clear();
		pwd.sendKeys(password);
	}
	
	public void clickLoginbtn()
	{
		loginbtn.click();
	}
	public String verifyDashboardPageTitle(String title)
	{
		ldriver.getTitle();
		return title;
	}
	
	public void logout()
	{
		logout.click();
	}

}
