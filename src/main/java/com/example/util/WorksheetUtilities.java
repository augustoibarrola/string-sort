package com.example.util;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public class WorksheetUtilities {	
	
	public String getWorksheetCollectionName(WorksheetCollection worksheet) { 
		return worksheet.getActiveSheetName(); 
	}

	// this really should be getting passed a 
	// Worksheet obj, not a WorksheetCollection
	// TODO getMaxNumberOfRows method should be passed Worksheet not WorksheetCollection
	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		// return worksheet.get(0).getCells().getMaxDataRow();

		return worksheet.getCells().getMaxDataRow();
	}

	public void loopThroughWorksheets(WorksheetCollection worksheets) {
		for (int sheetIndex = 0; sheetIndex < worksheets.getCount(); sheetIndex++) {
			Worksheet worksheet = worksheets.get(sheetIndex);
			// getSheetName(worksheet);	
			System.out.println();
			mapBookShelves(worksheet);			
		}	
	}

	public void mapBookShelves(Worksheet worksheet) {

		int bookshelfIndex;

		for (int i = 0; i < worksheet.getCells().getMaxColumn(); i++) {

			String columnName = worksheet.getCells().get(0, i).getStringValue();

			if (columnName.equals("Bookshelves")) {
				System.out.println("THIS IS THE BOOKSHELF COLUMN: ");
				bookshelfIndex = i;
				System.out.println("THIS IS THE BOOKSHELF COLUMN: " + i );
				// getBookShelves(bookshelfIndex, worksheet);
				break;
			}
		}

	}

}