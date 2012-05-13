package src;

import java.awt.Graphics;
import java.util.ArrayList;

public class Painter {
	
	ArrayList<DisplayUnit> displayUnits = new ArrayList<DisplayUnit>();

	public void paint(Graphics g) {
		for (DisplayUnit displayUnit : displayUnits) {
			displayUnit.paint(g);
		}
	}

	public void addDisplayUnit(DisplayUnit displayUnit) {
		displayUnits.add(displayUnit);
	}

}
