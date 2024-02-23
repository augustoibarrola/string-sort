package com.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public abstract class WorksheetUtilities {

	public Worksheet worksheet;

	public WorksheetUtilities() {
	}

	public WorksheetUtilities(Worksheet worksheet) {
		System.out.println("WorksheetUtilities instantiated...");
	}

	public String getBookTitle(Worksheet worksheet, Integer row, Integer column) {
		return worksheet.getCells().get(row, column).getStringValue();
	}

	public String getBookAuthor(Worksheet worksheet, Integer row, Integer column) {
		return worksheet.getCells().get(row, column).getStringValue();
	}

	public String getActiveWorksheetName(WorksheetCollection worksheet) {
		return worksheet.getActiveSheetName();
	}

	public Integer getMaxNumberOfRows(Worksheet worksheet) { 
		return worksheet.getCells().getMaxDataRow();
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