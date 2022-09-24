package CommonFunctions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;

import config.APPutil;
public class FuctionsLibrary extends APPutil {
	//method for login
	public static boolean verifylogin(String username,String password)
	{
		driver.get(config.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(config.getProperty("user"))).sendKeys(username );
		driver.findElement(By.xpath(config.getProperty("pass"))).sendKeys(password );
		driver.findElement(By.xpath(config.getProperty("login"))).submit();
		String expected="dashboard";
		String actual= driver.getCurrentUrl();
		if(actual.contains(expected)) {
			Reporter.log("Login success::"+expected+"        "+actual,true);
			return true;
		}
		else
		{
			//capture error message
			String errormesage= driver.findElement(By.xpath(config.getProperty("errormessage"))).getText();
			Reporter.log(errormesage+"       "+expected+"      "+actual,true);
			return false;
		}
				

	}
}
