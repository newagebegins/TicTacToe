package src;

import java.awt.Graphics;

public class BoardView {
	
	private static final int BOARD_X = 10;
	private static final int BOARD_Y = 10;
	private static final int BOARD_SIZE = 90;
	private static final int CELL_SIZE = BOARD_SIZE / Board.BOARD_SIZE;
	
	private Board board = new NullBoard();
	
	public void paint(Graphics g) {
		paintBoard(g);
		paintMarks(g);
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	private void paintBoard(Graphics g) {
		g.drawRect(BOARD_X, BOARD_Y, BOARD_SIZE, BOARD_SIZE);
		g.drawLine(BOARD_X, BOARD_Y + CELL_SIZE, BOARD_X + BOARD_SIZE, BOARD_Y + CELL_SIZE);
		g.drawLine(BOARD_X, BOARD_Y + CELL_SIZE*2, BOARD_X + BOARD_SIZE, BOARD_Y + CELL_SIZE*2);
		g.drawLine(BOARD_X + CELL_SIZE, BOARD_Y, BOARD_X + CELL_SIZE, BOARD_Y + BOARD_SIZE);
		g.drawLine(BOARD_X + CELL_SIZE*2, BOARD_Y, BOARD_X + CELL_SIZE*2, BOARD_Y + BOARD_SIZE);
	}
	
	private void paintMarks(Graphics g) {
		for (int row = 0; row < Board.BOARD_SIZE; ++row) {
			for (int col = 0; col < Board.BOARD_SIZE; ++col) {
				if (board.cellIsNotEmpty(row, col)) {
					paintMarkInCell(g, row, col);
				}
			}
		}
	}

	private void paintMarkInCell(Graphics g, int row, int col) {
		Mark mark = board.getMarkInCell(row, col);
		String markString = mark == Mark.X ? "X" : "O";
		int x = BOARD_X + 11 + col * CELL_SIZE;
		int y = BOARD_Y + 20 + row * CELL_SIZE;
		g.drawString(markString, x, y);
	}

}
