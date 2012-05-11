package src;

import java.awt.Graphics;

public class BoardView {
	
	private static final int BOARD_X = 10;
	private static final int BOARD_Y = 10;
	private static final int BOARD_SIZE = 90;
	private static final int CELL_SIZE = BOARD_SIZE / 3;
	
	public void paint(Graphics g) {
		g.drawRect(BOARD_X, BOARD_Y, BOARD_SIZE, BOARD_SIZE);
		g.drawLine(BOARD_X, BOARD_Y + CELL_SIZE, BOARD_X + BOARD_SIZE, BOARD_Y + CELL_SIZE);
		g.drawLine(BOARD_X, BOARD_Y + CELL_SIZE*2, BOARD_X + BOARD_SIZE, BOARD_Y + CELL_SIZE*2);
		g.drawLine(BOARD_X + CELL_SIZE, BOARD_Y, BOARD_X + CELL_SIZE, BOARD_Y + BOARD_SIZE);
		g.drawLine(BOARD_X + CELL_SIZE*2, BOARD_Y, BOARD_X + CELL_SIZE*2, BOARD_Y + BOARD_SIZE);
	}

}
