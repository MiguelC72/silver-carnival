package game.weapons;

import game.Handler;

public class Nuke extends Weapon {

	// hitbox is the entire screen
	public Nuke(Handler handler, int width, int height) {
		super(handler, width, height);
		damage = 9999;
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
