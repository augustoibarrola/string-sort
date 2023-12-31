/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.aspose.cells.Cell;
import com.aspose.cells.Color;
import com.aspose.cells.Style;
import com.aspose.cells.TextAlignmentType;
import com.aspose.cells.Worksheet;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderServiceUtil {

	public void countSheetRows(Worksheet worksheet) {

		int worksheetRowCount = worksheet.getCells().getMaxDataRow();
		
	}

	public void getSheetName(Worksheet worksheet) {

		String worksheetName = worksheet.getName();
	}


	public void mapBookShelves(Worksheet worksheet) {
		
		int bookshelfIndex;
				
		for(int i = 0; i < worksheet.getCells().getMaxColumn(); i++ ) {			
			
			String columnName = worksheet.getCells().get(0, i).getStringValue();
			
			if(columnName.equals("Bookshelves")) 
				{
				
					bookshelfIndex = i;
					getBookShelves(bookshelfIndex, worksheet);
					break;			
				}
		}

	}
	
	
	public void getBookShelves(Integer bookshelfIndex, Worksheet worksheet) {
		
		HashSet<String> unsortedBookShelves = new HashSet<String>();
		List<String> bookshelves = new ArrayList<>();		
		
		for (int r = 0; r < worksheet.getCells().getMaxRow(); r++) Arrays.asList(
				worksheet.getCells().get(r, bookshelfIndex).getStringValue().split(", "))
				.forEach(unsortedBookShelves::add);
		
		unsortedBookShelves.forEach(bookshelves::add);
		Collections.sort(bookshelves);
		bookshelves.forEach(System.out::println);
		writeToWorksheet(bookshelfIndex, worksheet, bookshelves);
		markYesPerRow(bookshelfIndex, worksheet, bookshelves.size());
				
		
	}

	private void markYesPerRow(Integer bookshelfIndex, Worksheet worksheet, int numberOfShelves) {
		
		for(int r = 0; r < worksheet.getCells().getMaxRow(); r++) {
			
			scanColumnsForMatchingShelf(bookshelfIndex, worksheet, numberOfShelves, r);
			
		}
		
		
	}

	private void scanColumnsForMatchingShelf(Integer bookshelfIndex, Worksheet worksheet, int numberOfShelves, int r) {
		
		for(int c = 0; c < numberOfShelves; c++) {
			
			int shelfIterator = bookshelfIndex + c;
			
			Cell cell = worksheet.getCells().get(r, shelfIterator);
			
		}	
	}

	public void writeToWorksheet(Integer bookshelfIndex, Worksheet worksheet, List<String> bookshelves) {

//		worksheet.getCells().insertColumns(bookshelfIndex, ); // A until U exclusive
		
		for(int c = 0; c < bookshelves.size(); c++) {
			worksheet.getCells().insertColumn((bookshelfIndex + c));
			Cell cell = worksheet.getCells().get(0, (bookshelfIndex + c));
			cell.putValue(bookshelves.get(c));
			
			////////////////////////////////
			////////////////////////////////
			//Set style of a cell
	         Style style = cell.getStyle();
	         //Set background color
	         style.setBackgroundColor(Color.getYellow());
	         //Set format of a cell
	         style.getFont().setName("Courier New");
	         style.setVerticalAlignment(TextAlignmentType.TOP);
	          cell.setStyle(style);
		}
		
	}
	
	
	
	
	
//	public void 
	
//	  			8 1. get all the bookshelves in the bookshelves column.
//	  			9 2. get only unique values and delete any duplicates
//	 			10 3. sort those values in alphabetical order
//	 11 4. create new columns at the end of the sheet. as many new columns as the number of unique bookshelves
//	 12 5. for each row, create array of the cell under the bookshelves column
//	 13 6. go over each row's bookshelves array and look for each iterated bookshelf in the hashmap
//	 14 7. if the bookshelf is inside the hashmap, select that row's cell under the column that matches the
//	 15    name of the bookshelf found inside the hashmap.

}
