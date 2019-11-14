package com.vtiger.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL 
{
	static FileInputStream fis;

	public static int getRow(String path, String sheet) {
		int rc = -1;

		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			rc = w.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rc;

	}
	public static int getCol(String path, String sheet)
	{
		int gc = -1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			gc = w.getSheet(sheet).getRow(0).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;

	}
	
	public static String getData(String path, String Sheet, int row, int col) {
		String value = "";
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			value = w.getSheet(Sheet).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}


}
