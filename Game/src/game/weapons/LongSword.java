package game.weapons;

import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;

public class LongSword extends Weapon {

	// hitbox is the same as the dagger
	public LongSword(Handler handler, int width, int height, float x, float y) {
		super(handler, width, height);
		displayTexture = Assets.longSword[0];
		this.x = x;
		this.y = y;
		damage = 3;
	}

	@Override
	public void die() {
		
		
	}
	
	@Override
	public void update(Entity e) {
		if (pickedUp) {
			Rectangle c = e.getCollisionBounds(0, 0);
			switch(e.getLastDirection()) {
				case('f'):
					return;
				case('u'):
					attkTexture = Assets.longSword[1];
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = (int) (c.y - hitbox.getHeight());
					break;
				case('d'):
					attkTexture = Assets.longSword[4];
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = c.y + c.height;
					break;
				case('l'):
					attkTexture = Assets.longSword[3];
					hitbox.x = (int) (c.x - hitbox.getWidth());
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				case('r'):
					attkTexture = Assets.longSword[2];
					hitbox.x = c.x + c.width;
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				default:
					attkTexture = Assets.longSword[1];
			}
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
