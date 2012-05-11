package src;

import java.util.Observable;

public class Board extends Observable {
	
	public static final int BOARD_SIZE = 3;
	
	private Mark[][] cells = new Mark[BOARD_SIZE][BOARD_SIZE];
	
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
	
	public boolean cellIsNotEmpty(int row, int col) {
		return getMarkInCell(row, col) != Mark.Empty;
	}
	
	private void initCells() {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				removeMarkInCell(row, col);
			}
		}
	}

}
