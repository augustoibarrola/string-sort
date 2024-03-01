package com.example.util;


import com.aspose.cells.Workbook;
import com.example.dao.WorkbookDAO;

public class WorkbookUtilities {
	
	Workbook workbook;
	WorkbookDAO workbookDao;

	public WorkbookUtilities() {}

	public WorkbookUtilities(Workbook workbook) {
		this.workbook = workbook;
		this.workbookDao = new WorkbookDAO(workbook);
	}


	public void getNameOfActiveWorkSheet(){
		String workBookActiveSheetName = workbook.getWorksheets().getActiveSheetName();
		
		System.out.println(workBookActiveSheetName);

	}

    public void getNameOfActiveWorkSheet(WorkbookDAO workbookDao) {
        throw new UnsupportedOperationException("Unimplemented method 'getNameOfActiveWorkSheet'");
    }


    public void sortWorkbookWorksheet() {
		
	}


}