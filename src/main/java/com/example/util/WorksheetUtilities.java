package com.example.util;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public abstract class WorksheetUtilities {	
	
	public String getActiveWorksheetName(WorksheetCollection worksheet) { 
		return worksheet.getActiveSheetName(); 
	}

	public abstract Integer getMaxNumberOfRows(Worksheet worksheet);

	protected Integer getColumnHeaderBookTitle(Worksheet worksheet){
		// this is just for now; the logic should be 
		// fleshed out for situations in which
		// the index of 'Title' is not known. 
		return 1 ;
	}
}