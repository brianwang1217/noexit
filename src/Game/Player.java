package Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class Player {
	int x;
	int y;
	int xChange;
	Image im;
	
	private Rectangle bounds;
	
	final int endx = 1000;
	final int endy = 350;
	Image endi;
	
	public Player() {
		//player
		ImageIcon img = new ImageIcon("/Users/bwang/Desktop/bluesquare.png");
		im = img.getImage();
		im = im.getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		x = 10;
		y = 350;
		
		bounds = new Rectangle(x, y, 10, 10);
		
		ImageIcon ig = new ImageIcon("/Users/bwang/Desktop/greensquare.png");
		endi = ig.getImage();
		endi = endi.getScaledInstance(10, 10, Image.SCALE_DEFAULT);
	}
	
	public int getEndX() {
		return endx;
	}
	
	public int getEndY() {
		return endy;
	}
	
	public Image getEndImage() {
		return endi;
	}
	
	public void move() {
		x = x + xChange;
	}
	
	public Rectangle getBounds() {
		bounds.x = getX();
		bounds.y = getY();
		return bounds;
	}
	
	public int getX() {
		return x;
	}
	
	public void resetX() {
		x = 10;
	}
	
	public void resetY() {
		y = 350;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return im;
	}
	
	public void setImage() {
		im = null;
	}
	
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			xChange = -1;
		}
		if (key == KeyEvent.VK_RIGHT) {
			xChange = 1;
		}
	}
	
	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			xChange = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			xChange = 0;
		}
	}
	
	public boolean hasWon() {
		return x == endx && y == endy;
	}
}
