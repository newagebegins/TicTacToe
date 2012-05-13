package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import src.Board;
import src.GameManager;

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

}
