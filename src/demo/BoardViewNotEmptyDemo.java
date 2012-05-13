package demo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import src.Board;
import src.BoardView;

@SuppressWarnings("serial")
public class BoardViewNotEmptyDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		setBackground(Color.black);
		setSize(BoardView.BOARD_WIDTH, BoardView.BOARD_HEIGHT);
		
		Board board = new Board(
				"XOX\n" +
				"OXO\n" +
				"XOX\n");
		
		BoardView boardView = new BoardView(this);
		boardView.setBoard(board);
		
		boardView.paint(g);
	}

}
