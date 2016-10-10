package game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyManager implements KeyListener {

	protected boolean[] keys;
	private static KeyManager currentKey = null;
	
	public boolean up, down, left, right, pause;
	
	public KeyManager() {
		
		keys = new boolean[256];
	}
	
	public abstract void update() {
		
		
		
		
	}
	// called whenever a key on the keyboard is pressed
	public abstract void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
	}

	// called whenever a key on the keyboard is released
	public abstract void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
