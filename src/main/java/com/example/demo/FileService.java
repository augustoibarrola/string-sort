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
	
	
	public FileService() {    
	    fileReader = new FileReaderService();	
	    fileWriter = new FileWriterService();
	    fileInputStream = loadFile();
	    worksheets = loadWorksheets();
	    
	    
	    
	    closeFile(fileInputStream);
	    

	}
	

	public InputStream loadFile() { return getClass().getClassLoader().getResourceAsStream("AUGUSTO_GOODREADS_FINAL_77.xlsx"); }
	
	public void closeFile(InputStream fileInputStream ) {
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	private WorksheetCollection loadWorksheets() {		
	    InputStream fileInputStream = loadFile();
	    WorksheetCollection worksheets = fileReader.loadWorkbookFromFile(fileInputStream);
		return worksheets;
	}
	

}
