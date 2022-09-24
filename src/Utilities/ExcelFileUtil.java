package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	
	XSSFWorkbook wb;
	//Constructor for reading Excel file
	public ExcelFileUtil(String excelpath)throws Throwable
	{ 
		FileInputStream fi=new FileInputStream(excelpath);
		wb = new XSSFWorkbook(fi);
	}
	//counting no of rows
	public int rowcount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	//count no of cells in row
	public int cellCount(String Sheetname) {
		return wb.getSheet(Sheetname).getRow(0).getLastCellNum() ;
	}
		//read cell data
	public String getcelldata(String sheetname,int row ,int column)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(column).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
		{
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
		// write cell data
			public void setcelldata(String sheetname,int row,int column, String status,String writeexcelpath) throws Throwable {
	
		// get sheet from workbook
				XSSFSheet ws = wb.getSheet(sheetname);
					//get row from sheet
				XSSFRow rownum= ws.getRow(row);
				//create cell 
				XSSFCell cell =rownum.createCell(column);
				// write status 
				cell.setCellValue(status);
				if(status.equalsIgnoreCase("pass"))
				{
					XSSFCellStyle style = wb.createCellStyle();
					XSSFFont font = wb.createFont();
					font.setColor(IndexedColors.GREEN.getIndex());
					font.setBold(true);
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					style.setFont(font);
					ws.getRow(row).getCell(column).setCellStyle(style);
				}
				else if(status.equalsIgnoreCase("fail"))
				{
					XSSFCellStyle style =wb.createCellStyle();
					XSSFFont font = wb.createFont();
					font.setColor(IndexedColors.RED.getIndex());
					font.setBold(true);
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					style.setFont(font);
					ws.getRow(row).getCell(column).setCellStyle(style);
				}
					
			
			else if (status.equalsIgnoreCase("blocked"))
				
				{
				XSSFCellStyle style =wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.BLUE.getIndex());
				font.setBold(true);
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				style.setFont(font);
				ws.getRow(row).getCell(column).setCellStyle(style);
				}
				FileOutputStream fo=new FileOutputStream(writeexcelpath);
				wb.write(fo);
				
			}
		public static void main(String[] args) throws Throwable {
			ExcelFileUtil xl= new ExcelFileUtil("D://book2.xlsx");
			int rc =xl.rowcount("Login");
			int cc=xl.cellCount("Login");
			System.out.println(rc+"    "+cc);
			for(int i=1;i<=rc;i++)
			{
				String user =xl.getcelldata("Login", i, 0);
				String pass =xl.getcelldata("Login", i, 1);
				System.out.println(user+"    "+pass);
				xl.setcelldata("Login", i, 2, "pass", "D://book6.xlsx");
		}
}
			
		
		
			
			
	
	
	

		
	
	
		
	
		
	
	
		
		
	
	
		
	
	
		
		
		
					
		
		
		
		
		
		
   

	
	
		
	
	
	

}
