package game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	
	public boolean up, down, left, right, pause;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		pause = keys[KeyEvent.VK_P];
	}
	
	// called whenever a key on the keyboard is pressed
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_P) && (keys[e.getKeyCode()]))
			keys[e.getKeyCode()] = false;
		else
			keys[e.getKeyCode()] = true;
	}

	// called whenever a key on the keyboard is released
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_P)
			keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
