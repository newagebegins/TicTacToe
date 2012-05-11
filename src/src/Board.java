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
		if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
			return;
		}
		cells[row][col] = mark;
		setChanged();
		notifyObservers();
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
		return cells[row][col];
	}
	
	public boolean cellIsNotEmpty(Cell cell) {
		return cellIsNotEmpty(cell.getRow(), cell.getCol());
	}
	
	public boolean cellIsNotEmpty(int row, int col) {
		return getMarkInCell(row, col) != Mark.Empty;
	}
	
	public void checkWin() {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			if (allMarksAreTheSameAndNotEmptyInRow(row)) {
				setWin(true);
				return;
			}
		}
		
		for (int col = 0; col < BOARD_SIZE; ++col) {
			if (allMarksAreTheSameAndNotEmptyInCol(col)) {
				setWin(true);
				return;
			}
		}
		
		if (allMarksOnDiagonalOneAreTheSameAndNotEmpty()) {
			setWin(true);
			return;
		}
		
		if (allMarksOnDiagonalTwoAreTheSameAndNotEmpty()) {
			setWin(true);
			return;
		}
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

	private boolean allMarksAreTheSameAndNotEmptyInRow(int row) {
		Mark firstMark = cells[row][0];
		if (firstMark == Mark.Empty) {
			return false;
		}
		Cell[] winCells = new Cell[BOARD_SIZE];
		winCells[0] = new Cell(row, 0);
		for (int col = 1; col < BOARD_SIZE; ++col) {
			if (cells[row][col] != firstMark) {
				return false;
			}
			winCells[col] = new Cell(row, col);
		}
		this.winCells = winCells;
		return true;
	}
	
	private boolean allMarksAreTheSameAndNotEmptyInCol(int col) {
		Mark firstMark = cells[0][col];
		if (firstMark == Mark.Empty) {
			return false;
		}
		Cell[] winCells = new Cell[BOARD_SIZE];
		winCells[0] = new Cell(0, col);
		for (int row = 1; row < BOARD_SIZE; ++row) {
			if (cells[row][col] != firstMark) {
				return false;
			}
			winCells[row] = new Cell(row, col);
		}
		this.winCells = winCells;
		return true;
	}
	
	private boolean allMarksOnDiagonalOneAreTheSameAndNotEmpty() {
		Mark firstMark = cells[0][0];
		if (firstMark == Mark.Empty) {
			return false;
		}
		Cell[] winCells = new Cell[BOARD_SIZE];
		winCells[0] = new Cell(0, 0);
		for (int i = 1; i < BOARD_SIZE; ++i) {
			if (cells[i][i] != firstMark) {
				return false;
			}
			winCells[i] = new Cell(i, i);
		}
		this.winCells = winCells;
		return true;
	}
	
	private boolean allMarksOnDiagonalTwoAreTheSameAndNotEmpty() {
		Mark firstMark = cells[0][BOARD_SIZE - 1];
		if (firstMark == Mark.Empty) {
			return false;
		}
		Cell[] winCells = new Cell[BOARD_SIZE];
		winCells[0] = new Cell(0, BOARD_SIZE - 1);
		for (int row = 1, col = BOARD_SIZE - 2; col >= 0; ++row, --col) {
			if (cells[row][col] != firstMark) {
				return false;
			}
			winCells[row] = new Cell(row, col);
		}
		this.winCells = winCells;
		return true;
	}

	public Cell[] getWinCells() {
		return winCells;
	}

}
