package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.FileService;

@SpringBootApplication
public class StringSortApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringSortApplication.class, args);
		
		FileService fileService = new FileService("AUGUSTO_GOODREADS_DATA.xlsx");
		
		fileService.getWorksheetMaxNumberOfRows();

//		fileService.stop();
	}
}
