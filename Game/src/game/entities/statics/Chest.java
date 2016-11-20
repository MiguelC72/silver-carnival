package game.entities.statics;

import java.awt.Graphics;
import java.util.Random;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;
import game.weapons.LongSword;
import game.weapons.Weapon;

public class Chest extends StaticEntity {
	
	private Random itemGen = new Random();
	private Weapon[] weaponList = new Weapon[5];

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		health = 1;
		// fill with weapons
		// weaponList = { };
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.chest, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), null);
		
	}

	@Override
	public void die() {
		itemGen.nextInt(5);
		new LongSword(handler, 20, 20, x, y);
		
	}
	
	@Override
	public void hurt() {
		alive = false;
		die();
	}

}
