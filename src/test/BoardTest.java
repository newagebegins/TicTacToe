package test;

import static org.junit.Assert.*;

import org.junit.*;

import src.*;

public class BoardTest {
	
	@Test
	public void checkWin_EmptyBoard_NotWin() {
		Board board = new Board();
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(0, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_O_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(0, 1, Mark.O);
		board.setMarkInCell(0, 2, Mark.O);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_O_NotWin() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(0, 1, Mark.O);
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_middleRow_X_Win() {
		Board board = new Board();
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(1, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_bottomRow_X_Win() {
		Board board = new Board();
		board.setMarkInCell(2, 0, Mark.X);
		board.setMarkInCell(2, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_O_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(1, 0, Mark.O);
		board.setMarkInCell(2, 0, Mark.O);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_O_NotWin() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(1, 0, Mark.O);
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_middleCol_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 1, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_rightCol_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 2, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_diagonalOne_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_diagonalTwo_X_Win() {
		Board board = new Board();
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void getWinCells_Horizontal() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(0, 2, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(0, 1), new Cell(0, 2) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_Vertical() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(1, 0), new Cell(2, 0) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_DiagonalOne() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(1, 1), new Cell(2, 2) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_DiagonalTwo() {
		Board board = new Board();
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 2), new Cell(1, 1), new Cell(2, 0) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getMarkCellWithWrongCoordsShouldReturnNullMark() {
		Board board = new Board();
		assertEquals(Mark.Null, board.getMarkInCell(0, -1));
		assertEquals(Mark.Null, board.getMarkInCell(-1, 0));
		assertEquals(Mark.Null, board.getMarkInCell(-1, -1));
	}
	
	@Test
	public void settingMarkInNotLegitimateCellShouldNotThrowAnException() {
		Board board = new Board();
		board.setMarkInCell(-1, 0, Mark.X);
	}
	
	@Test
	public void getWinnerMark_Win() {
		Board board = new Board();
		final Mark WINNER_MARK = Mark.X;
		
		board.setMarkInCell(0, 0, WINNER_MARK);
		board.setMarkInCell(0, 1, WINNER_MARK);
		board.setMarkInCell(0, 2, WINNER_MARK);
		board.checkWin();
		
		assertEquals(WINNER_MARK, board.getWinnerMark());
	}
	
	@Test
	public void getWinnerMark_NotWin() {
		Board board = new Board();
		board.checkWin();
		assertEquals(Mark.Null, board.getWinnerMark());
	}
	
	@Test
	public void isEmpty_False() {
		Board board = new Board();
		board.setMarkInCell(0, 0, Mark.X);
		assertFalse(board.isEmpty());
	}
	
	@Test
	public void isEmpty_True() {
		Board board = new Board();
		assertTrue(board.isEmpty());
	}
	
	@Test
	public void reset() {
		Board board = new Board();
		final Mark WINNER_MARK = Mark.X;
		board.setMarkInCell(0, 0, WINNER_MARK);
		board.setMarkInCell(0, 1, WINNER_MARK);
		board.setMarkInCell(0, 2, WINNER_MARK);
		board.checkWin();
		
		board.reset();
		
		assertTrue(board.isEmpty());
		assertFalse(board.isWin());
		assertArrayEquals(new Cell[Board.BOARD_SIZE], board.getWinCells());
		assertEquals(Mark.Null, board.getWinnerMark());
	}
	
	@Test
	public void createBoardFromString() {
		Board board = new Board(
				"XO.\n" +
				"O.X\n" +
				"X..\n"
		);
		
		assertEquals(Mark.X, board.getMarkInCell(0, 0));
		assertEquals(Mark.O, board.getMarkInCell(0, 1));
		assertEquals(Mark.Empty, board.getMarkInCell(0, 2));
		
		assertEquals(Mark.O, board.getMarkInCell(1, 0));
		assertEquals(Mark.Empty, board.getMarkInCell(1, 1));
		assertEquals(Mark.X, board.getMarkInCell(1, 2));
		
		assertEquals(Mark.X, board.getMarkInCell(2, 0));
		assertEquals(Mark.Empty, board.getMarkInCell(2, 1));
		assertEquals(Mark.Empty, board.getMarkInCell(2, 2));
	}
	
	@Test
	public void isDraw() {
		Board board = new Board(
				"XXO\n" +
				"OXX\n" +
				"XOO\n"
		);
		
		assertTrue(board.isDraw());
	}
	
}
