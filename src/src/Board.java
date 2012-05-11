package src;

public class Board {
	
	public static final int BOARD_SIZE = 3;
	
	private Mark[][] cells = new Mark[BOARD_SIZE][BOARD_SIZE];
	
	public Board() {
		initCells();
	}
	
	public void setXMarkInCell(int row, int col) {
		setMark(row, col, Mark.X);
	}
	
	public void setOMarkInCell(int row, int col) {
		setMark(row, col, Mark.O);
	}
	
	public void removeMarkInCell(int row, int col) {
		setMark(row, col, Mark.Empty);
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
	
	private void setMark(int row, int col, Mark mark) {
		cells[row][col] = mark;
	}

}
