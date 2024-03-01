package com.example.dao;

import com.aspose.cells.Workbook;

public class WorkbookDAO {

    private String fileName;
    
    public WorkbookDAO(){}

    public WorkbookDAO(Workbook workbook){

        this.fileName = workbook.getFileName();
    }

}
