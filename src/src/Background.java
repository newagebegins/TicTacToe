package src;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Background {
	
	public static final int WIDTH = 548;
	public static final int HEIGHT = 472;

	private Applet applet;
	private Image image;
	
	public Background(Applet applet) {
		this.applet = applet;
		image = applet.getImage(applet.getDocumentBase(), "../images/bg.jpg");
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, applet);
	}

}
