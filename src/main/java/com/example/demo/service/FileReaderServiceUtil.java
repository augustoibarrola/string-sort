/**
 * 
 */
package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.aspose.cells.Worksheet;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderServiceUtil {

	public void countSheetRows(Worksheet worksheet) {

		int worksheetRowCount = worksheet.getCells().getMaxDataRow();
		
		System.out.print(worksheetRowCount);
		
	}

	public void getSheetName(Worksheet worksheet) {

		String worksheetName = worksheet.getName();
		
		System.out.println("WORKSHEET NAME : "+ worksheetName);
	}


	public void mapColumnNames(Worksheet worksheet) {
		
		Map<Integer, String> mappedColumnNames = new HashMap<>();
		
		for(int i = 0; i < worksheet.getCells().getMaxColumn(); i++ ) {			
			String columnName = worksheet.getCells().get(0, i).getStringValue();
			mappedColumnNames.put(i, columnName);
//			System.out.println(i + " :  " + columnName);
		}

	}

}
