package com.example.service.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.example.util.WorksheetUtilities;

/**
 * @author augustoibarrola
 *
 */
public class WorksheetReaderService extends WorksheetUtilities{

	Worksheet worksheet;

	public WorksheetReaderService(){}

	public WorksheetReaderService(Worksheet worksheet){
		this.worksheet = worksheet;
		System.out.println("I am "+this.worksheet.toString()+", the writer.");
	}
	
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

	public Map<Integer, List<String>> getAllBooksAndTheirBookshelves(Worksheet worksheet){
		System.out.println("Getting all Book Titles and their Bookshelves...");
		
		Map<Integer, List<String>> allBookshelves = new HashMap<>();
		
		Integer bookTitleColumn = getColumnHeaderBookTitle(worksheet);
		Integer maxNumberOfRowsWithData = getMaxNumberOfRows(worksheet);
		Integer bookAuthorColumn = getColumnHeaderBookAuthor(worksheet);
		Integer bookshelvesColumn = getColumnHeaderBookshelves(worksheet);
		
		for(int row = 1; row <= maxNumberOfRowsWithData; row++){
			String bookTitle = getBookTitle(worksheet, row, bookTitleColumn);
			String bookAuthor = getBookAuthor(worksheet, row, bookAuthorColumn);
			List<String> titleBookshelves = getBookshelves(worksheet, row, bookshelvesColumn);
			allBookshelves.put(row, titleBookshelves);
		}
		allBookshelves.forEach((row, bookshelf) -> System.out.println("Row "+ row +": "+ bookshelf.toString()));

		return allBookshelves;
	}

	public List<String> getBookshelves(Worksheet worksheet, Integer row, Integer column){
		String[] bookshelvesArray = worksheet.getCells().get(row, column).getStringValue().split(",");
		List<String> titleBookshelves = new ArrayList<>(Arrays.asList(bookshelvesArray));
		titleBookshelves.forEach(String::trim);
		return titleBookshelves;
	}
}
