package com.example.dao;

import com.aspose.cells.Worksheet;

/*
 * 
 *	// [ ]   create the properties in here like
 *			 column header names, 
 *			 max number of rows with data, etc.
 *			
 */
public class WorksheetDAO {
	
	private Worksheet worksheet;
	
	private WorkbookDAO workbookDao;
	private Integer maxNumberOfRows;
	private Integer maxNumberOfColumns;
	
	public WorksheetDAO(WorkbookDAO workbookDao) {
		
		this.workbookDao = workbookDao;
		
	}
	
	public WorksheetDAO(Worksheet Worksheet) {
		
		this.worksheet = worksheet;
		
	}

	public Worksheet getWorksheet() {
		return worksheet;
	}

	public WorkbookDAO getWorkbookDao() {
		return workbookDao;
	}

	public Integer getMaxNumberOfRows() {
		return maxNumberOfRows;
	}

	public void setWorksheet(Worksheet worksheet) {
		this.worksheet = worksheet;
	}

	public void setWorkbookDao(WorkbookDAO workbookDao) {
		this.workbookDao = workbookDao;
	}

	public void setMaxNumberOfRows(Integer maxNumberOfRows) {
		this.maxNumberOfRows = maxNumberOfRows;
	}

	public Integer getMaxNumberOfColumns() {
		return maxNumberOfColumns;
	}

	public void setMaxNumberOfColumns(Integer maxNumberOfColumns) {
		this.maxNumberOfColumns = maxNumberOfColumns;
	}

}
