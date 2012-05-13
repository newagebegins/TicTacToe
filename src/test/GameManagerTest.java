package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import src.*;

public class GameManagerTest {
	
	@Test
	public void isGameOver_False() {
		Board boardMock = mock(Board.class);
		when(boardMock.isWin()).thenReturn(false);
		
		GameManager gameManager = new GameManager(boardMock);
		assertFalse(gameManager.isGameOver());
	}

	@Test
	public void isGameOver_True() {
		Board boardMock = mock(Board.class);
		when(boardMock.isWin()).thenReturn(true);
		
		GameManager gameManager = new GameManager(boardMock);
		assertTrue(gameManager.isGameOver());
	}
	
	@Test
	public void getWinnerMark() {
		final Mark WINNER_MARK = Mark.X;
		Board boardMock = mock(Board.class);
		when(boardMock.getWinnerMark()).thenReturn(WINNER_MARK);
		GameManager gameManager = new GameManager(boardMock);
		
		assertEquals(WINNER_MARK, gameManager.getWinnerMark());
	}
	
	@Test
	public void resetGame_shouldResetCurrentPlayerMark() {
		Board boardMock = mock(Board.class);
		GameManager gameManager = new GameManager(boardMock);
		gameManager.setCurrentPlayerMark(Mark.O);
		
		gameManager.resetGame();
		
		assertEquals(Mark.X, gameManager.getCurrentPlayerMark());
	}
	
	@Test
	public void resetGame_shouldResetBoard() {
		Board boardMock = mock(Board.class);
		GameManager gameManager = new GameManager(boardMock);
		
		gameManager.resetGame();
		
		verify(boardMock, times(1)).reset();
	}
	
	@Test
	public void shouldMakeAIMoveAfterPlayerMadeHisMove() {
		final Mark USER_MARK = Mark.X;
		final Mark AI_MARK = Mark.O;
		final Cell AI_MOVE_CELL = new Cell(0, 2);
		Board boardMock = mock(Board.class);
		GameManager gameManager = new GameManager(boardMock);
		
		AI aiMock = mock(AI.class);
		when(aiMock.getMoveCell()).thenReturn(AI_MOVE_CELL);
		gameManager.setAI(aiMock);
		
		gameManager.update(boardMock, null);
		
		verify(boardMock, times(1)).setMarkInCell(AI_MARK, AI_MOVE_CELL);
		assertEquals(USER_MARK, gameManager.getCurrentPlayerMark());
	}

}
