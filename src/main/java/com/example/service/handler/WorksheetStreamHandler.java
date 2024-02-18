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
        this.worksheetStream = openInputStreamOfFile(fileLOcation);
    }

    public InputStream openInputStreamOfFile(String fileLocation) { 
        return getClass().getClassLoader().getResourceAsStream(fileLocation);
   }
    
   public WorksheetCollection loadWorksheetCollectionFromInputStream() {	
    try {
        
        Workbook workbook = new Workbook(this.worksheetStream);
        WorksheetCollection worksheets = workbook.getWorksheets();
        
        return worksheets;
        
    } catch (Exception e) {
        System.out.println("something failed");
        e.printStackTrace();
        return null;
    }
    
    
}
public void closeInputStream() {
    try {
        this.worksheetStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    




}
