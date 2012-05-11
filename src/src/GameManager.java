package src;

public class GameManager {
	
	private Mark currentPlayerMark = Mark.Empty;

	public void setCurrentPlayerMark(Mark currentPlayerMark) {
		this.currentPlayerMark = currentPlayerMark;
	}

	public Mark getCurrentPlayerMark() {
		return currentPlayerMark;
	}

}
