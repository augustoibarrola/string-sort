package com.example.util;

import com.aspose.cells.Worksheet;

public abstract class WorksheetUtilities {
	
	public void getSheetName(Worksheet worksheet) { String worksheetName = worksheet.getName(); }

	public void maxNumberOfRows(Worksheet worksheet) { int worksheetRowCount = worksheet.getCells().getMaxDataRow();}


}
//