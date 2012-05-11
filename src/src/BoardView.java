package src;

import java.awt.Graphics;

public class BoardView {
	
	private static final int BOARD_X_PX = 10;
	private static final int BOARD_Y_PX = 10;
	private static final int BOARD_SIZE_PX = 90;
	private static final int CELL_SIZE_PX = BOARD_SIZE_PX / Board.BOARD_SIZE;
	
	private Board board = new NullBoard();
	
	public void paint(Graphics g) {
		paintBoard(g);
		paintMarks(g);
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	private void paintBoard(Graphics g) {
		g.drawRect(BOARD_X_PX, BOARD_Y_PX, BOARD_SIZE_PX, BOARD_SIZE_PX);
		g.drawLine(BOARD_X_PX, BOARD_Y_PX + CELL_SIZE_PX, BOARD_X_PX + BOARD_SIZE_PX, BOARD_Y_PX + CELL_SIZE_PX);
		g.drawLine(BOARD_X_PX, BOARD_Y_PX + CELL_SIZE_PX*2, BOARD_X_PX + BOARD_SIZE_PX, BOARD_Y_PX + CELL_SIZE_PX*2);
		g.drawLine(BOARD_X_PX + CELL_SIZE_PX, BOARD_Y_PX, BOARD_X_PX + CELL_SIZE_PX, BOARD_Y_PX + BOARD_SIZE_PX);
		g.drawLine(BOARD_X_PX + CELL_SIZE_PX*2, BOARD_Y_PX, BOARD_X_PX + CELL_SIZE_PX*2, BOARD_Y_PX + BOARD_SIZE_PX);
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
		int x = BOARD_X_PX + 11 + col * CELL_SIZE_PX;
		int y = BOARD_Y_PX + 20 + row * CELL_SIZE_PX;
		g.drawString(markString, x, y);
	}

}
