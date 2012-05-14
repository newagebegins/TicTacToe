package src;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class GameOverMessage {

	private Applet applet;
	private GameManager gameManager;
	private int x;
	private int y;
	private Image winsImg;
	private Image oImg;
	private Image xImg;
	private Image drawImg;

	public GameOverMessage(Applet applet, GameManager gameManager) {
		this.applet = applet;
		this.gameManager = gameManager;
		this.x = 0;
		this.y = 0;
		winsImg = applet.getImage(getClass().getResource("images/wins.png"));
		oImg = applet.getImage(getClass().getResource("images/o.png"));
		xImg = applet.getImage(getClass().getResource("images/x.png"));
		drawImg = applet.getImage(getClass().getResource("images/draw.png"));
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		if (!gameManager.isGameOver()) {
			return;
		}
		
		if (gameManager.isDraw()) {
			g.drawImage(drawImg, x, y, applet);
		}
		else {
			Image markImg = xImg;
			if (gameManager.getWinnerMark() == Mark.O) {
				markImg = oImg;
			}
			g.drawImage(markImg, x, y+20, applet);
			g.drawImage(winsImg, x+85, y, applet);
		}
	}

}
