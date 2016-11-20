package game.weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.entities.Entity;

public abstract class Weapon {
	
	//handler
	protected Handler handler;
	//images
	protected BufferedImage displayTexture;
	protected BufferedImage attkTexture;
	//durability
	public static final int DEFAULT_DURABILITY = 10;
	protected boolean notBroken = true;
	protected int durability;
	//cooldown
	public static final int DEFAULT_COOLDOWN = 10;
	protected boolean attacking = false;
	protected int coolDown;
	//hitbox
	protected Rectangle hitbox;
	//location
	protected float x, y;
	//other
	protected int damage;
	protected boolean pickedUp = false;
	
	public Weapon(Handler handler, int width, int height) {
		
		this.handler = handler;
		durability = DEFAULT_DURABILITY;
		coolDown = -1;
		
		hitbox = new Rectangle(0, 0, width, height);
		
	}
	
	public abstract void update(Entity e);
	
	public void attk(Entity e) {
		if (coolDown == -1) {
			attacking = true;
			for(Entity ent : handler.getWorld().getEntityManager().getEntities()) {
				if (ent.equals(e))
					continue;
				
				if (ent.getCollisionBounds(0, 0).intersects(hitbox)) {
					ent.hurt();
				}
			}
			coolDown = DEFAULT_COOLDOWN;
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
		
		if (pickedUp) {
			render(g, (hitbox.x - handler.getGameCamera().getxOffset())
					, (hitbox.y - handler.getGameCamera().getyOffset()));
			
			// draws a border box and durability box
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 455)
					, (int) (handler.getHeight() - 75), (10 * this.DEFAULT_DURABILITY) + 10, 25);
			g.setColor(Color.green);
			g.fillRect((int) (handler.getWidth() - 450)
					, (int) (handler.getHeight() - 70), (10 * this.durability), 15);
			
			// draws a border box and the weapon's cooldown if it's on cooldown
			
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 455)
					, (int) (handler.getHeight() - 55), (10 * this.DEFAULT_COOLDOWN) + 10, 25);
			if (coolDown != -1) {
				g.setColor(Color.blue);
				g.fillRect((int) (handler.getWidth() - 450)
						, (int) (handler.getHeight() - 50), (10 * this.coolDown), 15);
			}
			g.setColor(Color.black);
			g.fillRect((int) (handler.getWidth() - 485)
					, (int) (handler.getHeight() - 65), 30, 30);
			g.drawImage(displayTexture, (int) (handler.getWidth() - 480)
					, (int) (handler.getHeight() - 60), null);
		} else {
			render(g, (x - handler.getGameCamera().getxOffset())
					, (y - handler.getGameCamera().getyOffset()));
		}
	}
	
	public void render(Graphics g, float x, float y) {
		if (pickedUp) {
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
		} else {
			g.drawImage(displayTexture, (int) x, (int) y, null);
		}
	}
	
	public int getCoolDown() {
		return coolDown;
	}
	
	public int getDamage() {
		return damage;
	}
	public abstract void onCoolDown();
}
