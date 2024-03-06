package com.example.util;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aspose.cells.Workbook;
import com.example.dao.CellDAO;
import com.example.dao.WorkbookDAO;
import com.example.dao.WorksheetDAO;

public class WorkbookUtilities {
	
	Workbook workbook;
	WorkbookDAO workbookDao;
	WorksheetDAO worksheetDao;
	CellDAO currentCellDao;

	public WorkbookUtilities() {}

	public WorkbookUtilities(Workbook workbook) {
		this.workbook = workbook;
		this.workbookDao = new WorkbookDAO(workbook);
		this.worksheetDao =  new WorksheetDAO(this.workbookDao);
	}


	public void getNameOfActiveWorkSheet(){
		String workBookActiveSheetName = workbook.getWorksheets().getActiveSheetName();
		System.out.println(workBookActiveSheetName);
	}



    public void sortWorkbookWorksheet() {
    	
    	int maxNumberofRowsWithData = this.workbook.getWorksheets().get(0).getCells().getMaxDataRow(); 
    	
    	for(int row=1; row <= maxNumberofRowsWithData; row++) {
    		
    		CellDAO currentCellDao = new CellDAO(this.workbook.getWorksheets().get(0).getCells().get(row, 16)); 
//    		this.workbook.getWorksheets().get(0).getCells().get(row, 16).setValue("FUCK!!");
    		if(currentCellDao.getStringValueAsList().size() != 1) {	
    		
    			List<String> sortedShelves = new ArrayList<>(currentCellDao.getStringValueAsList()); 
//    			sortedShelves = currentCellDao.getStringValueAsList().sort(null);
    			sortedShelves = sortedShelves.stream().sorted().collect(Collectors.toList());
//    			System.out.println("Unsorted : " + currentCellDao.getStringValue());
//    			System.out.println("Sorted : " + sortedShelves.toString());
    			
    			/*
    			 * - [ ]  Issue #11 created to eventually remove trailing comma from 
    			 * 		sortedShelveAsStringBuffer before saving it into the workbook
    			 */
    			StringBuilder sortedShelveAsStringBuffer = new StringBuilder();
    			for(String shelf : sortedShelves) {
    				String shelfTrimmedDown = shelf.replaceAll("\\[", "").replaceAll("\\]", "");
    				sortedShelveAsStringBuffer.append(shelfTrimmedDown);
    				sortedShelveAsStringBuffer.append(", ");
    				System.out.println(sortedShelveAsStringBuffer);
    			}
        		this.workbook.getWorksheets().get(0).getCells().get(row, 16).setValue(sortedShelveAsStringBuffer.toString());
    		}
    	}
    	
    	saveWorkbook();
	}
    
    
    
    public void saveWorkbook() {
		try {
			this.workbook.save("src/main/resources/GOODREADS_DATA.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

    }


}