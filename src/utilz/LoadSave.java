package utilz;


import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

import javafx.scene.image.Image;

public class LoadSave {

	public static final String MAP_PROT = "Maps/map_prototype.jpg";
	public static final String MAP_DEMO = "Maps/demo_map.png";
	public static final String MAP_FULL_DEMO = "Maps/demo_full_map.png";
	public static final String ROOM_ONE = "Maps/room1.png";
	public static final String Player_Animation_Up_Default = "Animation/T_Up_9.png";
	public static final String Player_Animation_Up_0 = "Animation/T_Up_0.png";
	public static final String Player_Animation_Up_1 = "Animation/T_Up_1.png";
	public static final String Player_Animation_Up_2 = "Animation/T_Up_2.png";
	public static final String Player_Animation_Up_3 = "Animation/T_Up_3.png";
	public static final String Player_Animation_Up_4 = "Animation/T_Up_4.png";
	public static final String Player_Animation_Up_5 = "Animation/T_Up_5.png";
	public static final String Player_Animation_Up_6 = "Animation/T_Up_6.png";
	public static final String Player_Animation_Up_7 = "Animation/T_Up_7.png";
	
	public static final String Player_Animation_Down_Default = "Animation/T_Down_9.png";
	public static final String Player_Animation_Down_0 = "Animation/T_Down_0.png";
	public static final String Player_Animation_Down_1 = "Animation/T_Down_1.png";
	public static final String Player_Animation_Down_2 = "Animation/T_Down_2.png";
	public static final String Player_Animation_Down_3 = "Animation/T_Down_3.png";
	public static final String Player_Animation_Down_4 = "Animation/T_Down_4.png";
	public static final String Player_Animation_Down_5 = "Animation/T_Down_5.png";
	public static final String Player_Animation_Down_6 = "Animation/T_Down_6.png";
	public static final String Player_Animation_Down_7 = "Animation/T_Down_7.png";
	                           
	public static final String Player_Animation_Left_Default = "Animation/T_Left_9.png";
	public static final String Player_Animation_Left_0 = "Animation/T_Left_0.png";
	public static final String Player_Animation_Left_1 = "Animation/T_Left_1.png";
	public static final String Player_Animation_Left_2 = "Animation/T_Left_2.png";
	public static final String Player_Animation_Left_3 = "Animation/T_Left_3.png";
	public static final String Player_Animation_Left_4 = "Animation/T_Left_4.png";
	public static final String Player_Animation_Left_5 = "Animation/T_Left_5.png";
	public static final String Player_Animation_Left_6 = "Animation/T_Left_6.png";
	public static final String Player_Animation_Left_7 = "Animation/T_Left_7.png";
	                           
	public static final String Player_Animation_Right_Default = "Animation/T_Right_9.png";
	public static final String Player_Animation_Right_0 = "Animation/T_Right_0.png";
	public static final String Player_Animation_Right_1 = "Animation/T_Right_1.png";
	public static final String Player_Animation_Right_2 = "Animation/T_Right_2.png";
	public static final String Player_Animation_Right_3 = "Animation/T_Right_3.png";
	public static final String Player_Animation_Right_4 = "Animation/T_Right_4.png";
	public static final String Player_Animation_Right_5 = "Animation/T_Right_5.png";
	public static final String Player_Animation_Right_6 = "Animation/T_Right_6.png";
	public static final String Player_Animation_Right_7 = "Animation/T_Right_7.png";

	public static Image GetSpriteAtlas(String fileName) {
		Image image = new Image("/" + fileName);
		return image;
	}
}