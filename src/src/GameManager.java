package src;

public class GameManager {
	
	private Mark currentPlayerMark;
	private Board board;
	private AI ai;

	public GameManager(Board board) {
		this.board = board;
		initGame();
	}
	
	public void setAI(AI ai) {
		this.ai = ai;
	}

	public void setCurrentPlayerMark(Mark currentPlayerMark) {
		this.currentPlayerMark = currentPlayerMark;
	}

	public Mark getCurrentPlayerMark() {
		return currentPlayerMark;
	}

	private void switchCurrentPlayer() {
		Mark newMark = Mark.O;
		if (getCurrentPlayerMark() == Mark.O) {
			newMark = Mark.X;
		}
		setCurrentPlayerMark(newMark);
	}

	public boolean isGameOver() {
		return board.isWin();
	}

	public Mark getWinnerMark() {
		return board.getWinnerMark();
	}

	public void resetGame() {
		initGame();
		board.reset();
	}
	
	private void initGame() {
		currentPlayerMark = Mark.X;
	}

	public void makeAIMove() {
		switchCurrentPlayer();
		board.setMarkInCell(getCurrentPlayerMark(), ai.getMoveCell());
		switchCurrentPlayer();
	}

}
