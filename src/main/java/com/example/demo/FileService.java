package com.example.demo;


import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;
import com.example.service.reader.FileReaderService;
import com.example.service.writer.FileWriterService;

public class FileService {
	
	private FileReaderService fileReader;
	private FileWriterService fileWriter;
	private InputStream fileInputStream;
	private WorksheetCollection worksheets;
	
	
	
	public void start(String filePath) {
	    
		fileReader = new FileReaderService();	
	    fileWriter = new FileWriterService();
	    fileInputStream = openInputStreamOfFile(filePath);
	    worksheets = loadWorksheetsFromInputStream(fileInputStream);
	}
	
	public void stop(InputStream fileInputStream) {
	    closeInputStreamOfFile(fileInputStream);  		
	}
	
	
	private WorksheetCollection loadWorksheetsFromInputStream(InputStream fileInputStream) {		
	    WorksheetCollection worksheets = fileReader.loadWorksheetCollectionFromInputStream(fileInputStream);
		return worksheets;
	}
	

	public InputStream openInputStreamOfFile(String file) { 
		return getClass().getClassLoader().getResourceAsStream(file); 
	}
	
	public void closeInputStreamOfFile(InputStream fileInputStream) {
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
