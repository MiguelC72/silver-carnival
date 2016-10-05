package game.entities.creatures;

import java.awt.Graphics;
import java.util.Random;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;

public class Slime extends Creature{
	
	private Random random;

	public Slime(Handler handler, float x, float y) {
		
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 20;
		bounds.height = 20;
		random = new Random();
		this.speed = 20.0f;
	}

	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera();
	}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		int i = random.nextInt(700) + 1;
		
		if (i <= 100) {
			if (i >= 0 && i <= 24)
				yMove = -speed;
			if (i >= 25 && i <= 49)
				yMove = speed;
			if (i >= 50 && i <= 74)
				xMove = -speed;
			if (i >= 75 && i <= 100)
				xMove = speed;
		}
		
	}
	public void render(Graphics g) {
		
		g.drawImage(Assets.slime, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// draws a bounding box
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset())
		// , (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
