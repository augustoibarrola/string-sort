package com.example.service.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.example.util.WorksheetUtilities;

/**
 * @author augustoibarrola
 *
 */
public class WorksheetReaderService extends WorksheetUtilities{
	
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
		
		Integer bookTitleColumn = getColumnHeaderBookTitle(worksheet);
		Integer maxNumberOfRowsWithData = getMaxNumberOfRows(worksheet);
		
		//TODO - this is just for now; logic should be fleshed out to get author column when index isnt known
		Integer bookAuthorColumn = 2;
		Integer bookshelvesColumn = 16;
		
		for(int row = 1; row <= maxNumberOfRowsWithData; row++){
			String bookTitle = getBookTitle(worksheet, row, bookTitleColumn);
			String bookAuthor = getBookAuthor(worksheet, row, bookAuthorColumn);
			// List<String> titleBookshelves = getBookshelves(worksheet, row, bookshelvesColumn);
			List<String> titleBookshelves = sortBookshelves(worksheet, row, bookshelvesColumn);

			System.out.println(bookTitle +" by "+bookAuthor +", Bookshelves: " +titleBookshelves.toString());
		}
	}

	public String getBookTitle(Worksheet worksheet, Integer row, Integer column){
		return worksheet.getCells().get(row, column).getStringValue();
	}

	public String getBookAuthor(Worksheet worksheet, Integer row, Integer column){
		return worksheet.getCells().get(row, column).getStringValue();
	}

	public List<String> getBookshelves(Worksheet worksheet, Integer row, Integer column){
		String[] bookshelvesArray = worksheet.getCells().get(row, column).getStringValue().split(",");
		List<String> titleBookshelves = new ArrayList<>(Arrays.asList(bookshelvesArray));
		titleBookshelves.forEach(String::trim);
		return titleBookshelves;
	}

	public List<String> sortBookshelves(Worksheet worksheet, Integer row, Integer column){
		String[] bookshelvesArray = worksheet.getCells().get(row, column).getStringValue().split(", ");
		List<String> titleBookshelves = new ArrayList<>(Arrays.asList(bookshelvesArray));
		titleBookshelves = titleBookshelves.stream().sorted().collect(Collectors.toList());
		titleBookshelves.forEach(String::trim);
		return titleBookshelves;
	}
}
