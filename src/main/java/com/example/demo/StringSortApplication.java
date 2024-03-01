package com.example.demo;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aspose.cells.Workbook;
import com.example.service.WorksheetService;

@SpringBootApplication
public class StringSortApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StringSortApplication.class, args);
		
		FileInputStream file = new FileInputStream(new File("src/main/resources/GOODREADS_DATA.xlsx"));
		Workbook workbook = new Workbook(file);
		String workBookActiveSheetName = workbook.getWorksheets().getActiveSheetName();
		System.out.println(workBookActiveSheetName);

	}
}
