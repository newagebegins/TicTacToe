package demo;

import java.applet.Applet;
import java.awt.Graphics;

import src.BoardView;

@SuppressWarnings("serial")
public class BoardViewEmptyDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		BoardView boardView = new BoardView();
		boardView.paint(g);
	}

}
