package com.epam.preproduction.configuration;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.epam.preproduction.helpers.core.ExcelReader;

public class DataProviderLayer {
	@DataProvider()
	public static Object[][] readFromExcel(Method method) throws IOException {
		String fileName = getDataFileName(method);
		String sheetName = method.getName();
		ExcelReader read = new ExcelReader();
		return read.reader(fileName, sheetName);
	}

	private static String getDataFileName(Method method) {
		return PropertyReader.getInputExcelFileName()
				+ method.getDeclaringClass().getSimpleName() + ".xls";
	}
}
