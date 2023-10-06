package com.example.demo.util;

import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

/**
 * @author augustoibarrola
 *
 */
public class SortService {
	
	
	public void duh() {
	

		// Load the desired workbook file
		InputStream is = getClass().getClassLoader().getResourceAsStream("AUGUSTO_GOODREADS_FINAL.xlsx");

		
		
		try {
			Workbook workbook = new Workbook(is);
			
			// get all the worksheets in the loaded workbook
			WorksheetCollection worksheets = workbook.getWorksheets();
			
			loopThroughWorksheets(worksheets);
			
			

			
		} catch (Exception e) {
			System.out.println("something failed");
			e.printStackTrace();
		}
		


		
	}
	
	public void loopThroughWorksheets(WorksheetCollection worksheets) {
		
		
		for (int sheetIndex = 0; sheetIndex < worksheets.getCount(); sheetIndex++) {
			
			Worksheet worksheet = worksheets.get(sheetIndex);
			
			System.out.println("WORKSHEET NAME : "+ worksheet.getName());
			
			int worksheetRowCount = worksheet.getCells().getMaxDataRow();
			
			System.out.print(worksheetRowCount);
			
		}
		
	}
	

	
	

}
