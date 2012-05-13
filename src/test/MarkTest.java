package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Mark;

public class MarkTest {

	@Test
	public void testToString() {
		assertEquals("X", Mark.X.toString());
		assertEquals("O", Mark.O.toString());
	}

}
