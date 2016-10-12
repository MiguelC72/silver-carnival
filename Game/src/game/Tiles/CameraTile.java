package game.Tiles;

import game.gfx.Assets;

public class CameraTile extends Tile {
	
	public CameraTile(int id) {
		super(Assets.camera, id);
	}
	
	@Override
	public boolean isCamera() {
		return true;
	}
}
