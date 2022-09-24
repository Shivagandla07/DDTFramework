package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class APPutil {
	public static WebDriver driver;
	public static Properties config;
	
@BeforeTest
public static void setup()throws Throwable
{
	config=new Properties();
	config.load(new FileInputStream("C:\\Users\\glaxm\\eclipse-workspace\\DDT_Framework\\PropertyFile\\Environment.properties"));
	if(config.getProperty("browser").equalsIgnoreCase("chrome"))
	{

	driver=new ChromeDriver();
	driver.manage().window().maximize();
} 
 else if (config.getProperty("browser").equalsIgnoreCase("firefox"))
 {
	 driver =new FirefoxDriver();
 }
 else
	{
		System.out.println("browser value not matching");
	}
}
@AfterTest
public static void teardown()
{
	driver.close();
}
}

	

 

	



