package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	// define repository for page events
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement objuser;
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement objpass;
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement objlogin;

	//write method
	public void verifylogin(String username,String password)
	{
		objuser.sendKeys(username);
		objpass.sendKeys(password);
		objlogin.submit();
		
	}
	

}
