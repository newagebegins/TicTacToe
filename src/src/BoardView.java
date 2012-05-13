package src;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BoardView extends DisplayUnit {
	
	public static final int BOARD_SIZE_PX = 90;
	public static final int CELL_SIZE_PX = BOARD_SIZE_PX / Board.BOARD_SIZE;
	
	private Board board = new NullBoard();
	private int x = 0;
	private int y = 0;
	
	public void paint(Graphics g) {
		paintBoard(g);
		paintMarks(g);
		if (board.isWin()) {
			crossOutWinCells(g);
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, BOARD_SIZE_PX, BOARD_SIZE_PX);
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	private void paintBoard(Graphics g) {
		g.drawRect(x, y, BOARD_SIZE_PX, BOARD_SIZE_PX);
		g.drawLine(x, y + CELL_SIZE_PX, x + BOARD_SIZE_PX, y + CELL_SIZE_PX);
		g.drawLine(x, y + CELL_SIZE_PX*2, x + BOARD_SIZE_PX, y + CELL_SIZE_PX*2);
		g.drawLine(x + CELL_SIZE_PX, y, x + CELL_SIZE_PX, y + BOARD_SIZE_PX);
		g.drawLine(x + CELL_SIZE_PX*2, y, x + CELL_SIZE_PX*2, y + BOARD_SIZE_PX);
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
		int x = this.x + 11 + col * CELL_SIZE_PX;
		int y = this.y + 20 + row * CELL_SIZE_PX;
		g.drawString(markString, x, y);
	}
	
	private void crossOutWinCells(Graphics g) {
		int[] winX = new int[Board.BOARD_SIZE];
		int[] winY = new int[Board.BOARD_SIZE];
		
		Cell[] winCells = board.getWinCells();
		
		for (int i = 0; i < winCells.length; ++i) {
			winX[i] = x + winCells[i].getCol() * CELL_SIZE_PX + 15;
			winY[i] = y + winCells[i].getRow() * CELL_SIZE_PX + 15;
		}
		
		g.drawPolyline(winX, winY, Board.BOARD_SIZE);
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}
