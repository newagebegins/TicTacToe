package demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import src.*;

@SuppressWarnings("serial")
public class GameOverMessageInteractiveDemo extends Applet implements Observer {
	
	private Board board;
	private BoardView boardView;
	private BoardController boardController;
	private GameManager gameManager;
	private MouseController mouseController;
	private GameOverMessage gameOverMessage;
	private Background bg;

	@Override
	public void init() {
		bg = new Background(this);
		setSize(Background.WIDTH, Background.HEIGHT);
		
		board = new Board();
		board.addObserver(this);
		
		final Mark WINNER_MARK = Mark.X;
		board.setMarkInCell(0, 0, WINNER_MARK);
		board.setMarkInCell(0, 1, WINNER_MARK);
		
		gameManager = new GameManager(board);
		gameManager.setCurrentPlayerMark(Mark.X);
		
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
