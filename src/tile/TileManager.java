package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.Game;
import utilz.LoadSave;

public class TileManager {
	Game gp;
	
	public TileManager(Game gp) {
		this.gp = gp;
	}
	

	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			String path = "1_floor/1_floor_" + col + '_' + row + ".png"; 
			g2.drawImage(LoadSave.GetSpriteAtlas(path) ,x ,y ,gp.tileSize ,gp.tileSize ,null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0 ;
				row ++;
				y += gp.tileSize;
			}
		}
		
	}
}