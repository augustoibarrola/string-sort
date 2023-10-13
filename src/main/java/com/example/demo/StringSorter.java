package com.example.demo;


import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.example.service.reader.FileReaderService;

public class StringSorter {
	
	public FileReaderService fileReader;
	
	
	public StringSorter() {
	    System.out.println();	    
	    fileReader = new FileReaderService();
		InputStream is = getClass().getClassLoader().getResourceAsStream("AUGUSTO_GOODREADS_FINAL_77.xlsx");
	    
	    fileReader.loadWorkbookFromFile(is);	    
	    
	    try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
