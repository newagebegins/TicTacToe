package src;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardController implements MouseListener {

	private Board board;
	private GameManager gameManager;

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
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
		Cell cell = getCellAt(e.getPoint());
		if (board.cellIsNotEmpty(cell)) {
			return;
		}
		board.setMarkInCell(gameManager.getCurrentPlayerMark(), cell);
		board.checkWin();
	}

	private Cell getCellAt(Point point) {
		if (!BoardView.BOARD_RECT.contains(point)) {
			return new NullCell();
		}
		
		int row = (point.y - BoardView.BOARD_Y_PX) / BoardView.CELL_SIZE_PX;
		int col = (point.x - BoardView.BOARD_X_PX) / BoardView.CELL_SIZE_PX;
		
		return new Cell(row, col);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
