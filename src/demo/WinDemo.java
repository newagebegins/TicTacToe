package demo;

import java.applet.Applet;
import java.awt.Graphics;

import src.Board;
import src.BoardView;

@SuppressWarnings("serial")
public class WinDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		Board board = new Board();
		
		board.setXMarkInCell(0, 0);
		board.setXMarkInCell(0, 1);
		board.setXMarkInCell(0, 2);
		board.checkWin();
		
		BoardView boardView = new BoardView();
		boardView.setBoard(board);
		
		boardView.paint(g);
	}

}
