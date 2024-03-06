package com.example.dao;

import com.aspose.cells.Cell;

public class CellDAO {
	
	Cell activeCell;
	String stringValue;
	
	public CellDAO() {}
	
	public CellDAO(Cell activeCell) {
		this.activeCell = activeCell;
		this.stringValue = activeCell.getStringValue();
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

}
