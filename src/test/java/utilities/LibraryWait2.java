package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryWait2 {
    WebDriverWait lwait;
	
	public void visible(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
		
	}
}
