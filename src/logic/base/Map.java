package logic.base;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import application.Game;
import logic.base.GameObject;
import logic.base.ID;
import utilz.LoadSave;

public class Map extends GameObject {

	private BufferedImage bg = LoadSave.GetSpriteAtlas("Maps/demo_full_map.png");
	
	public Map(double xPos, double yPos, ID id) {
		super(xPos, yPos, id);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
	
}
