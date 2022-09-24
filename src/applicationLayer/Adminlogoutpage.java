package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Adminlogoutpage {
@FindBy (xpath="//a[@id='welcome']")
WebElement clickwelcome;
@FindBy (xpath="//a[normalize-space()='Logout']")
WebElement clicklogout;

public void Adminlogout() throws Throwable
{
	clickwelcome.click();
	clicklogout.click();
	
}

}

