package com.epam.preproduction.helpers.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader implements IReader {

	public Object[][] reader(String fileName, String sheetNumber) {

		Object[][] data = null;

		FileInputStream file = null;
		HSSFWorkbook workbook;
		HSSFSheet sheet = null;
		try {
			file = new FileInputStream(new File(fileName));
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheet(sheetNumber);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		HSSFRow row = sheet.getRow(0);

		int numberOfRows = sheet.getLastRowNum();
		int numberOfColumns = row.getLastCellNum();

		data = new Object[numberOfRows][numberOfColumns];

		for (int rowNum = 1; rowNum < numberOfRows + 1; rowNum++) {

			for (int cellNum = 0; cellNum < numberOfColumns; cellNum++) {

				Cell cell = sheet.getRow(rowNum).getCell(cellNum);

				if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {

					data[rowNum - 1][cellNum] = " ";

				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

					data[rowNum - 1][cellNum] = cell.getNumericCellValue();

				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

					data[rowNum - 1][cellNum] = cell.getStringCellValue();
				}
			}

		}

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}