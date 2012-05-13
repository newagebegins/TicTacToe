package src;

import java.awt.Graphics;

public class GameOverMessage {

	private GameManager gameManager;
	private int x;
	private int y;

	public GameOverMessage(GameManager gameManager) {
		this.gameManager = gameManager;
		this.x = 0;
		this.y = 0;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		if (!gameManager.isGameOver()) {
			return;
		}
		String str = gameManager.getWinnerMark().toString() + " Wins!";
		g.drawString(str, x, y);
	}

}
