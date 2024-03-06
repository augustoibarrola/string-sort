package com.example.dao;

import java.util.Arrays;
import java.util.List;

import com.aspose.cells.Cell;

public class CellDAO {
	
	Cell activeCell;
	String stringValue;
	List<String> stringValueAsList;
	
	public CellDAO() {}
	
	public CellDAO(Cell activeCell) {
		this.activeCell = activeCell;
		this.stringValue = activeCell.getStringValue();
		this.stringValueAsList = Arrays.asList(activeCell.getStringValue().split(", "));
	}

	public Cell getActiveCell() {
		return activeCell;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setActiveCell(Cell activeCell) {
		this.activeCell = activeCell;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public List<String> getStringValueAsList() {
		return stringValueAsList;
	}

	public void setStringValueAsList(List<String> stringValueAsList) {
		this.stringValueAsList = stringValueAsList;
	}

}
