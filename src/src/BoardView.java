package src;

import java.applet.Applet;
import java.awt.*;

public class BoardView {
	
	public static final int BOARD_WIDTH = 347;
	public static final int BOARD_HEIGHT = 301;
	public static final int CELL_WIDTH = BOARD_WIDTH / Board.BOARD_SIZE;
	public static final int CELL_HEIGHT = BOARD_HEIGHT / Board.BOARD_SIZE;
	
	private Applet applet;
	private Image boardImg;
	private Image xImg;
	private Image oImg;
	private Board board = new NullBoard();
	private int x = 0;
	private int y = 0;
	
	public BoardView(Applet applet) {
		this.applet = applet;
		boardImg = applet.getImage(applet.getDocumentBase(), "images/board.png");
		xImg = applet.getImage(applet.getDocumentBase(), "images/x.png");
		oImg = applet.getImage(applet.getDocumentBase(), "images/o.png");
	}
	
	public void paint(Graphics g) {
		paintBoard(g);
		paintMarks(g);
		if (board.isWin()) {
			crossOutWinCells(g);
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, BOARD_WIDTH, BOARD_HEIGHT);
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	private void paintBoard(Graphics g) {
		g.drawImage(boardImg, x, y, applet);
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
		Image img = mark == Mark.X ? xImg : oImg;
		int x = this.x + 25 + col * CELL_WIDTH;
		int y = this.y + 22 + row * CELL_HEIGHT;
		g.drawImage(img, x, y, applet);
	}
	
	private void crossOutWinCells(Graphics g) {
		int[] winX = new int[Board.BOARD_SIZE];
		int[] winY = new int[Board.BOARD_SIZE];
		
		Cell[] winCells = board.getWinCells();
		
		for (int i = 0; i < winCells.length; ++i) {
			winX[i] = x + winCells[i].getCol() * CELL_WIDTH + 15;
			winY[i] = y + winCells[i].getRow() * CELL_HEIGHT + 15;
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
