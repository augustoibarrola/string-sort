package com.example.service.writer;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.util.WorksheetUtilities;

public class WorksheetWriterService extends WorksheetUtilities{
	
	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		return worksheet.getCells().getMaxDataRow();
	}
}
