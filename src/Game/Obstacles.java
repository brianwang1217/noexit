package Game;
import java.awt.*;

import javax.swing.ImageIcon;

public class Obstacles {
	int x;
	double y, yChange;
	Image i;
	Rectangle bounds;
	
	public Obstacles(int xc, double drop) {
		ImageIcon img = new ImageIcon("/Users/bwang/Desktop/blacksquare.png");
		i = img.getImage();
		i = i.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		x = xc;
		y = 0;
		yChange = drop;
		bounds = new Rectangle(x, (int)y, 15, 15);
	}
	
	public Image getImage() {
		return i;
	}
	
	public void move() {
		y = y + yChange;
	}
	
	public Rectangle getBounds() {
		bounds.x = getX();
		bounds.y = (int)getY();
		return bounds;
	}
	
	public double getY() {
		y += yChange;
		return y;
	}
	
	public void setY() {
		y = 0.0;
	}
	
	public int getX() {
		return x;
	}
	
	public void update() {
		move();
	}
}
