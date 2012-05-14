package demo;

import java.applet.Applet;
import java.awt.Graphics;

import src.*;

@SuppressWarnings("serial")
public class GameOverMessageNotInteractiveDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		Background bg = new Background(this);
		setSize(Background.WIDTH, Background.HEIGHT);
		
		Board board = new Board();
		final Mark WINNER_MARK = Mark.X;
		board.setMarkInCell(0, 0, WINNER_MARK);
		board.setMarkInCell(0, 1, WINNER_MARK);
		board.setMarkInCell(0, 2, WINNER_MARK);
		board.checkWin();
		
		GameManager gameManager = new GameManager(board);
		GameOverMessage gameOverMessage = new GameOverMessage(this, gameManager);
		gameOverMessage.setXY(130, 10);
		
		bg.paint(g);
		gameOverMessage.paint(g);
	}

}
