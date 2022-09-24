package Driverfactors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;
import applicationLayer.AdminLoginPage;
import applicationLayer.Adminlogoutpage;
import applicationLayer.EmpolyeePage;
public class DriverscriptPOM {
	WebDriver driver;
	String inputpath="C:\\Users\\glaxm\\eclipse-workspace\\DDT_Framework\\TestInput\\puspha 1.xlsx";
	String outputpath="C:\\Users\\glaxm\\eclipse-workspace\\DDT_Framework\\TestOutPut\\pusphareview.xlsx";
	@BeforeTest
	public void setup()throws Throwable{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
		login.verifylogin("Admin", "Qedge123!@#");
	}
		@Test
		public void starttest()throws Throwable {
			ExcelFileUtil xl = new ExcelFileUtil(inputpath);
			int rc=xl.rowcount("pusha1");
			for(int i= 1;i<=rc;i++) {
				String para1=xl.getcelldata("pusha1", i, 0);
				String para2=xl.getcelldata("pusha1", i, 1);
				String para3=xl.getcelldata("pusha1" ,i, 2);
				EmpolyeePage emp=PageFactory.initElements(driver,EmpolyeePage.class );
				boolean sir=emp.verifyEmpolyeepaageAdd(para1, para2, para3);
				if(sir) {
					xl.setcelldata("pusha1", i, 3,"hit", outputpath);
					
				}
				else
				{
					xl.setcelldata("pusha1", i, 3,"flop", outputpath);
				}
			}
		}
				@AfterTest
				public void teardown() throws Throwable{
					Adminlogoutpage logout=PageFactory.initElements(driver, Adminlogoutpage.class);
					logout.Adminlogout();
					driver.close();
				}

	
				
				
					
				
			
			
			
			
			
			
			
			
			
			

			
			
		}


	


