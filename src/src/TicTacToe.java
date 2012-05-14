package src;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
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
	private AI ai;
	private Background background;
	private Image backbuffer;
	private Graphics backg;
	
	@Override
	public void init() {
		background = new Background(this);
		setSize(Background.WIDTH, Background.HEIGHT);
		
		backbuffer = createImage(Background.WIDTH, Background.HEIGHT);
		backg = backbuffer.getGraphics();
		
		board = new Board();
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
		update(g);
	}
	
	@Override
	public void update(Graphics g) {
		background.paint(backg);
		boardView.paint(backg);
		gameOverMessage.paint(backg);
		g.drawImage(backbuffer, 0, 0, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
}
