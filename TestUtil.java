package com.sprint.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sprint.qa.base.TestBase;

import io.cucumber.messages.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 55;
	public static long IMPLICIT_WAIT = 20;
	
// public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
//       + "C:\Eclipse\eclipse-workspace\PresidioTest\src\PresidioTestData.xlsx"
	
	public static String TESTDATA_SHEET_PATH = "C:\\Eclipse\\eclipse-workspace\\SubscriptionsBDDPOMFramework\\src\\main\\java"
			+ "\\com\\subscription\\qa\\testdata\\SubscriptionTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getlastRowNum() + "---------" +
		//sheet.getRow(0).getlastCellNum());
		for (int i = 0 ; i < sheet.getLastRowNum(); i++) {
			for (int k = 0 ; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
	}	
}