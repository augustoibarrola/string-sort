package com.example.demo;


import java.io.InputStream;

import com.example.demo.service.FileReaderService;

public class StringSorter {
	
	public FileReaderService fileReader;
	
	
	public StringSorter() {

	    System.out.println();
	    
	    fileReader = new FileReaderService();
	    
		// Load the desired workbook file
		InputStream is = getClass().getClassLoader().getResourceAsStream("AUGUSTO_GOODREADS_FINAL.xlsx");
	    
	    fileReader.loadWorkbookFromFile(is);
	    
	}
	

}
