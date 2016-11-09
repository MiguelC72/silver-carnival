package game.Tiles;

import game.gfx.Assets;

public class BrickTile extends Tile {

	public BrickTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
