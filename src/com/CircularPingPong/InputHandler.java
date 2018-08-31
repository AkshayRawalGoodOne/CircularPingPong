package com.CircularPingPong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.CircularPingPong.Game.ID;

public class InputHandler implements KeyListener {

	Handler handler;
	static boolean[] keys = new boolean[2];
	
	public InputHandler(Handler handler) {

		this.handler = handler;
	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < handler.entity.size(); i++) {
			Entity object = handler.entity.get(i);
			if (object.id == ID.Player) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					keys[0] = true;
					object.setAV(2);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					keys[1] = true;
					object.setAV(-2);
				}
			}
				
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		for (int i = 0; i < handler.entity.size(); i++) {
			Entity object = handler.entity.get(i);
			if (object.id == ID.Player) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					keys[0] = false;
					object.setAV(0);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					keys[1] = false;
					object.setAV(0);
				}

			}
		}
	}

}
