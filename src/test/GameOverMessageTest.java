package test;

import static org.mockito.Mockito.*;

import java.applet.Applet;
import java.awt.Graphics;

import org.junit.Test;

import src.*;

public class GameOverMessageTest {

	@Test
	public void shouldNotBeDisplayedIfGameIsNotOver() {
		Applet appletMock = mock(Applet.class);
		GameManager gameManagerMock = mock(GameManager.class);
		when(gameManagerMock.isGameOver()).thenReturn(false);
		
		Graphics graphicsMock = mock(Graphics.class);
		GameOverMessage gameOverMessage = new GameOverMessage(appletMock, gameManagerMock);
		
		gameOverMessage.paint(graphicsMock);
		
		verifyZeroInteractions(graphicsMock);
	}

}
