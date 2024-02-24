package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.WorksheetReaderService;
import com.example.service.writer.WorksheetWriterService;
import com.example.util.WorksheetUtilities;

public class WorksheetService {
	
	private WorksheetStreamHandler worksheetsStream;
	private WorksheetUtilities worksheetUtilities;
	private WorksheetWriterService fileWriter;
	private WorksheetReaderService fileReader;
	private WorksheetCollection worksheets;
	private Worksheet worksheet;
	

	public WorksheetService(){
		this.fileReader = new WorksheetReaderService();	
		this.fileWriter = new WorksheetWriterService();
	};


	public WorksheetService(String fileLocation){
		System.out.println("Getting Worksheet from resources..");
		this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
		this.worksheets = this.worksheetsStream.loadWorksheetCollectionFromInputStream();
		this.worksheet = this.worksheets.get(this.worksheets.getActiveSheetIndex());
		System.out.println("I am "+this.worksheet.toString()+", just born.");
		
		this.fileReader = new WorksheetReaderService(this.worksheet);	
		this.fileWriter = new WorksheetWriterService(this.worksheet);

		// System.out.println("Success. Worksheet \"" +this.worksheet.getName() + "\" at index " +this.worksheet.getIndex() + " from Worksheet Collection is now open.");
	};

	public void getWorksheetName(String bookshelfName) 
	{
		String worksheetName = fileReader.getActiveWorksheetName(this.worksheets);
		System.out.println("Worksheet's name is  " + worksheetName);
	}

	public void getWorksheetMaxNumberOfRows()
	{
		Integer worksheetMaxRowCount = fileReader.getMaxNumberOfRows(this.worksheet);	
		System.out.println("Worksheet has " +worksheetMaxRowCount+ " number of rows.");
	}
	
	public void getAllColumnNames(){
		fileReader.getAllColumnNames(this.worksheet);
	}

	public Map<Integer, List<String>>  getAllBooksAndTheirBookshelves(){
		Map<Integer, List<String>> allBookshelves = fileReader.getAllBooksAndTheirBookshelves(this.worksheet);
		return allBookshelves;
	}

	public void sortBookshelves(){
		Map<Integer, List<String>> allBookshelves = getAllBooksAndTheirBookshelves();
	}

}
