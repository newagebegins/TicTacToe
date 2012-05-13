package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.*;

public class CellTest {

	@Test
	public void testToString() {
		assertEquals("1,2", new Cell(1,2).toString());
	}

}
