package com.example.dao;

import java.util.List;

import com.aspose.cells.Workbook;

public class WorkbookDAO {

	private Workbook workbook;
    private String fileName;
//    private List<String> worksheetCollection; 
    
    public WorkbookDAO(){}

    public WorkbookDAO(Workbook workbook){

    	this.workbook = workbook;
        this.fileName = workbook.getFileName();
    }
    
    public void getWorksheetCollection() {
    	
    }

}
