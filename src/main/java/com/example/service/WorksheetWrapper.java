package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.WorksheetReaderService;
import com.example.service.writer.WorksheetWriterService;

public class WorksheetWrapper {

    private WorksheetStreamHandler worksheetsStream;
    private WorksheetCollection workSheetCollection;
    private Workbook workbook;
    private Worksheet worksheet;
    private WorksheetWriterService fileWriter;
    private WorksheetReaderService fileReader;

    public WorksheetWrapper() {
    };

    public WorksheetWrapper(String fileLocation) {
        loadWorksheetStreamHandler(fileLocation);
        loadWorksheetCollection();
        this.workbook = this.worksheetsStream.loadWorkbookFromInputStream(this.worksheetsStream);
        this.worksheet = this.workbook.getWorksheets().get(this.workbook.getWorksheets().getActiveSheetIndex());
        this.fileReader = new WorksheetReaderService(this.worksheet);
        this.fileWriter = new WorksheetWriterService(this.worksheet);
    };

    private void loadWorksheetStreamHandler(String fileLocation) {
        this.worksheetsStream = new WorksheetStreamHandler(fileLocation);
    }

    private void loadWorksheetCollection() {
        this.workSheetCollection = this.worksheetsStream.loadWorksheetCollectionFromInputStream();
    }

    public Integer getMaxRows() {
        return fileReader.getMaxNumberOfRows(this.worksheet);
    }

    public void getWorksheetName(String bookshelfName) {
        String worksheetName = worksheet.getName();
    }

    public List<String> getAllColumnNames() {
        return this.fileReader.getAllColumnHeaderNames(this.worksheet);
    }

    public void sortBookshelves() {
        for (int row = 0; row <= this.getMaxRows(); row++) {
            List<String> unsortedBookshelves = fileReader.getBookshelves(this.worksheet, row,
                    this.fileReader.getColumnHeaderBookshelves());
            List<String> sortedBookshelves = sortBookshelves(unsortedBookshelves);
            // String[] unsortedBookshelves = this.worksheet.getCells().get(row,
            // this.fileReader.getColumnHeaderBookshelves()).toString().split(" ");
            if (sortedBookshelves.size() > 1) {
                fileWriter.setBookshelves(worksheet, row, this.fileReader.getColumnHeaderBookshelves(),
                        sortedBookshelves);
                System.out.println("Sorted Bookshelves: " + sortedBookshelves.toString());
            }
        }
    }

    public void saveWorkbook() {

        try {
            this.workbook.save("GOODREADS_DATA.xlsx");
            this.worksheetsStream.closeInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> sortBookshelves(List<String> unsortedBookshelves) {
        List<String> sortedBookshelves = unsortedBookshelves.stream().sorted().collect(Collectors.toList());
        sortedBookshelves.forEach(String::trim);
        return sortedBookshelves;
    }

    public void closeWorksheetStream() {
        this.worksheetsStream.closeInputStream();
    }

}
