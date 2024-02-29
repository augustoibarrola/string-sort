package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.aspose.cells.Cell;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.WorksheetReaderService;
import com.example.service.writer.WorksheetWriterService;
import com.example.util.WorksheetUtilities;

public class WorksheetWrapper{
    
    private WorksheetStreamHandler worksheetsStream;
	private WorksheetCollection workSheetCollection;
    private Workbook workbook;
	private Worksheet worksheet;
	private WorksheetWriterService fileWriter;
	private WorksheetReaderService fileReader;

    private Integer currentRowIndex;
    private Integer maxRows;


    public WorksheetWrapper(){};
    public WorksheetWrapper(String fileLocation ){
        this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
        this.workbook = this.worksheetsStream.loadWorkbookFromInputStream(fileLocation);
        // this.workSheetCollection = this.worksheetsStream.loadWorksheetCollectionFromInputStream();
        // this.worksheet = this.workSheetCollection.get(this.workSheetCollection.getActiveSheetIndex());
        this.worksheet = this.workbook.getWorksheets().get(this.workbook.getWorksheets().getActiveSheetIndex());
        this.fileReader = new WorksheetReaderService(this.worksheet);	
		this.fileWriter = new WorksheetWriterService(this.worksheet);        

        // this.currentRowIndex = this.worksheet.getCells().getRows().
    };
    public Integer getMaxRows()
	{
        return fileReader.getMaxNumberOfRows(this.worksheet);	
	}
    public void getWorksheetName(String bookshelfName) 
	{
		String worksheetName = worksheet.getName();
		System.out.println("Worksheet's name is  " + worksheetName);
	}

    public List<String> getAllColumnNames(){
        return this.fileReader.getAllColumnHeaderNames(this.worksheet);
    }

    public void sortBookshelves(){
        for(int row = 0; row <= this.getMaxRows(); row++){
                List<String> unsortedBookshelves = fileReader.getBookshelves(this.worksheet, row, this.fileReader.getColumnHeaderBookshelves());
                List<String> sortedBookshelves = sortBookshelves(unsortedBookshelves);
                fileWriter.setBookshelves(worksheet, row, this.fileReader.getColumnHeaderBookshelves(), sortedBookshelves);
            // String[] unsortedBookshelves = this.worksheet.getCells().get(row, this.fileReader.getColumnHeaderBookshelves()).toString().split(" ");
                System.out.println(sortedBookshelves.toString());

        }
        // this.worksheet.save
    }

    public List<String> sortBookshelves(List<String> unsortedBookshelves){
        List<String> sortedBookshelves = unsortedBookshelves.stream().sorted().collect(Collectors.toList());
        sortedBookshelves.forEach(String::trim);
        return sortedBookshelves;
    }

    public void closeWorksheetStream() {
        this.worksheetsStream.closeInputStream();
    }

    
}
