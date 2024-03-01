package com.example.service.handler;

import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;

public class WorksheetStreamHandler {

    private InputStream worksheetStream;

    public WorksheetStreamHandler() {
    };

    public WorksheetStreamHandler(String fileLOcation) {
        this.worksheetStream = openInputStreamOfFile(fileLOcation);
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

    public Workbook loadWorkbookFromInputStream(WorksheetStreamHandler worksheetsStream) {
        try {
            Workbook workbook = new Workbook(this.worksheetStream);
            System.out.println(workbook);
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public WorksheetCollection loadWorksheetCollectionFromInputStream() {
        try {
            Workbook workbook = new Workbook(this.worksheetStream);
            WorksheetCollection worksheets = workbook.getWorksheets();
            return worksheets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
