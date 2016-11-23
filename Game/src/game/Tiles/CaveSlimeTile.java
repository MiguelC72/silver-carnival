package game.Tiles;

import game.gfx.Assets;

public class CaveSlimeTile extends Tile{

	public CaveSlimeTile(int id) {
		super(Assets.cSlime, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
