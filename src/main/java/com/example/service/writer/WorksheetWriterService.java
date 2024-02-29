package com.example.service.writer;

import java.util.ArrayList;
import java.util.List;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.util.WorksheetUtilities;

public class WorksheetWriterService extends WorksheetUtilities{

	public Worksheet worksheet; 

	public WorksheetWriterService(){}

	public WorksheetWriterService(Worksheet worksheet){
		this.worksheet = worksheet;
		System.out.println("I am "+this.worksheet.toString()+", the writer.");

	}
	
	public void setBookshelves(Worksheet worksheet, Integer row, Integer column, List<String> bookshelves){

		worksheet.getCells().get(row, column).setValue(bookshelves.toString());
		// System.out.println("setBookshelf");
				System.out.println(bookshelves.toString());


	}


}
