package com.example.util;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public class WorksheetUtilities {	
	
	public String getWorksheetCollectionName(WorksheetCollection worksheet) { 
		return worksheet.getActiveSheetName(); 
	}

	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		return worksheet.getCells().getMaxDataRow();
	}
}