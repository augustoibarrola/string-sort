package com.example.service.handler;

import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;
import com.example.service.reader.FileReaderService;

public class WorksheetStreamHandler {

    private InputStream worksheetStream;

    public WorksheetStreamHandler(){};

    public WorksheetStreamHandler(String fileLOcation){
        this.worksheetStream = getWorkSheetStream(fileLOcation);
    }
    
    public InputStream getWorkSheetStream(String fileLocation) {	
        InputStream worksheetStream = openInputStreamOfFile(fileLocation);
        return worksheetStream;
    }
    
    public void getWorkSheetStream(InputStream worksheetsStream) {	
        // loadWorksheetCollectionFromInputStream(worksheetsStream);
    }


    public InputStream openInputStreamOfFile(String fileLocation) { 
    return getClass().getClassLoader().getResourceAsStream(fileLocation);



    




}
