package com.example.service.handler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Paths;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;

public class WorksheetStreamHandler {

    //? 
    private InputStream worksheetStream;

    public WorksheetStreamHandler() {
    };

    public WorksheetStreamHandler(String fileLOcation) {
        this.worksheetStream = openInputStreamOfFile(fileLOcation);
        System.out.println("Worksheet Stream Opened");
    }

    public InputStream openInputStreamOfFile(String fileLocation) {
        return getClass().getClassLoader().getResourceAsStream(fileLocation);
    }

    public void closeInputStream() {        
        try {
            this.worksheetStream.close();
        } catch (IOException e) {
            e.printStackTrace();
    }
}

public Workbook loadWorkbookFromInputStream(String fileLocation){

ClassLoader classLoader = getClass().getClassLoader();
 String path  = classLoader.getResource(fileLocation).getPath();
 System.out.println(path);

    File file = new File(path);
    // String absolutePath = file.getAbsolutePath();
    Workbook workbook;
    try {
        workbook = new Workbook(file.getPath());
        return workbook;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    public WorksheetCollection loadWorksheetCollectionFromInputStream() {
        try {
            System.out.println("Loading WorksheetCollectionFromInputStream from worksheetStream");
            Workbook workbook = new Workbook(this.worksheetStream);
            WorksheetCollection worksheets = workbook.getWorksheets();
            return worksheets;
        } catch (Exception e) {
            System.out.println("something failed");
            e.printStackTrace();
            return null;
        }
    }
}
