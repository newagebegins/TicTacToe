package src;

public class AI {

	private Board board;
	private Mark aiMark;
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setAIMark(Mark aiMark) {
		this.aiMark = aiMark;
	}

	public Cell getMoveCell() {
		Cell result = null;
		
		result = getSpecialMoveCell(aiMark);
		if (result != null) {
			return result;
		}
		
		result = getSpecialMoveCell(getUserMark());
		if (result != null) {
			return result;
		}
		
		return null;
	}
	
	private Mark getUserMark() {
		return aiMark == Mark.X ? Mark.O : Mark.X;
	}

	private Cell getSpecialMoveCell(Mark mark) {
		for (int row = 0; row < Board.BOARD_SIZE; ++row) {
			if (rowHasEmptyCell(board.getRow(row)) && rowHasTwoIdenticalMarks(board.getRow(row), mark)) {
				return new Cell(row, getIndexOfEmptyCellInRow(board.getRow(row)));
			}
		}
		
		for (int col = 0; col < Board.BOARD_SIZE; ++col) {
			if (rowHasEmptyCell(board.getCol(col)) && rowHasTwoIdenticalMarks(board.getCol(col), mark)) {
				return new Cell(getIndexOfEmptyCellInRow(board.getCol(col)), col);
			}
		}
		
		if (rowHasEmptyCell(board.getDiagonalOne()) && rowHasTwoIdenticalMarks(board.getDiagonalOne(), mark)) {
			int index = getIndexOfEmptyCellInRow(board.getDiagonalOne());
			return new Cell(index, index);
		}
		
		if (rowHasEmptyCell(board.getDiagonalTwo()) && rowHasTwoIdenticalMarks(board.getDiagonalTwo(), mark)) {
			int index = getIndexOfEmptyCellInRow(board.getDiagonalTwo());
			return new Cell(index, Board.BOARD_SIZE - 1 - index);
		}
		
		return null;
	}
	
	private boolean rowHasEmptyCell(Mark[] row) {
		for (int i = 0; i < Board.BOARD_SIZE; ++i) {
			if (row[i] == Mark.Empty) {
				return true;
			}
		}
		return false;
	}

	private boolean rowHasTwoIdenticalMarks(Mark[] row, Mark mark) {
		int counter = 0;
		for (int i = 0; i < Board.BOARD_SIZE; ++i) {
			if (row[i] == mark) {
				counter++;
			}
		}
		return counter == 2;
	}
	
	private int getIndexOfEmptyCellInRow(Mark[] row) {
		for (int i = 0; i < Board.BOARD_SIZE; ++i) {
			if (row[i] == Mark.Empty) {
				return i;
			}
		}
		return -1;
	}
	
}
