package demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import src.*;

@SuppressWarnings("serial")
public class BoardControllerOnePlayerDemo extends Applet implements Observer {
	
	Board board;
	BoardView boardView;
	BoardController boardController;
	GameManager gameManager;

	@Override
	public void init() {
		board = new Board();
		board.addObserver(this);
		
		gameManager = new GameManager();
		gameManager.setCurrentPlayerMark(Mark.X);
		
		boardController = new BoardController();
		boardController.setBoard(board);
		boardController.setGameManager(gameManager);
		
		boardView = new BoardView();
		boardView.setBoard(board);
		
		addMouseListener(boardController);
	}

	@Override
	public void paint(Graphics g) {
		boardView.paint(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
