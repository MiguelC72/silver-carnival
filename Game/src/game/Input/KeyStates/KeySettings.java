package game.Input.KeyStates;

import java.awt.event.KeyEvent;

import game.Input.KeyManager;

public class KeySettings extends KeyManager {

	@Override
	public void update() {
		pause = keys[KeyEvent.VK_P];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
