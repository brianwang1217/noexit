package Game;
import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

public class Board extends JPanel implements ActionListener {
	Player p;
	Image i;
	Timer t;
	Obstacles[] o = new Obstacles[10];
	int ox;
	double dropRate;
	
	public static int wins = 0;
	
	public Board() {
		p = new Player();
		
		for (int j = 0; j < o.length; j++) {
			ox = (int)(Math.random()*925 + 100);
			dropRate = Math.random() * 1.5 + .2;
			o[j] = new Obstacles(ox, dropRate);
		}
		addKeyListener(new Listener());

		setFocusable(true);
		ImageIcon img = new ImageIcon("/images/whitebackground.png");
		i = img.getImage();
		t = new Timer(3, this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(hasCollided(p, o)) {
			p.resetX();
			p.resetY();
		}
		if (!p.hasWon()) {
			p.move();
		} else {
			wins++;
			p.resetX();
			p.resetY();
			
		}
		repaint();
	}
	
	public boolean hasCollided(Player play, Obstacles[] obs) {
		for (int i = 0; i < obs.length; i++) {
			if (play.getBounds().intersects(obs[i].getBounds())) {
				return true;
			}
		}
		return false;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D d = (Graphics2D) g;
		d.drawImage(i, 0, 0, null);
		d.drawImage(p.getImage(), p.getX(), p.getY(), null);
		d.drawImage(p.getEndImage(), p.getEndX(), p.getEndY(), null);
		for (int x = 0; x < o.length;x++) {
			if(o[x].getY() > 400.0) {
				o[x] = new Obstacles((int)(Math.random()*700 + 100), Math.random() * 1.5);
			}
			d.drawImage(o[x].getImage(), o[x].getX(), (int)o[x].getY(), null);
		}
	}
	
	private class Listener extends KeyAdapter {
		public void keyPressed(KeyEvent k) {
			p.keyPressed(k);
		}
		
		public void keyReleased(KeyEvent k) {
			p.keyReleased(k);
		}
	}
}
