package com.example.service.writer;

import java.util.List;

import com.aspose.cells.Worksheet;
import com.example.util.WorksheetUtilities;

public class WorksheetWriterService extends WorksheetUtilities{

	public Worksheet worksheet; 

	public WorksheetWriterService(){}

	public WorksheetWriterService(Worksheet worksheet){
		this.worksheet = worksheet;
	}
	
	public void setBookshelves(Worksheet worksheet, Integer row, Integer column, List<String> bookshelves){

		// worksheet.getCells().get(row, column).setValue(bookshelves.toString());
		worksheet.getCells().get(row, column).setValue("FUUUUUCKKKK");
		// System.out.println("setBookshelf");
				System.out.println(bookshelves.toString());


	}


}
