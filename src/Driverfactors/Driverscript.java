package Driverfactors;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import CommonFunctions.FuctionsLibrary;
import Utilities.ExcelFileUtil;
import config.APPutil;

public class Driverscript extends APPutil{
	String inputpath="C:\\Users\\glaxm\\eclipse-workspace\\DDT_Framework\\TestInput\\book.xlsx";
	String outputpath="C:\\Users\\glaxm\\eclipse-workspace\\DDT_Framework\\TestOutPut\\result.xlsx";
@Test
public void starttest()throws Throwable {
	//access excel methods
	ExcelFileUtil xl =new ExcelFileUtil(inputpath);

{
	int rc =xl.rowcount("login");
	int cc = xl.cellCount("login");
	Reporter.log("no of rows::"+rc+"   "+"no of cells::"+cc,true);
	for(int i = 1;i<=rc;i++)
// count no of rows
	{
	String user= xl.getcelldata("login", i, 0);
	String pass = xl.getcelldata("login", i, 1);
	// call login function library class
	boolean res=FuctionsLibrary.verifylogin(user, pass);
	if(res)
	{
		//if it is true write into results and status cell
		xl.setcelldata("login",i,2,"Login pass",outputpath);
	     xl.setcelldata("login", i, 3, "pass",outputpath );
	}
	else
	{
		@SuppressWarnings("unused")
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 xl.setcelldata("login", i,2, "Loginfail", outputpath);
		 xl.setcelldata("login", 1, 3, "fail", outputpath);
	}
	}
}
}
}


