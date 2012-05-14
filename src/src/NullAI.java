package src;

public class NullAI extends AI{

	@Override
	public void setBoard(Board board) {
	}

	@Override
	public void setAIMark(Mark aiMark) {
	}

	@Override
	public Cell getMoveCell() {
		return new Cell(-1,-1);
	}

}
