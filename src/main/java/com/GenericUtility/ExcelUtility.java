package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ExcelUtility {
	public String readDataFromExcel(String SheetName,int rowNo,int colNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNo);
		Cell col = row.getCell(colNo);
		String data = col.getStringCellValue();
		return data;
	}
	
	public void writeDataIntoExcel(String SheetName, int rowNo,int colNo,String value ) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNo);
		Cell col = row.getCell(colNo);
		col.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IPathConstants.excelPath);
		wb.write(fout);
		wb.close();
	}
	
	public int getRowCount(String SheetName) throws Throwable, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	public HashMap<String,String> getMultipleDataFromExcel(String SheetName, int colKey,int ColValue, WebDriver driver) throws Throwable, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(colKey).getStringCellValue();
			String value = sh.getRow(i).getCell(ColValue).getStringCellValue();
			map.put(key, value);	
		}
		
		for(Entry<String, String> s: map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
		return map;
	}

	public Object[][] getMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow+1][lastCell];
		
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		return obj;
		
	}
	
}
