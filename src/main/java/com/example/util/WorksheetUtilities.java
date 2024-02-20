package com.example.util;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public abstract class WorksheetUtilities {	
	
	public String getActiveWorksheetName(WorksheetCollection worksheet) { 
		return worksheet.getActiveSheetName(); 
	}

	public abstract Integer getMaxNumberOfRows(Worksheet worksheet);
}