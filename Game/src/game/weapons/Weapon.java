package game.weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.entities.Entity;

public abstract class Weapon {
	
	protected Handler handler;
	protected BufferedImage texture;
	protected Rectangle hitbox;
	public static final int DEFAULT_DURABILITY = 10;
	public static final int DEFAULT_COOLDOWN = 10;
	protected int coolDown;
	protected boolean notBroken = true;
	protected int durability;
	
	
	public Weapon(Handler handler, int width, int height) {
		
		this.handler = handler;
		durability = DEFAULT_DURABILITY;
		coolDown = DEFAULT_COOLDOWN;
		
		hitbox = new Rectangle(0, 0, width, height);
		
	}
	
	public void attk(Entity e) {
		Rectangle c = e.getCollisionBounds(0, 0);
		
		if (e.getLastDirection() != 'f') {
			if (e.getLastDirection() == 'u') {
				hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
				hitbox.y = (int) (c.y - hitbox.getHeight());
			} else if (e.getLastDirection() == 'd') {
				hitbox.x = (int) (c.x + c.width / 2 - hitbox.getWidth() / 2);
				hitbox.y = c.y + c.height;
			} else if (e.getLastDirection() == 'l') {
				hitbox.x = (int) (c.x - hitbox.getWidth());
				hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
			} else if (e.getLastDirection() == 'r') {
				hitbox.x = c.x + c.width;
				hitbox.y = (int) (c.y + c.height / 2 - hitbox.getHeight() / 2);
			} else {
				return;
			}
		}

		for(Entity ent : handler.getWorld().getEntityManager().getEntities()) {
			if (ent.equals(e))
				continue;
			
			if (ent.getCollisionBounds(0, 0).intersects(hitbox)) {
				ent.hurt();
			}
		}
	}
	
	public abstract void die();
	
	public void hurt() {
		durability--;
		if  (durability <= 0) {
			notBroken = false;
			die();
		}
	}
	
	public void render(Graphics g) {
		
		// draws a border box and durability box
		g.setColor(Color.black);
		g.fillRect((int) (handler.getWidth() - 455)
				, (int) (handler.getHeight() - 75), (10 * this.DEFAULT_DURABILITY) + 10, 40);
		g.setColor(Color.green);
		g.fillRect((int) (handler.getWidth() - 450)
				, (int) (handler.getHeight() - 70), (10 * this.durability), 30);
	}
}
