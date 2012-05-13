package demo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import src.BoardView;

@SuppressWarnings("serial")
public class BoardViewEmptyDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		setBackground(Color.black);
		setSize(BoardView.BOARD_WIDTH, BoardView.BOARD_HEIGHT);
		
		BoardView boardView = new BoardView(this);
		boardView.paint(g);
	}

}
