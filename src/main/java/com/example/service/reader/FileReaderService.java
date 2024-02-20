package com.example.service.reader;

import java.io.InputStream;

import com.aspose.cells.Worksheet;
import com.example.util.FileReaderServiceUtil;
import com.example.util.WorksheetUtilities;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderService extends WorksheetUtilities{
	
	public FileReaderServiceUtil readerUtil; 

	public void getAllColumnNames(Worksheet worksheet){
		int maxNumberOfColumns = worksheet.getCells().getMaxDataColumn();
		
		System.out.println("Column Names: ");
		for (int i = 0; i < maxNumberOfColumns; i++)
		{
			String columnName = worksheet.getCells().get(0, i).getStringValue();
			// System.out.println(columnName);
			String columnPosition = worksheet.getCells().get(0, i).getName();
			System.out.println( columnPosition + " : " + columnName);
		}
	}	

	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		return worksheet.getCells().getMaxDataRow();
	}

	public void getAllBooksAndTheirBookshelves(Worksheet worksheet){
		System.out.println("Getting all Book Titles and their Bookshelves...");
	}
}
