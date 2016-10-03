package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.gfx.Assets;

public class Player extends Creature {


	public Player(Handler handler, float x, float y) {
		
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 20;
		bounds.height = 20;
	}

	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera().centerOnEntity(this);
	}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
		
	}
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// draws a bounding box
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset())
		// , (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	
	
}
