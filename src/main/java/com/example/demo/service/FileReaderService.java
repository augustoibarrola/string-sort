package com.example.demo.service;

import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderService {
	
	public FileReaderServiceUtil readerUtil = new FileReaderServiceUtil();
	
	
	public void loadWorkbookFromFile(InputStream is) {
		
		try {
			Workbook workbook = new Workbook(is);
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
			
			readerUtil.getSheetName(worksheet);			
			readerUtil.mapBookShelves(worksheet);
			
		}	
	}
	
	

	
	

}
