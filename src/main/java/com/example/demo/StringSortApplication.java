package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringSortApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringSortApplication.class, args);
		
		// String fileLocation = "AUGUSTO_GOODREADS_FINAL_77.xlsx";
		String bookshelfName = "Bookshelves";
		
		FileService fileService = new FileService("AUGUSTO_GOODREADS_FINAL_77.xlsx");
		
		fileService.getBooksinBookshelf(bookshelfName);
		
//		fileService.stop();
	}
}
