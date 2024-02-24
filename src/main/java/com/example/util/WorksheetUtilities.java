package com.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public abstract class WorksheetUtilities {

	public WorksheetUtilities() {
		System.out.println("WorksheetUtilities instantiated...");
	}

	// public WorksheetUtilities(Worksheet worksheet) {
	// 	System.out.println("WorksheetUtilities instantiated...");
	// }

	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		return worksheet.getCells().getMaxDataRow();
	}

	//- [ ] these should be renamed, abstraced away from the idea of "Book"
	public String getBookTitle(Worksheet worksheet, Integer row, Integer column) {
		return worksheet.getCells().get(row, column).getStringValue();
	}

	//- [ ]  - 
	public String getBookAuthor(Worksheet worksheet, Integer row, Integer column) {
		return worksheet.getCells().get(row, column).getStringValue();
	}

	// public abstract List<String> getAllColumnHeaderNames(Worksheet worksheet);
		
	public List<String> getAllColumnHeaderNames(Worksheet worksheet){
		int maxNumberOfColumns = worksheet.getCells().getMaxDataColumn();
		List<String> worksheetColumnNames = new ArrayList<>(); 
		System.out.println("Column Names: ");
		for (int i = 0; i < maxNumberOfColumns; i++)
		{
			String columnName = worksheet.getCells().get(0, i).getStringValue();
			worksheetColumnNames.add(columnName);
		}
		return worksheetColumnNames;
	}	

	protected Integer getColumnHeaderBookTitle(Worksheet worksheet) {
		// this is just for now; the logic should be
		// fleshed out for situations in which
		// the index of 'Title' is not known.
		return 1;
	}
	protected Integer getColumnHeaderBookAuthor(Worksheet worksheet) {
		// this is just for now; the logic should be
		// fleshed out for situations in which
		// the index of 'Author' is not known.
		return 2;
	}
	public Integer getColumnHeaderBookshelves() {
		// this is just for now; the logic should be
		// fleshed out for situations in which
		// the index of 'Bookshelves' is not known.
		return 16;
	}
	protected Integer getColumnHeaderBookshelves(Worksheet worksheet) {
		// this is just for now; the logic should be
		// fleshed out for situations in which
		// the index of 'Bookshelves' is not known.
		return 16;
	}

	public List<String> sortBookshelves(Worksheet worksheet, Integer row, Integer column) {
		String[] bookshelvesArray = worksheet.getCells().get(row, column).getStringValue().split(", ");
		List<String> titleBookshelves = new ArrayList<>(Arrays.asList(bookshelvesArray));
		titleBookshelves = titleBookshelves.stream().sorted().collect(Collectors.toList());
		titleBookshelves.forEach(String::trim);
		return titleBookshelves;
	}
}