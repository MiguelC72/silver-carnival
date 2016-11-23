package game.weapons;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.Tiles.Tile;
import game.entities.Entity;
import game.gfx.Assets;

public class Axe extends Weapon {

	// hitbox is 3 perpendicular to the front of the player
	public Axe(Handler handler, int width, int height, float x, float y) {
		super(handler, width, height);
		displayTexture = Assets.axe[0];
		this.x = x;
		this.y = y;
		damage = 10;
	}
	
	@Override
	public void update(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		if (pickedUp) {
			switch(e.getLastDirection()) {
				case('f'):
					return;
				case('u'):
					attkTexture = Assets.axe[1];
					hitbox.width = width*3;
					hitbox.height = height;
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = (int) (c.y - hitbox.getHeight());
					break;
				case('d'):
					attkTexture = Assets.axe[4];
					hitbox.width = width*3;
					hitbox.height = height;
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = c.y + c.height;
					break;
				case('l'):
					attkTexture = Assets.axe[3];
					hitbox.width = width;
					hitbox.height = height*3;
					hitbox.x = (int) (c.x - hitbox.getWidth());
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				case('r'):
					attkTexture = Assets.axe[2];
					hitbox.width = width;
					hitbox.height = height*3;
					hitbox.x = c.x + c.width;
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				default:
					attkTexture = Assets.axe[1];
			}
		} else {
			hitbox.x = (int) x;
			hitbox.y = (int) y;
			if (c.intersects(hitbox)) {
				e.setNewWeapon(this);
				pickedUp = true;
			}
				
		}
	}
	
	@Override
	public void render(Graphics g, float x, float y) {
		if (!attacking) {
				switch(handler.getWorld().getEntityManager().getPlayer().getLastDirection()) {
				case('f'):
					return;
				case('u'):
					g.drawImage(attkTexture, (int) (x + Tile.TILEWIDTH), (int) y, null);
					break;
				case('d'):
					g.drawImage(attkTexture, (int) (x + Tile.TILEWIDTH), (int) y, null);
					break;
				case('l'):
					g.drawImage(attkTexture, (int) x, (int) (y + Tile.TILEHEIGHT), null);
					break;
				case('r'):
					g.drawImage(attkTexture, (int) x, (int) (y + Tile.TILEHEIGHT), null);
					break;
				default:
					return;
			}
		}
		else {
			switch(handler.getWorld().getEntityManager().getPlayer().getLastDirection()) {
				case('f'):
					return;
				case('u'):
					g.drawImage(attkTexture, (int) (x + Tile.TILEWIDTH), (int) (y - (Tile.TILEHEIGHT / 2)), null);
					break;
				case('d'):
					g.drawImage(attkTexture, (int) (x + Tile.TILEWIDTH), (int) (y + (Tile.TILEHEIGHT / 2)), null);
					break;
				case('l'):
					g.drawImage(attkTexture, (int) (x - (Tile.TILEWIDTH / 2)), (int) (y + Tile.TILEHEIGHT), null);
					break;
				case('r'):
					g.drawImage(attkTexture, (int) (x + (Tile.TILEWIDTH / 2)), (int) (y + Tile.TILEHEIGHT), null);
					break;
				default:
					return;
			}
		}
	}
	
	@Override
	public void hurt() {
		durability -= 4;
		if  (durability <= 0) {
			die();
		}
	}
	
	@Override
	public void onCoolDown() {
		coolDown -= 1;
		if (coolDown <= 0) {
			coolDown = -1;
			attacking = false;
		}
	}

}
