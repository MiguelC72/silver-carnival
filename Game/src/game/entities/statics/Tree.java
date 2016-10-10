package game.entities.statics;

import java.awt.Graphics;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
	}


	@Override
	public void update() {
		
		
	}
}
