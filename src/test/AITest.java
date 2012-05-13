package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.*;

public class AITest {

	@Test
	public void winningMove_Horizontal_1() {
		checkMove(	"OO.\n" +
					"...\n" +
					"...\n", new Cell(0, 2));
	}
	
	@Test
	public void winningMove_Horizontal_2() {
		checkMove(	"O.O\n" +
					"...\n" +
					"...\n", new Cell(0, 1));
	}
	
	@Test
	public void winningMove_Horizontal_3() {
		checkMove(	".OO\n" +
					"...\n" +
					"...\n", new Cell(0, 0));
	}
	
	@Test
	public void winningMove_Horizontal_4() {
		checkMove(	"...\n" +
					"OO.\n" +
					"...\n", new Cell(1, 2));
	}
	
	@Test
	public void winningMove_Horizontal_5() {
		checkMove(	"...\n" +
					"...\n" +
					".OO\n", new Cell(2, 0));
	}
	
	@Test
	public void winningMove_Vertical_1() {
		checkMove(	"O..\n" +
					"O..\n" +
					"...\n", new Cell(2, 0));
	}
	
	@Test
	public void winningMove_Vertical_2() {
		checkMove(	".O.\n" +
					"...\n" +
					".O.\n", new Cell(1, 1));
	}
	
	@Test
	public void winningMove_DiagonalOne_1() {
		checkMove(	"O..\n" +
					".O.\n" +
					"...\n", new Cell(2, 2));
	}
	
	@Test
	public void winningMove_DiagonalOne_2() {
		checkMove(	"O..\n" +
					"...\n" +
					"..O\n", new Cell(1, 1));
	}
	
	@Test
	public void winningMove_DiagonalTwo_1() {
		checkMove(	"..O\n" +
					".O.\n" +
					"...\n", new Cell(2, 0));
	}
	
	@Test
	public void winningMove_DiagonalTwo_2() {
		checkMove(	"..O\n" +
					"...\n" +
					"O..\n", new Cell(1, 1));
	}
	
	@Test
	public void winningMove_DiagonalTwo_3() {
		checkMove(	"...\n" +
					".O.\n" +
					"O..\n", new Cell(0, 2));
	}
	
	@Test
	public void blockingMove_Horizontal() {
		checkMove(	"XX.\n" +
					"...\n" +
					"...\n", new Cell(0, 2));
	}
	
	@Test
	public void blockingMove_Vertical() {
		checkMove(	"X..\n" +
					"...\n" +
					"X..\n", new Cell(1, 0));
	}
	
	@Test
	public void winningMovesHasHigherPriorityThanBlockingMoves() {
		checkMove(	"X.O\n" +
					"...\n" +
					"X.O\n", new Cell(1, 2));
	}
	
	@Test
	public void randomMove() {
		Board board = new Board(
				"X.O\n" +
				"...\n" +
				"...\n");
		AI ai = new AI();
		ai.setBoard(board);
		ai.setAIMark(Mark.O);
		
		assertTrue(ai.getMoveCell() != null);
		assertFalse(ai.getMoveCell().equals(new Cell(0,0)));
		assertFalse(ai.getMoveCell().equals(new Cell(0,2)));
	}
	
	@Test
	public void randomMove_Draw_ShouldReturnNullCell() {
		Board board = new Board(
				"XXO\n" +
				"OXX\n" +
				"XOO\n"
		);
		AI ai = new AI();
		ai.setBoard(board);
		ai.setAIMark(Mark.O);
		
		assertTrue(ai.getMoveCell() instanceof NullCell);
	}
	
	private void checkMove(String boardStr, Cell expectedMove) {
		Board board = new Board(boardStr);
		AI ai = new AI();
		ai.setBoard(board);
		ai.setAIMark(Mark.O);
		
		assertEquals(expectedMove, ai.getMoveCell());
	}

}
