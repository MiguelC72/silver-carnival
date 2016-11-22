package game.entities.statics;

import java.awt.Graphics;
import java.util.Random;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;
import game.weapons.Axe;
import game.weapons.BallNChain;
import game.weapons.LongSword;
import game.weapons.Nuke;
import game.weapons.Spear;
import game.weapons.Weapon;

public class Chest extends StaticEntity {
	
	private Random itemGen = new Random();
	private Weapon[] weaponList = new Weapon[5];

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		health = 1;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.chest, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
	}

	@Override
	public void die() {
		int random = itemGen.nextInt(101);
		if (random <= 45)
			handler.getWorld().getEntityManager().addWeapon(new LongSword(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT, x, y));
		else if (random <= 76 && random >= 46)
			handler.getWorld().getEntityManager().addWeapon(new Spear(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT, x, y));
		else if (random <= 89 && random >= 77)
			handler.getWorld().getEntityManager().addWeapon(new BallNChain(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT, x, y));
		else if (random <= 99 && random >= 90)
			handler.getWorld().getEntityManager().addWeapon(new Axe(handler, Tile.TILEWIDTH, Tile.TILEHEIGHT, x, y));
		else {
			System.out.println("The chest was empty!");
		}
	}
	
	@Override
	public void hurt() {
		alive = false;
		die();
	}

}
