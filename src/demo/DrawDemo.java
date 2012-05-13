package demo;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import src.*;

@SuppressWarnings("serial")
public class DrawDemo extends Applet implements Observer {
	
	private Board board;
	private BoardView boardView;
	private BoardController boardController;
	private GameManager gameManager;
	private MouseController mouseController;
	private GameOverMessage gameOverMessage;
	private AI ai;
	
	@Override
	public void init() {
		board = new Board(
				"XXO\n" +
				"OXX\n" +
				"XOO\n"
		);
		board.addObserver(this);
		
		gameManager = new GameManager(board);
		
		ai = new AI();
		ai.setBoard(board);
		gameManager.setAI(ai);
		
		gameManager.setCurrentPlayerMark(Mark.X);
		ai.setAIMark(Mark.O);
		
		boardController = new BoardController();
		boardController.setBoard(board);
		boardController.setGameManager(gameManager);
		
		boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(50, 50);
		boardController.setBoardView(boardView);
		
		gameOverMessage = new GameOverMessage(gameManager);
		gameOverMessage.setXY(75, 30);
		
		mouseController = new MouseController(gameManager, boardController);
		addMouseListener(mouseController);
	}
	
	@Override
	public void paint(Graphics g) {
		boardView.paint(g);
		gameOverMessage.paint(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
