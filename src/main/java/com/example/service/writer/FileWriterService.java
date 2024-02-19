package com.example.service.writer;

import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.util.FileWriterServiceUtil;

public class FileWriterService {
	
	public FileWriterServiceUtil readerUtil = new FileWriterServiceUtil();
	
	
	public void loadWorkbookFromFile(InputStream is) {		
		try {
			Workbook workbook = new Workbook(is);
			WorksheetCollection worksheets = workbook.getWorksheets();
			
			loopThroughWorksheets(worksheets);
//			readerUtil.writeToWorksheet(worksheets.get(0));

			workbook.save("AUGUSTO_GOODREADS_FINAL_77.xlsx");
		} catch (Exception e) {
			System.out.println("something failed");
			e.printStackTrace();
		}
	}
	
	public void loopThroughWorksheets(WorksheetCollection worksheets) {
		for (int sheetIndex = 0; sheetIndex < worksheets.getCount(); sheetIndex++) {
			Worksheet worksheet = worksheets.get(sheetIndex);
			// readerUtil.getSheetName(worksheet);	
			System.out.println();
			readerUtil.mapBookShelves(worksheet);			
		}	
	}
}
