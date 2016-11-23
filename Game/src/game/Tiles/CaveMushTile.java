package game.Tiles;

import game.gfx.Assets;

public class CaveMushTile extends Tile{

	public CaveMushTile(int id) {
		super(Assets.cMushroom, id);
		
	}

	
	@Override
	public boolean isSolid() {
		return true;
	}
}
