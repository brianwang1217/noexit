package Game;
import java.awt.*;

import javax.swing.*;

public class Background {
	public Background() {	
		JFrame f = new JFrame("game");
		f.add(new Board());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 400);
		//Container c = f.getContentPane();
		//c.setBackground(Color.red);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Background();
	}
}
