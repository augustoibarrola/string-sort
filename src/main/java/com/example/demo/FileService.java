package com.example.demo;


import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.FileReaderService;
import com.example.service.writer.FileWriterService;

public class FileService {
	
	private WorksheetStreamHandler worksheetsStream;
	private FileWriterService fileWriter;
	private FileReaderService fileReader;
	private WorksheetCollection worksheets;
	

	public FileService(){
		this.fileReader = new FileReaderService();	
		this.fileWriter = new FileWriterService();
	};


	public FileService(String fileLocation){
		this.fileReader = new FileReaderService();	
		this.fileWriter = new FileWriterService();
		this.worksheets  = getworkSheets(fileLocation);
		// this.worksheets  = worksheetsStream.getWorkSheetStream(this.worksheetsStream);
	};

	private void getworkSheets(String fileLocation){
		this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
		this.worksheets = loadWorksheetCollectionFromInputStream(this.worksheetsStream);

	}

	public void getBooksinBookshelf(String bookshelfName) {}

	public WorksheetCollection loadWorksheetCollectionFromInputStream(InputStream is) {	
		try {
			
			Workbook workbook = new Workbook(is);
			WorksheetCollection worksheets = workbook.getWorksheets();
			
			return worksheets;
			
		} catch (Exception e) {
			System.out.println("something failed");
			e.printStackTrace();
			return null;
		}
		
		
	}
	public void closeInputStream() {
		try {
			this.worksheetStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
