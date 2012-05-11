package src;

public class NullBoard extends Board {

	@Override
	public void setXMarkInCell(int row, int col) {
	}

	@Override
	public void setOMarkInCell(int row, int col) {
	}

	@Override
	public void removeMarkInCell(int row, int col) {
	}

	@Override
	public Mark getMarkInCell(int row, int col) {
		return Mark.Empty;
	}

	@Override
	public boolean cellIsNotEmpty(int row, int col) {
		return false;
	}

}
