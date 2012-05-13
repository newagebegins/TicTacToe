package demo;

import java.applet.Applet;
import java.awt.Graphics;

import src.*;

@SuppressWarnings("serial")
public class BackgroundDemo extends Applet {

	@Override
	public void paint(Graphics g) {
		Background bg = new Background(this);
		setSize(Background.WIDTH, Background.HEIGHT);
		bg.paint(g);
	}

}
