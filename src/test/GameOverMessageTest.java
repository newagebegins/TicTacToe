package test;

import static org.mockito.Mockito.*;

import java.awt.Graphics;

import org.junit.Test;

import src.*;

public class GameOverMessageTest {

	@Test
	public void shouldNotBeDisplayedIfGameIsNotOver() {
		GameManager gameManagerMock = mock(GameManager.class);
		when(gameManagerMock.isGameOver()).thenReturn(false);
		
		Graphics graphicsMock = mock(Graphics.class);
		GameOverMessage gameOverMessage = new GameOverMessage(gameManagerMock);
		
		gameOverMessage.paint(graphicsMock);
		
		verifyZeroInteractions(graphicsMock);
	}

}
