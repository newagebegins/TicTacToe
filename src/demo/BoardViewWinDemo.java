package demo;

import java.applet.Applet;
import java.awt.Graphics;

import src.Board;
import src.BoardView;

@SuppressWarnings("serial")
public class BoardViewWinDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		topRow(g);
		leftCol(g);
		diagonalOne(g);
		diagonalTwo(g);
	}

	private void topRow(Graphics g) {
		Board board = new Board();
		
		board.setXMarkInCell(0, 0);
		board.setXMarkInCell(0, 1);
		board.setXMarkInCell(0, 2);
		board.checkWin();
		
		BoardView boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(0, 0);
		
		boardView.paint(g);
	}
	
	private void leftCol(Graphics g) {
		Board board = new Board();
		
		board.setXMarkInCell(0, 0);
		board.setXMarkInCell(1, 0);
		board.setXMarkInCell(2, 0);
		board.checkWin();
		
		BoardView boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(100, 0);
		
		boardView.paint(g);
	}
	
	private void diagonalOne(Graphics g) {
		Board board = new Board();
		
		board.setXMarkInCell(0, 0);
		board.setXMarkInCell(1, 1);
		board.setXMarkInCell(2, 2);
		board.checkWin();
		
		BoardView boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(0, 100);
		
		boardView.paint(g);
	}
	
	private void diagonalTwo(Graphics g) {
		Board board = new Board();
		
		board.setXMarkInCell(0, 2);
		board.setXMarkInCell(1, 1);
		board.setXMarkInCell(2, 0);
		board.checkWin();
		
		BoardView boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(100, 100);
		
		boardView.paint(g);
	}

}
