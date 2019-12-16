package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book;
	public static Sheet sheet;//import from apache.poi.ss
	
	public static String TEST_DATA_SHEET_PATH ="C:\\Users\\chetn\\workspace\\HubSpotPOMSeries\\"
			+ "src\\main\\java\\com\\qa\\hubspot\\testdata\\HubspotEXC.xlsx";// location of the excel file fr testdata pkg
	
	public static Object[][] getTestDate(String sheetName){
		
		FileInputStream file = null;// we are making a global by making it null point. so we can used it with apache poi
		
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sheet = book.getSheet(sheetName);
		//3stpes here 1. fileinutstream to add the file, 2 workbookfactory.create from apache poi, 3 .getsheet
		
		Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];// two dim array
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	

}
