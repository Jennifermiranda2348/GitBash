package com.hrm.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author Jennifer
 */
public class ExcelUtility {
	/**
	 * This method is used to fetch data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.getStringCellValue();
		return data;
	}
	/**
	 * This method is used to write data into excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, FileNotFoundException, Throwable
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IPathconstants.excelPath);
		wb.write(fout);
		wb.close();		
	}
	/**
	 * This method will fetch the count of rows created in excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
	
	public HashMap<String,String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable
	{
		//Fetch data from excel
				FileInputStream fis1 = new FileInputStream(IPathconstants.excelPath);
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet(sheetName);
				int count = sh.getLastRowNum();
				
				//Enter valid data into mandatory field
				HashMap<String, String> map = new HashMap<String, String>(); //empty map
				for(int i=1;i<=count;i++)
				{
					String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
					String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
					map.put(key, value);
				}
				
				for(Entry<String, String> s:map.entrySet())
				{
					driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
				}
		return map;		
	}

	public Object[][] getMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathconstants.excelPath);
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
