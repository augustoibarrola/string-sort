package com.example.util;


import com.aspose.cells.Workbook;

public class WorkbookUtilities {
	
	Workbook workbook;

	public WorkbookUtilities() {}

	public WorkbookUtilities(Workbook workbook) {
		this.workbook = workbook;
	}

	public void getNameOfActiveWorkSheet(){
		String workBookActiveSheetName = workbook.getWorksheets().getActiveSheetName();
		
		System.out.println(workBookActiveSheetName);

	}


}