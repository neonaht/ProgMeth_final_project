package logic.base;

import application.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.base.GameObject;
import logic.base.ID;
import utilz.LoadSave;

public class Map extends GameObject {

	private Image bg = LoadSave.GetSpriteAtlas(LoadSave.MAP_FULL_DEMO);
	
	public Map(double xPos, double yPos, ID id) {
		super(xPos, yPos, id);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(bg, 0, 0);
//		gc.setFill(Color.MEDIUMPURPLE);
//		gc.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}
	
}
