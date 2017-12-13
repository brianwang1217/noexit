package Game;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class Background {
	
	private Board board1;
	
	private boolean game = true;
	public Background() {	
		JFrame f = new JFrame("game");
		board1 = new Board();
		f.add(board1);

		JLabel l = new JLabel();
		l.setVerticalTextPosition(0);
		l.setHorizontalTextPosition(0);
		l.setText("Score: " + board1.wins);
		l.setBorder(new EmptyBorder(0,10,0,0));
		
		JLabel deaths = new JLabel();
		deaths.setVerticalTextPosition(0);
		deaths.setHorizontalTextPosition(0);
		deaths.setText("Deaths: " + board1.deaths);
		deaths.setBorder(new EmptyBorder(0,10,0,0));
		
		JPanel score = new JPanel();
		score.add(l);
		score.add(deaths);
		f.add(score, BorderLayout.NORTH);
			
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 400);
		//Container c = f.getContentPane();
		//c.setBackground(Color.red);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		while(game)
		{
			l.setText("Score: " + board1.wins);
			deaths.setText("Deaths: " + board1.deaths);
			score.repaint();
		}

		
	}
	
	public static void main(String[] args) {
		new Background();
	}
}
