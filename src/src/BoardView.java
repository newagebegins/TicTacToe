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
	private Image lineHorizontalImg;
	private Image lineVerticalImg;
	private Image lineDiagonalOneImg;
	private Image lineDiagonalTwoImg;
	private Board board = new NullBoard();
	private int x = 0;
	private int y = 0;
	
	public BoardView(Applet applet) {
		this.applet = applet;
		boardImg = applet.getImage(getClass().getResource("images/board.png"));
		xImg = applet.getImage(getClass().getResource("images/x.png"));
		oImg = applet.getImage(getClass().getResource("images/o.png"));
		lineHorizontalImg = applet.getImage(getClass().getResource("images/line-horizontal.png"));
		lineVerticalImg = applet.getImage(getClass().getResource("images/line-vertical.png"));
		lineDiagonalOneImg = applet.getImage(getClass().getResource("images/line-diagonal-one.png"));
		lineDiagonalTwoImg = applet.getImage(getClass().getResource("images/line-diagonal-two.png"));
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
		Cell[] winCells = board.getWinCells();
		
		// Horizontal.
		if (winCells[0].getRow() == winCells[Board.BOARD_SIZE - 1].getRow()) {
			int winX = x + winCells[0].getCol() * CELL_WIDTH - 10;
			int winY = y + winCells[0].getRow() * CELL_HEIGHT + CELL_HEIGHT / 2 - 10;
			g.drawImage(lineHorizontalImg, winX, winY, applet);
		}
		// Vertical.
		else if (winCells[0].getCol() == winCells[Board.BOARD_SIZE - 1].getCol()) {
			int winX = x + winCells[0].getCol() * CELL_WIDTH + CELL_WIDTH / 2 - 10;
			int winY = y + winCells[0].getRow() * CELL_HEIGHT - 25;
			g.drawImage(lineVerticalImg, winX, winY, applet);
		}
		// Diagonal one.
		else if (winCells[0].getCol() == 0 && winCells[Board.BOARD_SIZE - 1].getCol() == 2) {
			int winX = x + 25;
			int winY = y;
			g.drawImage(lineDiagonalOneImg, winX, winY, applet);
		}
		// Diagonal two.
		else if (winCells[0].getCol() == 2 && winCells[Board.BOARD_SIZE - 1].getCol() == 0) {
			int winX = x + 40;
			int winY = y;
			g.drawImage(lineDiagonalTwoImg, winX, winY, applet);
		}
		
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
