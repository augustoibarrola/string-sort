package com.example.service;


public class WorksheetService {

	private WorksheetWrapper worksheet;

	public WorksheetService() {
	};

	public WorksheetService(String fileLocation) {
		this.worksheet = new WorksheetWrapper(fileLocation);
	};

	public void getAllColumnNames() {
		worksheet.getAllColumnNames();
	}

	public void sortBookshelves() {
		worksheet.sortBookshelves();
		
	}

	public void closeWorksheet() {
		worksheet.closeWorksheetStream();
	}
}
