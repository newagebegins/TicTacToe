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
	private Background bg;
	
	@Override
	public void init() {
		bg = new Background(this);
		setSize(Background.WIDTH, Background.HEIGHT);
		
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
		
		boardView = new BoardView(this);
		boardView.setBoard(board);
		boardView.setXY(100, 100);
		boardController.setBoardView(boardView);
		
		gameOverMessage = new GameOverMessage(this, gameManager);
		gameOverMessage.setXY(130, 10);
		
		mouseController = new MouseController(gameManager, boardController);
		addMouseListener(mouseController);
	}
	
	@Override
	public void paint(Graphics g) {
		bg.paint(g);
		boardView.paint(g);
		gameOverMessage.paint(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
