package com.example.demo;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aspose.cells.Workbook;
import com.example.dao.WorkbookDAO;
import com.example.util.WorkbookUtilities;

@SpringBootApplication
public class StringSortApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StringSortApplication.class, args);
		
		FileInputStream file = new FileInputStream(new File("src/main/resources/GOODREADS_DATA.xlsx"));
		
		Workbook workbook = new Workbook(file);
		WorkbookDAO workbookDao = new WorkbookDAO(workbook);
		

		WorkbookUtilities workbookUtilities = new WorkbookUtilities(workbook);		
		


		workbookUtilities.getNameOfActiveWorkSheet();
		workbookUtilities.sortWorkbookWorksheet();
//		workbook.save("src/main/resources/GOODREADS_DATA.xlsx");
		

	}
}
