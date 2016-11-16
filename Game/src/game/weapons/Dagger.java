package game.weapons;

import game.Handler;

public class Dagger extends Weapon {

	// hitbox is in front of the player
	public Dagger(Handler handler, int width, int height) {
		super(handler, width, height);
		
		damage = 1;
	}

	@Override
	public void die() {
		// does nothing, shouldn't be called
		
	}
	
	@Override
	public void hurt() {
		// does nothing since this is the default weapon
	}

	@Override
	public void update() {
		coolDown -= 2;
		if (coolDown <= 0) {
			coolDown = -1;
		}
		
	}
}
