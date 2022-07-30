package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;

public class LoginSteps {
	WebDriver driver;
	LoginPage lp;
	Logger logger;
	Properties configProp;
	

	@Before
	public void setUP() throws IOException {

		logger = Logger.getLogger("CucumberNewProject");
		PropertyConfigurator.configure("C:\\Users\\sony\\eclipse-workspace\\CucumberNewProject\\log4j.properties");

		configProp = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\sony\\eclipse-workspace\\CucumberNewProject\\config.Properties");
		configProp.load(ip);

		

	}

	@Given("I Launch the browser")
	public void i_launch_the_browser() {
		String br = configProp.getProperty("browser");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}

		else if (br.equals("mozila")) {

		}

		logger.info("*****Launching Browser********");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@Then("enter the url {string}")
	public void enter_the_url(String url) throws InterruptedException {
		logger.info("*****openigng URL********");
		driver.get(url);
		Thread.sleep(3000);
	}

	@Then("enter the Email as {string} and password as {string}")
	public void enter_the_email_as_and_password_as(String username, String password) throws InterruptedException {
		logger.info("*****Passing credential********");
		lp.setUserName(username);
		lp.setPassword(password);
		Thread.sleep(3000);
	}

	@Then("hit the login button")
	public void hit_the_login_button() throws InterruptedException {

		lp.clickLoginbtn();
		Thread.sleep(5000);
	}

	@Then("Dashboard page title should be {string}")
	public void dashboard_page_title_should_be(String string) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
		} else {
			String title = driver.getTitle();
			lp.verifyDashboardPageTitle(title);
			Assert.assertEquals(lp.dashboardtitle, title);
			Thread.sleep(3000);

		}

	}

	@Then("I logout from the application")
	public void i_logout_from_the_application() {
		lp.logout();
	}

	@Then("I verify the login page title {string}")
	public void i_verify_the_login_page_title(String loginPageTitle) {
		Assert.assertEquals(loginPageTitle, driver.getTitle());
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();

	}
}
