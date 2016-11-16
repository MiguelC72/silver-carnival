package game.weapons;

import game.Handler;

public class LongSword extends Weapon {

	// hitbox is the same as the dagger
	public LongSword(Handler handler, int width, int height) {
		super(handler, width, height);
		damage = 3;
	}

	@Override
	public void die() {
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
