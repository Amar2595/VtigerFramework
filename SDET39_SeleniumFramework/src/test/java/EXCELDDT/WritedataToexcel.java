package EXCELDDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataToexcel {

	public static void main(String[] args) throws Throwable {
		// To Write and Read Get Data from Excel)
		System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		FileInputStream fis = new FileInputStream("./TestData/Write.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("Sheet1");
		 Row row = sheet.getRow(1);
		  Cell cell = row.getCell(4);
		  String cellvalueUrl = cell.getStringCellValue();
		  System.out.println(cellvalueUrl);
		   Cell cell1 = row.createCell(4);
		   cell1.setCellValue("rama");
		   FileOutputStream fos = new FileOutputStream("./TestData/Write.xlsx");
		   wb.write(fos);
		   wb.close();
		   
	}

}
