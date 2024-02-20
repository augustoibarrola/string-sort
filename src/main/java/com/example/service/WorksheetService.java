package com.example.service;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.FileReaderService;
import com.example.service.writer.FileWriterService;
import com.example.util.WorksheetUtilities;

public class WorksheetService {
	
	private WorksheetStreamHandler worksheetsStream;
	private WorksheetUtilities worksheetUtilities;
	private FileWriterService fileWriter;
	private FileReaderService fileReader;
	private WorksheetCollection worksheets;
	private Worksheet worksheet;
	

	public WorksheetService(){
		this.fileReader = new FileReaderService();	
		this.fileWriter = new FileWriterService();
	};


	public WorksheetService(String fileLocation){
		this.fileReader = new FileReaderService();	
		this.fileWriter = new FileWriterService();

		System.out.println("Getting Worksheet from resources..");
		this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
		this.worksheets = this.worksheetsStream.loadWorksheetCollectionFromInputStream();
		this.worksheet = this.worksheets.get(this.worksheets.getActiveSheetIndex());
		System.out.println("Success. Worksheet \"" +this.worksheet.getName() + "\" at index " +this.worksheet.getIndex() + " from Worksheet Collection is now open.");
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
}
