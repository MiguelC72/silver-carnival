package game.Tiles;

import game.gfx.Assets;

public class CaveWallTile extends Tile {

	public CaveWallTile(int id) {
		super(Assets.cWall, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
