package src;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Background {

	private Applet applet;
	private Image image;
	
	public Background(Applet applet) {
		this.applet = applet;
		image = applet.getImage(applet.getDocumentBase(), "images/bg.jpg");
	}
	
	public Dimension getDimension() {
		return new Dimension(image.getWidth(applet), image.getHeight(applet));
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, applet);
	}

}
