package com.example.util;


import com.aspose.cells.Workbook;

public class WorkbookUtilities {

	public WorkbookUtilities() {}

	public void getNameOfActiveWorkSheet(Workbook workbook){
		String workBookActiveSheetName = workbook.getWorksheets().getActiveSheetName();
		
		System.out.println(workBookActiveSheetName);

	}


}