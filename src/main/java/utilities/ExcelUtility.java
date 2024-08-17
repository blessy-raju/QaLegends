package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String getStringData(int rowNumber, int colNumber, String sheetName) {
		try {

			file = new FileInputStream("D:\\SeleniumAutomation\\QaLegends\\src\\test\\resources\\TestData.xlsx");
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNumber);
			XSSFCell column = row.getCell(colNumber);
			return column.getStringCellValue();
			
		} catch (Exception e) {
			throw new RuntimeException("Excel file not found");
		}
	}
	
	public static String getNumericData(int rowNumber, int colNumber, String sheetName) {
		try {

			file = new FileInputStream("D:\\SeleniumAutomation\\QaLegends\\src\\test\\resources\\TestData.xlsx");
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNumber);
			XSSFCell column = row.getCell(colNumber);
			int cellValue = (int) column.getNumericCellValue();
			return String.valueOf(cellValue);
			
		} catch (Exception e) {
			throw new RuntimeException("Excel file not found");
		}
	}

}
