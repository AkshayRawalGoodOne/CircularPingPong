package com.CircularPingPong;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	JFrame frame;
	static JPanel panel;
	
	public Window(double dia, Game game) {
		frame = new JFrame("Circular Ping Pong");
		frame.addComponentListener(new ComponentAdapter() {

		public void componentResized(ComponentEvent e) {

				frame.setShape(new Ellipse2D.Double(0, 0, dia, dia));
			}

		});  
		
		frame.setUndecorated(true);
		frame.add(game);
	
		frame.setSize(new Dimension((int) dia, (int) dia));
		frame.setPreferredSize(new Dimension((int) dia, (int) dia));
		frame.setMaximumSize(new Dimension((int) dia, (int) dia));
		frame.setMinimumSize(new Dimension((int) dia, (int) dia));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		game.start();
	}

}