package demo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import src.*;

@SuppressWarnings("serial")
public class BoardControllerTwoPlayersDemo extends Applet implements Observer {
	
	Board board;
	BoardView boardView;
	BoardController boardController;
	GameManager gameManager;
	MouseController mouseController;
	AI ai;

	@Override
	public void init() {
		setBackground(Color.black);
		setSize(BoardView.BOARD_WIDTH, BoardView.BOARD_HEIGHT);
		
		board = new Board();
		board.addObserver(this);
		
		gameManager = new GameManager(board);
		gameManager.setCurrentPlayerMark(Mark.X);
		
		ai = new AI();
		ai.setAIMark(Mark.O);
		ai.setBoard(board);
		gameManager.setAI(ai);
		
		boardController = new BoardController();
		boardController.setBoard(board);
		boardController.setGameManager(gameManager);
		
		boardView = new BoardView(this);
		boardView.setBoard(board);
		boardController.setBoardView(boardView);
		
		mouseController = new MouseController(gameManager, boardController);
		addMouseListener(mouseController);
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
