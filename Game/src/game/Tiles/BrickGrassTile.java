package game.Tiles;

import game.gfx.Assets;

public class BrickGrassTile extends Tile{

	public BrickGrassTile(int id) {
		super(Assets.stonegrass, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
