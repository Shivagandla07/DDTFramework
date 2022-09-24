package Driverfactors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationLayer.AdminLoginPage;
import applicationLayer.Adminlogoutpage;
import applicationLayer.EmpolyeePage;

public class TestScript {
	WebDriver driver;
@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
	login.verifylogin("Admin", "Qedge123!@#");
}
@Test
public void empolyeecreation()
{
 EmpolyeePage emp =PageFactory.initElements(driver,EmpolyeePage.class);
 boolean ses=emp.verifyEmpolyeepaageAdd("shiva", "gandla", "tester");
 System.out.println(ses);
 
}
@AfterTest
public void teardown() throws Throwable
{
	Adminlogoutpage logout=PageFactory.initElements(driver, Adminlogoutpage .class);
	logout.Adminlogout();
	driver.close();
}

}
