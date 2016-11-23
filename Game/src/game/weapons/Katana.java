package game.weapons;

import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;
import game.states.State;

public class Katana extends Weapon {

	public Katana(Handler handler, int width, int height, float x, float y) {
		super(handler, width, height);
		displayTexture = Assets.katana;
		this.x = x;
		this.y = y;
		damage = 9999;
		
	}

	@Override
	public void update(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		hitbox.x = (int) x;
		hitbox.y = (int) y;
		if (c.intersects(hitbox)) {
			State.setState(handler.getGame().getWinState());
		}
		
	}
	
	@Override
	public void onCoolDown() {
		// nothing this weapon is unusable 
		
	}

}
