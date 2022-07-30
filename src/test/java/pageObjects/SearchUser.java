package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.LibraryWait2;

public class SearchUser {
	WebDriver ldriver;
	LibraryWait2 wait;
	
	@FindBy(xpath= "")
	WebElement customarPageTilte;
	
	 @FindBy(id="SearchEmail")
	 WebElement txtemail;
	 @FindBy(id="SearchFirstName")
	 WebElement fname;
	 
	 @FindBy(id="SearchLastName")
	 WebElement lname;
	 
	 @FindBy(id="SearchMonthOfBirth")
	 WebElement month;
	 
	 @FindBy(id="SearchDayOfBirth")
	 WebElement day;
	 @FindBy(id="SearchCompany")
	 WebElement compaanyname;
	 
	 @FindBy(xpath="//div[@role='listbox']")
	 WebElement custrole;
	 
	 @FindBy(id="search-customers")
	 WebElement searchbtn;
	 
	 @FindBy(xpath="div[@class='dataTables_scroll']//tbody")
	 WebElement userTable;
	 
	 @FindBy(xpath="//div[@class='dataTables_scroll']//tbody//tr")
	 List<WebElement> tableRows;
	 
	 @FindBy(xpath="//div[@class='dataTables_scroll']//tbody//tr/td")
	 List<WebElement> tableColumns;
	 
	 public SearchUser(WebDriver driver)
	 {
		 ldriver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void verifyCustomerPageTitle(String custPagetitle)
	 {
		String title=  ldriver.getTitle();
		Assert.assertEquals(custPagetitle, title);
	 }
	 public void setEmail(String email)
	 {
		 wait.visible(ldriver, txtemail, 20);
		 txtemail.clear();
		 txtemail.sendKeys(email); 
	 }
	 
	 public void clickSearchBtn()
	 {
		 wait.visible(ldriver, searchbtn, 20);
		 searchbtn.click();
	 }
	 
	 public int getNoOfRows()
	 {
		 return(tableRows.size());
	 }
	 
	 public int getNoOfColumns()
	 {
		 return(tableColumns.size());
	 }
	 
	 public boolean searchCustomerByEmail(String email)
	 {
		 boolean flag= false;
		 for(int i=1; i<=getNoOfRows();i++)
		 {
			 String emailid= userTable.findElement(By.xpath("//div[@class='dataTables_scroll']//tbody//tr["+i+"]/td[2]")).getText();
			 System.out.print(emailid);
			 if(emailid.equals(email))
			 {
				 flag= true;
				 //test runner
			 }
		 }
		
		return false;
		 
	 }
}
