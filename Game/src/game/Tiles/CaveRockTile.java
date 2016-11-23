package game.Tiles;

import game.gfx.Assets;

public class CaveRockTile extends Tile{

	public CaveRockTile(int id) {
		super(Assets.cRock, id);
		
	}

	
	@Override
	public boolean isSolid() {
		return true;
	}
}
