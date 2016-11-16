package game.weapons;

import game.Handler;

public class Spear extends Weapon {

	// extends 2 tiles in front of the player
	public Spear(Handler handler, int width, int height) {
		super(handler, width, height);
		damage = 3;
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
