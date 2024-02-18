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
		getworkSheets(fileLocation);
	};

	private void getworkSheets(String fileLocation){
		this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
		this.worksheets = this.worksheetsStream.loadWorksheetCollectionFromInputStream();

	}

	public void getBooksinBookshelf(String bookshelfName) {}



}
