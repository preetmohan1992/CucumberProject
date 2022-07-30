package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
	public WebDriver ldriver;
	Select sel;
	WebElement ele;
	
	By customermenu =By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customeroption= By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By addnew= By.xpath("//a[normalize-space()='Add new']");
	By txtemial =By.xpath("//input[@id='Email']");
	By txtpassword = By.xpath("//input[@id='Password']");
	By fname= By.xpath("//input[@id='FirstName']");
	By lname= By.xpath("//input[@id='LastName']");
	By mgender= By.xpath("//input[@id='Gender_Male']");
	By fgender= By.xpath("//input[@id='Gender_Female']");
	By dob = By.xpath("//input[@id='DateOfBirth']");
	By companyname = By.xpath("//input[@id='Company']");
	By taxexempt= By.xpath("//input[@id='IsTaxExempt']");
	By newletter= By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
	By newletteroption =By.xpath("//span[normalize-space()='Test store 2']");
	By custrole= By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By roleadministartor= By.xpath("//span[normalize-space()='Administrators']");
	By rolemoderator= By.xpath("//span[normalize-space()='Forum Moderators']");
	By roleguest= By.xpath("//span[normalize-space()='Guests']");
	By roleregistered= By.xpath("//span[normalize-space()='Registered']");
	By rolevendor= By.xpath("//span[normalize-space()='Vendors']");
	By vendormanager= By.xpath("//select[@id='VendorId']");
	By activestatus= By.xpath("//input[@id='Active']");
	By addcomment= By.xpath("//textarea[@id='AdminComment']");
	
	By savebtn= By.xpath("//button[@name='save']");
	By saveandedit= By.xpath("//button[normalize-space()='Save and Continue Edit']");
	
	
	public AddCustomer(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomerMenu()
	{
		ldriver.findElement(customermenu).click();
	}
	public void clickCustomersOption()
	{
		ldriver.findElement(customeroption).click();
	}
	public String verifyAddCustPageTitle(String custpageTile )
	{
		return custpageTile;
	}
	public void addNewBtn()
	{
		ldriver.findElement(addnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtemial).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtpassword).sendKeys(password);
	}
	public void setFirstname(String firstname)
	{
		ldriver.findElement(fname).sendKeys(firstname);
	}
	public void setLatName(String lastname)
	{
		ldriver.findElement(lname).sendKeys(lastname);
	}
	public void setGender()
	{
		ldriver.findElement(mgender).click();
	}
	public void selectDob(String date)
	{
		ldriver.findElement(dob).sendKeys(date);
	}
	public void setComapanyName(String cname)
	{
		ldriver.findElement(companyname).sendKeys(cname);
	}
	public void selectTaxExempt()
	{
		ldriver.findElement(taxexempt).click();
	}
	public void setnewsLetter()
	{
		ldriver.findElement(newletter).click();
		ldriver.findElement(newletteroption).click();
	}
	public void selectCustomerRole(String role) throws InterruptedException
	{
		
		WebElement listItem= ldriver.findElement(custrole);
		Thread.sleep(3000);
	
		if(role.equals("Administrator"))
		{
			listItem =ldriver.findElement(roleadministartor);
		}
		else if(role.equals("Moderator"))
		{
			listItem= ldriver.findElement(rolemoderator);
		}
		
		else if(role.equals("Registored"))
		{
			listItem= ldriver.findElement(roleregistered);
		}
		else if(role.equals("Vendor"))
		{
			listItem= ldriver.findElement(rolevendor);
		}
		else 
			{
				//listItem= ldriver.findElement(roleguest);
			}
		listItem.click();
		
	}
	
	public void selectVendorManager(String manager) throws InterruptedException
	{
		Thread.sleep(3000);
		ele= ldriver.findElement(vendormanager);
		sel= new Select(ele);
		sel.selectByVisibleText(manager);
		
		
	}
	public void markActive()
	{
		ldriver.findElement(activestatus).click();
	}
	public void addCommnet(String comment)
	{
		ldriver.findElement(addcomment).sendKeys(comment);
	}
	
	 public void saveUser()
	 {
		 ldriver.findElement(savebtn).click();
	 }
	 
	 public void verifyConfirmationMessage()
	 {
		
		Assert.assertTrue(ldriver.findElement(By.tagName("body"))
				.getText().concat("The new customer has been added successfully."), false);
	 }
}
