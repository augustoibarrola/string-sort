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
		
		//1. find the index of the Book Title Column
		Integer bookTitleColumn = getColumnHeaderBookTitle(worksheet);
		//TODO - this is just for now; logic should be fleshed out to get author column when index isnt known
		Integer bookAuthorColumn = 2;
		
		//2. find the max number of books in the sheet
		Integer maxNumberOfRowsWithData = getMaxNumberOfRows(worksheet);
		
		//loop down the worksheet
		// we're starting at 1 since 0 would be 
		// row with the column headers. 
		for(int row = 1; row <= maxNumberOfRowsWithData; row++){
			
			String bookTitle = getBookTitle(worksheet, row, bookTitleColumn);
			String bookAuthor = getBookAuthor(worksheet, row, bookAuthorColumn);
			
			System.out.println(bookTitle +" by "+bookAuthor);
		}
	}

	public String getBookTitle(Worksheet worksheet, Integer row, Integer column){
		return worksheet.getCells().get(row, column).getStringValue();
	}

	public String getBookAuthor(Worksheet worksheet, Integer row, Integer column){
		return worksheet.getCells().get(row, column).getStringValue();
	}

}
