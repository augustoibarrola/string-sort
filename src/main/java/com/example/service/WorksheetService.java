package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.example.service.handler.WorksheetStreamHandler;
import com.example.service.reader.WorksheetReaderService;
import com.example.service.writer.WorksheetWriterService;
import com.example.util.WorksheetUtilities;

public class WorksheetService {

	private WorksheetWrapper worksheet;

	public WorksheetService() {
	};

	public WorksheetService(String fileLocation) {
		System.out.println("Getting Worksheet from resources..");
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
