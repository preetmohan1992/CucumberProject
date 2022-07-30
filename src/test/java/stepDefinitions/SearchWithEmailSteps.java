package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchUser;
import utilities.LibraryWait2;

public class SearchWithEmailSteps {
	WebDriver driver;
	AddCustomer addCust;
	LoginPage lp;
	LibraryWait2 wait;
	SearchUser suser;
	
	public SearchWithEmailSteps()
	{
		
		lp = new LoginPage(driver);
		addCust= new AddCustomer(driver);
		wait= new LibraryWait2();
	}
	
	@Given("user is on loginpage")
	public void user_is_on_loginpage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\eclipse-workspace\\CucumberProject\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
	    driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("user login with email as {string} and password as {string}")
	public void user_login_with_email_as_and_password_as(String email, String pass) {
		lp.setUserName("email");
	    lp.setPassword(pass);
	    lp.clickLoginbtn();
	}

	@Then("user can view the dashboardpage")
	public void user_can_view_the_dashboardpage() {
	    //wait = new LibraryWait();
	    wait.visible(driver,lp.dashboardtitle , 20);
	}

	@When("user click on Customer menu")
	public void user_click_on_customer_menu() {
		wait.visible(driver, driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")), 20);
	    addCust.clickCustomerMenu();
	   
	}

	@When("user click on customer option")
	public void user_click_on_customer_option() {
		 wait.visible(driver, driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")), 20);
		 addCust.clickCustomersOption();
	}

	@Then("User can view Customer page and title as {string}")
	public void user_can_view_customer_page_and_title_as(String customerpagetitle) {
	    suser.verifyCustomerPageTitle(customerpagetitle);
	}
	
	@When("user enter the email id as {string}")
	public void user_enter_the_email_id_as(String email) {
	    suser.setEmail(email);;
	}

	@Then("user click on search button")
	public void user_click_on_search_button() {
	    suser.clickSearchBtn();
	}

	@Then("user can see the user record with email {string}")
	public void user_can_see_the_user_record_with_email(String email) {
	    suser.searchCustomerByEmail(email);
	}
}
