package com.cast.vtiger.genericUtility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	public String GetDatafromExcel(String Sheetname,int Rowno,int cellno) throws Throwable {
		 FileInputStream fis = new FileInputStream("./TestData/ExcelData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(Sheetname);
		 Row row = sheet.getRow(Rowno);
		 Cell cell = row.getCell(cellno);
		 String data = cell.getStringCellValue();
		 return data;
	}
}
