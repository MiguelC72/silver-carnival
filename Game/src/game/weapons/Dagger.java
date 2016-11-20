package game.weapons;

import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;

public class Dagger extends Weapon {

	// hitbox is in front of the player
	public Dagger(Handler handler, int width, int height) {
		super(handler, width, height);
		displayTexture = Assets.dagger[0];
		pickedUp = true;
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
	public void update(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		switch(e.getLastDirection()) {
			case('f'):
				return;
			case('u'):
				attkTexture = Assets.dagger[1];
				hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
				hitbox.y = (int) (c.y - hitbox.getHeight());
				break;
			case('d'):
				attkTexture = Assets.dagger[4];
				hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
				hitbox.y = c.y + c.height;
				break;
			case('l'):
				attkTexture = Assets.dagger[3];
				hitbox.x = (int) (c.x - hitbox.getWidth());
				hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
				break;
			case('r'):
				attkTexture = Assets.dagger[2];
				hitbox.x = c.x + c.width;
				hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
				break;
			default:
				attkTexture = Assets.dagger[1];
		}
		
	}
	
	public void onCoolDown() {
		coolDown -= 2;
		if (coolDown <= 0) {
			coolDown = -1;
			attacking = false;
		}
	}
}
