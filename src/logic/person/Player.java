package logic.person;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import application.Game;
import logic.base.GameObject;
import logic.base.ID;
import logic.base.KeyInput;
import logic.base.Keys;
import utilz.Checker;
import utilz.LoadSave;

public class Player extends Person {
	
	private double _ac = .8f;
	private double _dc = .4f;
	private KeyInput input;
	private Keys key;

	public static double _CurxPos;
	public static double _CuryPos;
	
	private BufferedImage[] T_Up, T_Down, T_Left, T_Right;
	BufferedImage currentAni, previousAni;
	private final int defaultAni = 9;
	private int SpriteCnt;
	private String direct, prv_direct;
	
	public Player(double xPos, double yPos, ID id, KeyInput input) {
		super(xPos, yPos, id);
		this.input = input;
		setxVelo(0);
		setyVelo(0);
		_CurxPos = xPos;
		_CuryPos = yPos;
		initImg();
		SpriteCnt = 0;
		direct = "R";
		prv_direct = "Z";
		previousAni = T_Up[defaultAni];
	}
	
	public void initImg() {
		T_Up = new BufferedImage[12];
		T_Up[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_Default);
		T_Up[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_0);
		T_Up[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_1);
		T_Up[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_2);
		T_Up[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_3);
		T_Up[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_4);
		T_Up[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_5);
		T_Up[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_6);
		T_Up[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_7);
		
		T_Down = new BufferedImage[12];
		T_Down[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_Default);
		T_Down[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_0);
		T_Down[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_1);
		T_Down[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_2);
		T_Down[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_3);
		T_Down[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_4);
		T_Down[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_5);
		T_Down[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_6);
		T_Down[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_7);
		
		T_Left = new BufferedImage[12];
		T_Left[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_Default);
		T_Left[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_0);
		T_Left[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_1);
		T_Left[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_2);
		T_Left[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_3);
		T_Left[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_4);
		T_Left[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_5);
		T_Left[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_6);
		T_Left[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_7);
		
		T_Right = new BufferedImage[12];
		T_Right[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_Default);
		T_Right[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_0);
		T_Right[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_1);
		T_Right[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_2);
		T_Right[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_3);
		T_Right[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_4);
		T_Right[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_5);
		T_Right[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_6);
		T_Right[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Right_7);
		
		
		return ;
	}

	@Override
	public void update() {
		_CurxPos = getxPos();
		_CuryPos = getyPos();
		
		this.key = input.key;
		
		double _Vx = getxVelo();
		double _Vy = getyVelo();
		
		if(key.A) _Vx -= _ac;
		else if(key.D) _Vx += _ac;
		else {
			if(_Vx > 0) _Vx -= _dc;
			else if(_Vx < 0) _Vx += _dc;
		}
		
		if(key.W) _Vy -= _ac;
		else if(key.S) _Vy += _ac;
		else {
			if(_Vy > 0) _Vy -= _dc;
			else if(_Vy < 0) _Vy += _dc;
		}
		
		direct = Checker.KeyDirection(key);
		
		_Vx = cut(_Vx, -3.2f, 3.2f);
		_Vy = cut(_Vy, -3.2f, 3.2f);
		
		setxPos(getxPos() + _Vx - (key.SHIFT ? _Vx / 2 : 0));
		setyPos(getyPos() + _Vy - (key.SHIFT ? _Vy / 2 : 0));
		
		setxVelo(_Vx);
		setyVelo(_Vy);
		
		return ;
	}
	
	private double cut(double val, double low, double high) {
		if(val > high) return high;
		if(val < low) return low;
		return val;
	}
	
	private boolean inFramex(double xPos) {
		return xPos <= Game.WIDTH - 44 && xPos >= 0 ? true : false;
	}
	
	private boolean inFramey(double yPos) {
		return yPos <= Game.HEIGHT - 64 && yPos >= 0 ? true : false;
	}

	@Override
	public void render(Graphics g) { // Set Player Graphics
		BufferedImage currentAni;
		if(direct != prv_direct) SpriteCnt = 0;
		int frame = (SpriteCnt / 15) % 8;
		switch(direct) {
			case "L" : currentAni = T_Left[frame]; break;
			case "R" : currentAni = T_Right[frame]; break;
			case "U" : currentAni = T_Up[frame]; break;
			case "D" : currentAni = T_Down[frame]; break;
			default : {
				switch(prv_direct) {
					case "L" : currentAni = T_Left[defaultAni]; break;
					case "R" : currentAni = T_Right[defaultAni]; break;
					case "U" : currentAni = T_Up[defaultAni]; break;
					case "D" : currentAni = T_Down[defaultAni]; break;
					default : currentAni = previousAni; break;
				}
				break;
			}
		}
		SpriteCnt++;
		prv_direct = direct;
		previousAni = currentAni;
		SpriteCnt %= 120;
		g.drawImage(currentAni, (int)xPos, (int)yPos, null);
		
		return ;
	}
	
	// Getters & Setters

	public double get_ac() {
		return _ac;
	}

	public void set_ac(double _ac) {
		this._ac = _ac;
		return ;
	}

	public double get_dc() {
		return _dc;
	}

	public void set_dc(double _dc) {
		this._dc = _dc;
		return ;
	}

	public KeyInput getInput() {
		return input;
	}

	public void setInput(KeyInput input) {
		this.input = input;
		return ;
	}
	
}
