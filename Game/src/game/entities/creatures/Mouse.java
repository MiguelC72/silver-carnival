package game.entities.creatures;

import java.awt.Graphics;
import java.util.Random;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;
//Random
public class Mouse extends Creature{
	
	private Random random;
	private int sleep = 0, direction = 5;
	
	public Mouse(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 8;
		bounds.y = 15;
		bounds.width = 25;
		bounds.height = 20;
		random = new Random();
		health = 10;
		this.speed = 3.0f; //20.0f;
	}
	
	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera();
	}
	
	public void getInput() {
		
		xMove = 0;
		yMove = 0;
		
		float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
		float playerY = handler.getWorld().getEntityManager().getPlayer().getY();
		
		double distance = Math.hypot(x - playerX , y - playerY);
		
		if (distance <= 4 * Tile.TILEWIDTH) 
		{
			//System.out.println("noticed");
			if (x < playerX)
			    xMove = speed;
			else if (x > playerX)
			    xMove = -speed;

			if (y < playerY)
			    yMove = speed;
			else if (y > playerY)
			    yMove = -speed;
		} else {
			if (sleep < 15) {
				sleep++;
				direction = random.nextInt(4);
			} else {
				if (sleep < 30) {
					sleep++;
					if (direction == 0)
						xMove = -speed;
					else if (direction == 1)
						xMove = speed;
					else if (direction == 2)
						yMove = -speed;
					else if (direction == 3)
						yMove = speed;
					else
						direction = random.nextInt(4);
				} else {
					sleep = 0;
				}
			}
		}
	}
	public void render(Graphics g) {
		
		g.drawImage(Assets.mouse, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		System.out.println("Mouse Slain");
		
	}
	
}
