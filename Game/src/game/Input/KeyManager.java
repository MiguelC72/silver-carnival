package game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	
	public boolean up, down, left, right;
	
	public KeyManager() {
		
		keys = new boolean[256];
	}
	
	public void update() {
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
	}
	// called whenever a key on the keyboard is pressed
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
	}

	// called whenever a key on the keyboard is released
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

	public void keyTyped(KeyEvent arg0) {
		
		
	}

}