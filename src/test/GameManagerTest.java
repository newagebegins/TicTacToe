package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import src.Board;
import src.GameManager;
import src.Mark;

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

}
