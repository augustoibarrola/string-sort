package com.example.util;

import com.aspose.cells.Worksheet;

public abstract class WorksheetUtilities {
	
	public void getSheetName(Worksheet worksheet) { String worksheetName = worksheet.getName(); }

	public void getMaxNumberOfRows(Worksheet worksheet) { int worksheetRowCount = worksheet.getCells().getMaxDataRow();}


}