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
				
		for(int i = 0; i < worksheet.getCells().getMaxColumn(); i++ ) {			
			
			String columnName = worksheet.getCells().get(0, i).getStringValue();
			
			if(columnName.equals("Bookshelves")) getBookShelves(i, worksheet);
		}

	}
	
	
	public void getBookShelves(int i, Worksheet worksheet) {
		
		HashSet<String> unsortedBookShelves = new HashSet<String>();
		List<String> bookshelves = new ArrayList<>();		
		
		for (int r = 0; r < worksheet.getCells().getMaxRow(); r++) Arrays.asList(
				worksheet.getCells().get(r, i).getStringValue().split(", "))
				.forEach(unsortedBookShelves::add);
		
		unsortedBookShelves.forEach(bookshelves::add);
		Collections.sort(bookshelves);
		bookshelves.forEach(System.out::println);
		
	}
	
	public void addBookshelvesToWorksheet(List<String> bookshelves) {
		
		
		
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
