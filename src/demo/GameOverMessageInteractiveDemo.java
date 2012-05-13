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
	private Painter painter;
	private GameOverMessage gameOverMessage;

	@Override
	public void init() {
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
		
		boardView = new BoardView();
		boardView.setBoard(board);
		boardView.setXY(50, 50);
		boardController.setBoardView(boardView);
		
		gameOverMessage = new GameOverMessage(gameManager);
		gameOverMessage.setXY(75, 30);
		
		painter = new Painter();
		painter.addDisplayUnit(boardView);
		painter.addDisplayUnit(gameOverMessage);
		
		mouseController = new MouseController(gameManager, boardController);
		addMouseListener(mouseController);
	}
	
	@Override
	public void paint(Graphics g) {
		painter.paint(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}