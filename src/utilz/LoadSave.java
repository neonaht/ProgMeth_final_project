package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

	public static final String MAP_PROT = "map_prototype.jpg";
	public static final String MAP_DEMO = "demo_map.png";
	public static final String MAP_FULL_DEMO = "demo_full_map.png";
	public static final String ROOM_ONE = "room1.png";
	public static final String Player_Animation_Up_Default = "T_Up_9.png";
	public static final String Player_Animation_Up_0 = "T_Up_0.png";
	public static final String Player_Animation_Up_1 = "T_Up_1.png";
	public static final String Player_Animation_Up_2 = "T_Up_2.png";
	public static final String Player_Animation_Up_3 = "T_Up_3.png";
	public static final String Player_Animation_Up_4 = "T_Up_4.png";
	public static final String Player_Animation_Up_5 = "T_Up_5.png";
	public static final String Player_Animation_Up_6 = "T_Up_6.png";
	public static final String Player_Animation_Up_7 = "T_Up_7.png";
	
	public static final String Player_Animation_Down_Default = "T_Down_9.png";
	public static final String Player_Animation_Down_0 = "T_Down_0.png";
	public static final String Player_Animation_Down_1 = "T_Down_1.png";
	public static final String Player_Animation_Down_2 = "T_Down_2.png";
	public static final String Player_Animation_Down_3 = "T_Down_3.png";
	public static final String Player_Animation_Down_4 = "T_Down_4.png";
	public static final String Player_Animation_Down_5 = "T_Down_5.png";
	public static final String Player_Animation_Down_6 = "T_Down_6.png";
	public static final String Player_Animation_Down_7 = "T_Down_7.png";
	                           
	public static final String Player_Animation_Left_Default = "T_Left_9.png";
	public static final String Player_Animation_Left_0 = "T_Left_0.png";
	public static final String Player_Animation_Left_1 = "T_Left_1.png";
	public static final String Player_Animation_Left_2 = "T_Left_2.png";
	public static final String Player_Animation_Left_3 = "T_Left_3.png";
	public static final String Player_Animation_Left_4 = "T_Left_4.png";
	public static final String Player_Animation_Left_5 = "T_Left_5.png";
	public static final String Player_Animation_Left_6 = "T_Left_6.png";
	public static final String Player_Animation_Left_7 = "T_Left_7.png";
	                           
	public static final String Player_Animation_Right_Default = "T_Right_9.png";
	public static final String Player_Animation_Right_0 = "T_Right_0.png";
	public static final String Player_Animation_Right_1 = "T_Right_1.png";
	public static final String Player_Animation_Right_2 = "T_Right_2.png";
	public static final String Player_Animation_Right_3 = "T_Right_3.png";
	public static final String Player_Animation_Right_4 = "T_Right_4.png";
	public static final String Player_Animation_Right_5 = "T_Right_5.png";
	public static final String Player_Animation_Right_6 = "T_Right_6.png";
	public static final String Player_Animation_Right_7 = "T_Right_7.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
}