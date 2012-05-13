package src;

import java.util.Observable;

public class Board extends Observable {
	
	public static final int BOARD_SIZE = 3;
	
	private Mark[][] cells = new Mark[BOARD_SIZE][BOARD_SIZE];
	private boolean win = false;
	private Cell[] winCells = new Cell[BOARD_SIZE];
	
	public Board() {
		initCells();
	}
	
	public void setMarkInCell(Mark mark, Cell cell) {
		setMarkInCell(cell.getRow(), cell.getCol(), mark);
	}
	
	public void setMarkInCell(int row, int col, Mark mark) {
		if (!isLegitimateCell(row, col)) {
			return;
		}
		cells[row][col] = mark;
		setChanged();
		notifyObservers();
	}

	private boolean isLegitimateCell(int row, int col) {
		return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
	}
	
	public void setXMarkInCell(int row, int col) {
		setMarkInCell(row, col, Mark.X);
	}
	
	public void setOMarkInCell(int row, int col) {
		setMarkInCell(row, col, Mark.O);
	}
	
	public void removeMarkInCell(int row, int col) {
		setMarkInCell(row, col, Mark.Empty);
	}
	
	public Mark getMarkInCell(int row, int col) {
		if (!isLegitimateCell(row, col)) {
			return Mark.Null;
		}
		return cells[row][col];
	}
	
	public Mark getMarkInCell(Cell cell) {
		return getMarkInCell(cell.getRow(), cell.getCol());
	}
	
	public boolean cellIsNotEmpty(Cell cell) {
		return cellIsNotEmpty(cell.getRow(), cell.getCol());
	}
	
	public boolean cellIsNotEmpty(int row, int col) {
		return !cellIsEmpty(row, col);
	}
	
	public boolean cellIsEmpty(int row, int col) {
		return getMarkInCell(row, col) == Mark.Empty && getMarkInCell(row, col) != Mark.Null;
	}
	
	public void checkWin() {
		Cell[][] possibleWinCells = new Cell[][] {
				{new Cell(0,0), new Cell(0,1), new Cell(0,2)},
				{new Cell(1,0), new Cell(1,1), new Cell(1,2)},
				{new Cell(2,0), new Cell(2,1), new Cell(2,2)},
				
				{new Cell(0,0), new Cell(1,0), new Cell(2,0)},
				{new Cell(0,1), new Cell(1,1), new Cell(2,1)},
				{new Cell(0,2), new Cell(1,2), new Cell(2,2)},
				
				{new Cell(0,0), new Cell(1,1), new Cell(2,2)},
				{new Cell(0,2), new Cell(1,1), new Cell(2,0)},
		};
		
		for (int i = 0; i < possibleWinCells.length; ++i) {
			if (allCellsHaveSamePlayerMarks(possibleWinCells[i])) {
				setWin(true);
				this.winCells = possibleWinCells[i];
				return;
			}
		}
	}
	
	private boolean allCellsHaveSamePlayerMarks(Cell[] cellsArg) {
		Mark firstMark = getMarkInCell(cellsArg[0]);
		if (firstMark != Mark.O && firstMark != Mark.X) {
			return false;
		}
		for (int i = 1; i < cellsArg.length; ++i) {
			if (getMarkInCell(cellsArg[i]) != firstMark) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isWin() {
		return win ;
	}
	
	private void initCells() {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				removeMarkInCell(row, col);
			}
		}
	}

	private void setWin(boolean win) {
		this.win = win;
		setChanged();
		notifyObservers();
	}

	public Cell[] getWinCells() {
		return winCells;
	}

}
