package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parameterisation {
	
	private static Workbook workbook;
	private Sheet sheet;
	public static Object[][] readExcelData(String filePath,String sheetName) throws IOException {
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowCount][columnCount];
		for(int i=0;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<columnCount;j++) {
				XSSFCell cell=row.getCell(j);
				data[i][j]=cell.getStringCellValue();
			}
		}
		workbook.close();
		fis.close();
		return data;
		
	}

}
