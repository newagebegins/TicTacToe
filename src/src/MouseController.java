package src;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController  implements MouseListener {

	private GameManager gameManager;
	private BoardController boardController;
	
	public MouseController(GameManager gameManager, BoardController boardController) {
		this.gameManager = gameManager;
		this.boardController = boardController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (gameManager.isGameOver()) {
			gameManager.resetGame();
		}
		else {
			boardController.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
