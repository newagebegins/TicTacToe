package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Board;
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

}
