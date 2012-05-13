package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Board;
import src.Cell;
import src.Mark;

public class BoardTest {
	
	Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void checkWin_EmptyBoard_NotWin() {
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_X_Win() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(0, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_O_Win() {
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(0, 1, Mark.O);
		board.setMarkInCell(0, 2, Mark.O);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_topRow_O_NotWin() {
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(0, 1, Mark.O);
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_middleRow_X_Win() {
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(1, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_bottomRow_X_Win() {
		board.setMarkInCell(2, 0, Mark.X);
		board.setMarkInCell(2, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_X_Win() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_O_Win() {
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(1, 0, Mark.O);
		board.setMarkInCell(2, 0, Mark.O);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_leftCol_O_NotWin() {
		board.setMarkInCell(0, 0, Mark.O);
		board.setMarkInCell(1, 0, Mark.O);
		board.checkWin();
		assertFalse(board.isWin());
	}
	
	@Test
	public void checkWin_middleCol_X_Win() {
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 1, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_rightCol_X_Win() {
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 2, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_diagonalOne_X_Win() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void checkWin_diagonalTwo_X_Win() {
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		assertTrue(board.isWin());
	}
	
	@Test
	public void getWinCells_Horizontal() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(0, 1, Mark.X);
		board.setMarkInCell(0, 2, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(0, 1), new Cell(0, 2) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_Vertical() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 0, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(1, 0), new Cell(2, 0) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_DiagonalOne() {
		board.setMarkInCell(0, 0, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 2, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 0), new Cell(1, 1), new Cell(2, 2) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getWinCells_DiagonalTwo() {
		board.setMarkInCell(0, 2, Mark.X);
		board.setMarkInCell(1, 1, Mark.X);
		board.setMarkInCell(2, 0, Mark.X);
		board.checkWin();
		Cell[] expected = new Cell[] { new Cell(0, 2), new Cell(1, 1), new Cell(2, 0) };
		assertArrayEquals(expected, board.getWinCells());
	}
	
	@Test
	public void getMarkCellWithWrongCoordsShouldReturnNullMark() {
		assertEquals(Mark.Null, board.getMarkInCell(0, -1));
		assertEquals(Mark.Null, board.getMarkInCell(-1, 0));
		assertEquals(Mark.Null, board.getMarkInCell(-1, -1));
	}
	
	@Test
	public void settingMarkInNotLegitimateCellShouldNotThrowAnException() {
		board.setMarkInCell(-1, 0, Mark.X);
	}
	
	@Test
	public void getWinnerMark_Win() {
		final Mark WINNER_MARK = Mark.X;
		
		board.setMarkInCell(0, 0, WINNER_MARK);
		board.setMarkInCell(0, 1, WINNER_MARK);
		board.setMarkInCell(0, 2, WINNER_MARK);
		board.checkWin();
		
		assertEquals(WINNER_MARK, board.getWinnerMark());
	}
	
	@Test
	public void getWinnerMark_NotWin() {
		board.checkWin();
		assertEquals(Mark.Null, board.getWinnerMark());
	}

}
