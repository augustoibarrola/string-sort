package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.WorksheetService;

@SpringBootApplication
public class StringSortApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringSortApplication.class, args);
		
		WorksheetService worksheetService = new WorksheetService("GOODREADS_DATA.xlsx");
		
		// worksheetService.getAllColumnNames();
		worksheetService.sortBookshelves();
		worksheetService.closeWorksheet();

//		fileService.stop();
	}
}
