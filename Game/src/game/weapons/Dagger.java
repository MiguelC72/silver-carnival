package game.weapons;

import game.Handler;

public class Dagger extends Weapon {

	public Dagger(Handler handler, int width, int height) {
		super(handler, width, height);
		
	}

	@Override
	public void die() {
		// does nothing, shouldn't be called
		
	}
	
	@Override
	public void hurt() {
		// does nothing since this is the default weapon
	}
}
