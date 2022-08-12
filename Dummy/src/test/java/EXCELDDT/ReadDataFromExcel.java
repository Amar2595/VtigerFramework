package EXCELDDT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.cast.vtiger.genericUtility.Excel_utility;



public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
/*
 * FileInputStream fis = new FileInputStream("./TestData/ExcelData.xlsx");
 * Workbook wb = WorkbookFactory.create(fis);
 * 
 * Sheet sheet = wb.getSheet("Sheet1"); Row row = sheet.getRow(1); Cell cell =
 * row.getCell(0); String cellvalueUrl = cell.getStringCellValue();
 */
Excel_utility eu = new Excel_utility();
String text = eu.GetDatafromExcel("Sheet1", 1, 0);
System.out.println(text);
	}

}
