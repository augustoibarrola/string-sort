package com.example.demo.util;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

/**
 * @author augustoibarrola
 *
 */
public class SortService {
	
	
	public void duh() {
	
		/*
		 * Load the desired workbook file
		 */
		Workbook workbook = new Workbook();
		
		/*
		 * Get all worksheets
		 */
		WorksheetCollection collection = workbook.getWorksheets();

		Worksheet worksheet = collection.get(0);
		
		  System.out.print("Worksheet: " + worksheet.getName());

		
		System.out.print("Worksheet: " + worksheet.getName());
		
	}
	

	
	

}
