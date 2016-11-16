package game.weapons;

import game.Handler;

public class Axe extends Weapon {

	// hitbox is 3 perpendicular to the front of the player
	public Axe(Handler handler, int width, int height) {
		super(handler, width, height);
		damage = 10;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
