package src;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class TicTacToe extends Applet implements Observer {
	
	private Board board;
	private BoardView boardView;
	private BoardController boardController;
	private GameManager gameManager;
	private MouseController mouseController;
	private GameOverMessage gameOverMessage;
	
	@Override
	public void init() {
		board = new Board();
		board.addObserver(this);
		
		gameManager = new GameManager(board);
		gameManager.setCurrentPlayerMark(Mark.X);
		board.addObserver(gameManager);
		
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
