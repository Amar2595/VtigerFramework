package EXCELDDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchdatafromExcelByforloop {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("Sheet1");
		 int count = sheet.getLastRowNum();
		 for(int i=0; i<count ; i++);
		 Row row = sheet.getRow(1);
		   Cell cell = row.getCell(0);
		 String cellvalueUrl = cell.getStringCellValue();
		 System.out.println(cellvalueUrl);
			}
	}

