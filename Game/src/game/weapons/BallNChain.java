package game.weapons;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.Tiles.Tile;
import game.entities.Entity;
import game.gfx.Assets;

public class BallNChain extends Weapon {

	private BufferedImage ballTexture;
	// hitbox is 1 tile away from the player
	public BallNChain(Handler handler, int width, int height, float x, float y) {
		super(handler, width, height);
		displayTexture = Assets.ballNChain[0];
		attkTexture = Assets.ballNChain[0];
		ballTexture = Assets.ballNChain[1];
		this.x = x;
		this.y = y;
		damage = 6;
	}

	@Override
	public void update(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		if (pickedUp) {
			switch(e.getLastDirection()) {
				case('f'):
					return;
				case('u'):
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = (int) (c.y - hitbox.getHeight() - Tile.TILEHEIGHT);
					break;
				case('d'):
					hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
					hitbox.y = c.y + c.height + Tile.TILEHEIGHT;
					break;
				case('l'):
					hitbox.x = (int) (c.x - hitbox.getWidth() - Tile.TILEWIDTH);
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				case('r'):
					hitbox.x = c.x + c.width + Tile.TILEWIDTH;
					hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
					break;
				default:
					return;
			}
		} else {
			hitbox.x = (int) (x - handler.getGameCamera().getxOffset());
			hitbox.y = (int) (y - handler.getGameCamera().getyOffset());
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
				g.drawImage(attkTexture, (int) x, (int) (y + Tile.TILEHEIGHT), null);
				break;
			case('d'):
				g.drawImage(attkTexture, (int) x, (int) (y - Tile.TILEHEIGHT), null);
				break;
			case('l'):
				g.drawImage(attkTexture, (int) (x + Tile.TILEWIDTH), (int) y, null);
				break;
			case('r'):
				g.drawImage(attkTexture, (int) (x - Tile.TILEWIDTH), (int) y, null);
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
					g.drawImage(ballTexture, (int) x, (int) y, null);
					break;
				case('d'):
					g.drawImage(ballTexture, (int) x, (int) y, null);
					break;
				case('l'):
					g.drawImage(ballTexture, (int) x, (int) y, null);
					break;
				case('r'):
					g.drawImage(ballTexture, (int) x, (int) y, null);
					break;
				default:
					return;
			}
		}
	}

	@Override
	public void hurt() {
		durability -= 3;
		if  (durability <= 0) {
			die();
		}
	}
	
	@Override
	public void onCoolDown() {
		coolDown -= 2;
		if (coolDown <= 0) {
			coolDown = -1;
			attacking = false;
		}
	}

}
