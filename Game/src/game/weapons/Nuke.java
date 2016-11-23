package game.weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;

public class Nuke extends Weapon {

	// hitbox is the entire screen
	public Nuke(Handler handler, int width, int height, float x, float y) {
		super(handler, width, height);
		//displayTexture = Assets.nuke;
		this.x = x;
		this.y = y;
		damage = 9999;
	}
	
	@Override
	public void hurt() {
		durability -= DEFAULT_DURABILITY;
		die();
	}

	@Override
	public void update(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		if (pickedUp) {
			hitbox.x = 0;
			hitbox.y = 0;
			hitbox.width = handler.getGame().getWidth();
			hitbox.height = handler.getGame().getHeight();
			//attkTexture = Assets.nuke;
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
	public void attk(Entity e) {
		attacking = true;
		for(Entity ent : handler.getWorld().getEntityManager().getEntities()) {
			if (ent.equals(e))
				continue;
			
			if (ent.getCollisionBounds(0, 0).intersects(hitbox)) {
				ent.hurt();
			}
		}
		this.hurt();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void render(Graphics g) {
		if (pickedUp) {
			Rectangle c = handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0);
			int x;
			int y;
			
			switch(handler.getWorld().getEntityManager().getPlayer().getLastDirection()) {
				case('u'):
					x = (int) (c.x + c.width / 2 - 20 / 2);
					y = (int) (c.y - 20);
					break;
				case('d'):
					x = (int) (c.x + c.width / 2 - 20 / 2);
					y = c.y + c.height;
					break;
				case('l'):
					x = (int) (c.x - 20);
					y = (int) (c.y + c.height / 2 - 20 / 2);
					break;
				case('r'):
					x = c.x + c.width;
					y = (int) (c.y + c.height / 2 - 20 / 2);
					break;
				default:
					return;
			}
			render(g, (x - handler.getGameCamera().getxOffset())
					, (y - handler.getGameCamera().getyOffset()));
			
			// draws a border box and durability box
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 455)
					, (int) (handler.getHeight() - 75), (5 * this.DEFAULT_DURABILITY) + 10, 25);
			g.setColor(Color.green);
			g.fillRect((int) (handler.getWidth() - 450)
					, (int) (handler.getHeight() - 70), (5 * this.durability), 15);
			
			// draws a border box and the weapon's cooldown if it's on cooldown
			
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 455)
					, (int) (handler.getHeight() - 55), (5 * this.DEFAULT_COOLDOWN) + 10, 25);
			
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 495)
					, (int) (handler.getHeight() - 75), 40, 45);
			g.drawImage(displayTexture, (int) (handler.getWidth() - 490)
					, (int) (handler.getHeight() - 72), null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
			g.drawImage(displayTexture, (int) (x - handler.getGameCamera().getxOffset())
					, (int) (y - handler.getGameCamera().getyOffset()), null);
		}
	}
	
	@Override
	public void render(Graphics g, float x, float y) {
		if (!attacking)
			g.drawImage(attkTexture, (int) x, (int) y, null);
		else {
			switch(handler.getWorld().getEntityManager().getPlayer().getLastDirection()) {
				case('f'):
					return;
				case('u'):
					g.drawImage(attkTexture, (int) x, (int) (y - 10), null);
					break;
				case('d'):
					g.drawImage(attkTexture, (int) x, (int) (y + 10), null);
					break;
				case('l'):
					g.drawImage(attkTexture, (int) (x - 10), (int) y, null);
					break;
				case('r'):
					g.drawImage(attkTexture, (int) (x + 10), (int) y, null);
					break;
				default:
					return;
			}
		}
	}

	@Override
	public void onCoolDown() {
		// nothing
		
	}

}
