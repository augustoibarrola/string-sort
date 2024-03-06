package com.example.util;


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
    		if(currentCellDao.getStringValue() !=null && currentCellDao.getStringValue() !="") {
    			System.out.println(currentCellDao.getStringValue());
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