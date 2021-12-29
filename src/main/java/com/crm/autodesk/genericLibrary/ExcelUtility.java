package com.crm.autodesk.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Class which has all excel sheet method
 * @author Bharath Vepanjeri
 *
 */


public class ExcelUtility 
{

     /**
      * 	It is used to read/write data from Excel sheet 
      * @param sheetName
      * @param rowNum
      * @param cellNum
      * @return returns data in string form
     * @throws Exception 
      * @throws EncryptedDocumentException
      * @throws IOException
      */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception 
	{
		FileInputStream fil=new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	
	/**
	 * It is used to get last used row number on the sheet
	 * @param sheetName
	 * @return rowNumber in integer type
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws Exception 
	{

		FileInputStream fil=new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * It is used to write data in Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Exception 
	{
		FileInputStream fis  = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
