package src;

public class Cell {
	
	private int row;
	private int col;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cell)) {
			return false;
		}
		Cell other = (Cell) obj;
		return this.row == other.row && this.col == other.col;
	}
	
	@Override
	public String toString() {
		return "" + row + "," + col;
	}
	
}
