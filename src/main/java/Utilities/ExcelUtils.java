package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
//	private static Workbook wb;

//	@Test
	public static String exceldata1(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/login.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		return wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	}
public static Object[][] exceldata2(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream file=new FileInputStream("./src/test/resources/login.xlsx");
	Workbook wd = WorkbookFactory.create(file);
	Sheet sheet = wd.getSheet(sheetname);
	int rows=sheet.getPhysicalNumberOfRows();
	int cell=sheet.getRow(0).getPhysicalNumberOfCells();
	Object[][] ob=new Object[rows-1][cell];
	for (int i = 1; i <rows; i++) {
		for (int j = 0; j <cell; j++) {
			
		ob[i-1][j]=	sheet.getRow(i).getCell(j).toString();
		}
	}
	 //wb.close();
     //file.close();
     return ob;
}
	
//optional to set value
//	public static void setCellData(String sheetName, int row, int cell, String value) throws IOException {
//		FileInputStream file = new FileInputStream("./src/test/resources/login.xlsx");
//		wb = WorkbookFactory.create(file);
//		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
//		FileOutputStream out = new FileOutputStream("./src/test/resources/login.xlsx");
//		wb.write(out);
//		out.close();
//	}
}
