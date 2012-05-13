package test;

import static org.mockito.Mockito.*;

import java.awt.event.MouseEvent;

import org.junit.Test;

import src.BoardController;
import src.GameManager;
import src.MouseController;

public class MouseControllerTest {

	@Test
	public void shouldDelegateMousePressEventToBoardControllerWhenGameIsNotOver() {
		BoardController boardControllerMock = mock(BoardController.class);
		MouseEvent mouseEventMock = mock(MouseEvent.class);
		
		GameManager gameManagerMock = mock(GameManager.class);
		when(gameManagerMock.isGameOver()).thenReturn(false);
		
		MouseController mouseController = new MouseController(gameManagerMock, boardControllerMock);
		
		mouseController.mousePressed(mouseEventMock);
		
		verify(boardControllerMock, times(1)).mousePressed(mouseEventMock);
	}
	
	@Test
	public void shouldNotDelegateMousePressEventToBoardControllerWhenGameIsOver() {
		BoardController boardControllerMock = mock(BoardController.class);
		MouseEvent mouseEventMock = mock(MouseEvent.class);
		
		GameManager gameManagerMock = mock(GameManager.class);
		when(gameManagerMock.isGameOver()).thenReturn(true);
		
		MouseController mouseController = new MouseController(gameManagerMock, boardControllerMock);
		
		mouseController.mousePressed(mouseEventMock);
		
		verify(boardControllerMock, never()).mousePressed(mouseEventMock);
	}

}
