package game.weapons;

import game.Handler;

public class BallNChain extends Weapon {

	// hitbox is 1 tile away from the player
	public BallNChain(Handler handler, int width, int height) {
		super(handler, width, height);
		damage = 6;
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
