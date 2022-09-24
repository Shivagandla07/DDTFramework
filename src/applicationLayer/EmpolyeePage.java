package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class EmpolyeePage {

WebDriver driver;
// constructor to override driver methods
public EmpolyeePage(WebDriver driver)
{
	this.driver=driver;
}
//define repastory
@FindBy(xpath="//b[normalize-space()='PIM']")
WebElement clickpim;
@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
WebElement clickadd;
@FindBy(name="firstName")
WebElement fname;
@FindBy(id="middleName")
WebElement Mname;
@FindBy(name="lastName")
WebElement Lname;
@FindBy(xpath="//input[@id='employeeId']")
WebElement beforeempid;
@FindBy(id="btnSave")
WebElement savebttn;
@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
WebElement afterempid;

public  boolean verifyEmpolyeepaageAdd(String firstName, String middleName,String lastName)
{
	Actions ac=new Actions(driver);
	ac.moveToElement(this.clickpim).click().perform();
	 ac.moveToElement(this.clickadd).click().perform();
	 this.fname.sendKeys(firstName);
	 this.Mname.sendKeys(middleName);
	 this.Lname.sendKeys(lastName);
	 String expectedid=this.beforeempid.getAttribute("value");
	 ac.moveToElement(savebttn).click().perform();
	 String Actualeid= this.afterempid.getAttribute("value");
	 if(expectedid.equals(Actualeid))
	 {
		 Reporter.log("emp creation is success::"+expectedid+"          "+Actualeid,true);
		 return true;
	 }
	 else
	 {
		 Reporter.log("emp creation is fail::"+expectedid+"          "+Actualeid,true);
		 return false;
	 }
	 
}
}
