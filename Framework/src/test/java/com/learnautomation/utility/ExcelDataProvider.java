package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File file = new File("./TestData/TestData.xlsx");
		try
		{
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getStringData(int sheetindex,int rowno,int colno)
	{
		
		return wb.getSheetAt(sheetindex).getRow(rowno).getCell(colno).getStringCellValue();
	}

	public String getStringData(String sheetname,int rowno,int colno)
	{
		
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
	}
	
	public double getNumericData(String sheetname,int rowno,int colno){
		
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue();
	}
}
