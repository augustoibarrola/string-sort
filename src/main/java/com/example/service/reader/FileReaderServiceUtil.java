package com.example.service.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.aspose.cells.Cell;
import com.aspose.cells.Worksheet;
import com.example.util.WorksheetUtilities;

/**
 * @author augustoibarrola
 *
 */
public class FileReaderServiceUtil extends WorksheetUtilities {

	public void mapBookShelves(Worksheet worksheet) {

		int bookshelfIndex;

		for (int i = 0; i < worksheet.getCells().getMaxColumn(); i++) {

			String columnName = worksheet.getCells().get(0, i).getStringValue();

			if (columnName.equals("Bookshelves")) {

				bookshelfIndex = i;
				getBookShelves(bookshelfIndex, worksheet);
				break;
			}
		}

	}

	public void getBookShelves(Integer bookshelfIndex, Worksheet worksheet) {

		HashSet<String> unsortedBookShelves = new HashSet<String>();
		List<String> bookshelves = new ArrayList<>();

		for (int r = 0; r < worksheet.getCells().getMaxRow(); r++)
			Arrays.asList(
					worksheet.getCells().get(r, bookshelfIndex).getStringValue().split(", "))
					.forEach(unsortedBookShelves::add);

		unsortedBookShelves.forEach(bookshelves::add);
		Collections.sort(bookshelves);
		bookshelves.forEach(System.out::println);
		// writeToWorksheet(bookshelfIndex, worksheet, bookshelves);

		markYesPerRow(bookshelfIndex, worksheet, bookshelves.size());

	}

	private void markYesPerRow(Integer bookshelfIndex, Worksheet worksheet, int numberOfShelves) {
		for (int r = 0; r < worksheet.getCells().getMaxRow(); r++) {
			scanColumnsForMatchingShelf(bookshelfIndex, worksheet, numberOfShelves, r);
		}

	}

	private void scanColumnsForMatchingShelf(Integer bookshelfIndex, Worksheet worksheet, int numberOfShelves, int row) {
		for (int c = 0; c < numberOfShelves; c++) {
			int shelfIterator = bookshelfIndex + c;
			Cell cell = worksheet.getCells().get(row, shelfIterator);
		}
	}	
}
