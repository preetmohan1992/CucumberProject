package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageBase.PageBase;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import utilities.LibraryWait2;

public class AddCustomerSteps extends PageBase {
	public WebDriver driver;
	LoginPage lp;
	AddCustomer addcust;
	LibraryWait2 wait;

	@Given("when user on the login page")
	public void when_user_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse-workspace\\CucumberProject\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		addcust = new AddCustomer(driver);
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		lp.setUserName(username);
		lp.setPassword(password);
	}

	@Then("user click on login button")
	public void user_click_on_login_button() throws InterruptedException {
		lp.clickLoginbtn();
		Thread.sleep(3000);
	}

	@Then("user can view the Dashboard page title as {string}")
	public void user_can_view_the_dashboard_page_title_as(String Dashboardtitle) throws InterruptedException {
		String title = driver.getTitle();
		lp.verifyDashboardPageTitle(title);
		Assert.assertEquals("Dashboard / nopCommerce administration", title);
		Thread.sleep(5000);
	}

	@When("user click on Customermenu")
	public void user_click_on_customermenu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickCustomerMenu();
	}

	@When("user click on AddCustomer menu item")
	public void user_click_on_add_customer_menu_item() {
		addcust.clickCustomersOption();
	}

	@When("user click on Add new button")
	public void user_click_on_add_new_button() {
		addcust.addNewBtn();
	}

	@When("user can view the Add new customer page and can see title {string}")
	public void user_can_view_the_add_new_customer_page_and_can_see_title(String string) throws InterruptedException {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
		Thread.sleep(3000);
	}

	@When("user enters the customer info")
	public void user_enters_the_customer_info() throws InterruptedException {
		String email = getrandomeString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setGender();
		addcust.selectDob("07/05/1993");
		addcust.setComapanyName("testcom");
		// addcust.setnewsLetter();
		addcust.selectCustomerRole("Registered");
		// addcust.selectVendorManager("not a vendor");
		addcust.addCommnet("test something");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addcust.saveUser();
	}

	@Then("user can view the confirmation message {string}")
	public void user_can_view_the_confirmation_message(String string) {
		addcust.verifyConfirmationMessage();

	}

}
