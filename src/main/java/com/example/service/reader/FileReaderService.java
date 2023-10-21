package com.example.service.reader;

import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderService {
	
	public FileReaderServiceUtil readerUtil; 
	

	
	public FileReaderService() {};
	
	
	public WorksheetCollection loadWorkbookFromFile(InputStream is) {	
		try {
			Workbook workbook = new Workbook(is);
			WorksheetCollection worksheets = workbook.getWorksheets();
			
			return worksheets;
			
		} catch (Exception e) {
			System.out.println("something failed");
			e.printStackTrace();
			return null;
		}
		

		
	}
	
	public void loopThroughWorksheets(WorksheetCollection worksheets) {
		
		for (int sheetIndex = 0; sheetIndex < worksheets.getCount(); sheetIndex++) {
			
			Worksheet worksheet = worksheets.get(sheetIndex);
			
			readerUtil.getSheetName(worksheet);	
			System.out.println();
			readerUtil.mapBookShelves(worksheet);			
		}	
	}
	
	

	
	

}
