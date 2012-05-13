package test;

import static org.mockito.Mockito.*;

import java.awt.Graphics;

import org.junit.Test;

import src.*;

public class PainterTest {

	@Test
	public void shouldPaintDisplayUnits() {
		DisplayUnit displayUnitMockOne = mock(DisplayUnit.class);
		DisplayUnit displayUnitMockTwo = mock(DisplayUnit.class);
		Graphics graphicsMock = mock(Graphics.class);
		
		Painter painter = new Painter();
		painter.addDisplayUnit(displayUnitMockOne);
		painter.addDisplayUnit(displayUnitMockTwo);
		
		painter.paint(graphicsMock);
		
		verify(displayUnitMockOne, times(1)).paint(graphicsMock);
		verify(displayUnitMockTwo, times(1)).paint(graphicsMock);
	}
	
}
