package src;

import java.util.Observable;
import java.util.Observer;

public class GameManager implements Observer {
	
	private Mark currentPlayerMark = Mark.Empty;

	public void setCurrentPlayerMark(Mark currentPlayerMark) {
		this.currentPlayerMark = currentPlayerMark;
	}

	public Mark getCurrentPlayerMark() {
		return currentPlayerMark;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Board) {
			switchCurrentPlayer();
		}
	}

	private void switchCurrentPlayer() {
		Mark newMark = Mark.O;
		if (getCurrentPlayerMark() == Mark.O) {
			newMark = Mark.X;
		}
		setCurrentPlayerMark(newMark);
	}

}
