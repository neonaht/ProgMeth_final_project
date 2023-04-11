package logic.person;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import application.Game;
import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.base.KeyInput;
import logic.base.Keys;
import logic.container.Bullet;
import logic.container.PinkBlock;
import utilz.Checker;
import utilz.LoadSave;

public class Player extends Person {
	
	private double _ac = .8f;
	private double _dc = .4f;
	private KeyInput input;
	private Keys key;
	
	private Handler handler;

	public static double _CurxPos;
	public static double _CuryPos;
	
	private BufferedImage[] T_Up, T_Down, T_Left, T_Right;
	BufferedImage currentAni, previousAni;
	private final int defaultAni = 9;
	
	public Player(double xPos, double yPos, ID id, Handler handler, KeyInput input) {
		super(xPos, yPos, id);
		this.input = input;
		this.handler = handler;
		_CurxPos = xPos;
		_CuryPos = yPos;

		initImg();
		
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 40, 55));
		setSolidX(40);
		setSolidY(55);
		setDirect("U");
		setPrv_direct("Z");
		setKey(new Keys());
		previousAni = T_Up[defaultAni];
		
		// Tempt
		
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
		
		setKey(input.key);
		
		double _Vx = getxVelo();
		double _Vy = getyVelo();
		
		Rectangle C = null;
		for(int i = 0; i < handler.all_objects.size(); i++) {
			if(handler.all_objects.get(i).getId() == ID.Criminal) {
				C = ((Person)handler.all_objects.get(i)).getSolidArea();
				break;
			}
		}
		if(getSolidArea().intersects(C)) System.out.println("YES !");
		
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
		
		if(getUsed() == 0) setDirect(Checker.KeyWalkDirection(key));
		else setDirect(Checker.KeyDirection(key));
		
		if(BulletTime < 30) BulletTime++;
		if(KnifeTime < 30) KnifeTime++;
		
		if(getUsed() != 0 && (key.LEFT || key.RIGHT || key.UP || key.DOWN)) {
			if(getUsed() == 1 && KnifeTime == 30) slash();
			if(getUsed() == 2 && BulletTime == 30) shoot();
		}
		
		_Vx = cut(_Vx, -3.2f, 3.2f);
		_Vy = cut(_Vy, -3.2f, 3.2f);
		
		setxPos(getxPos() + _Vx - (key.SHIFT ? _Vx / 2 : 0));
		setyPos(getyPos() + _Vy - (key.SHIFT ? _Vy / 2 : 0));
		
		setxVelo(_Vx);
		setyVelo(_Vy);
		
		if(BulletTime > 30) BulletTime = 0;
		if(KnifeTime > 30) KnifeTime = 0;
		
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 40, 55));
		
		return ;
	}
	
	public void shoot() {
		if(!GunAvailable() || handler.Player == null) return ;
		
		switch(getDirect()) {
			case "LEFT" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, -20, 0)); break;
			case "RIGHT" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 20, 0)); break;
			case "UP" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, -20)); break;
			case "DOWN" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, 20)); break;
			default : {
				switch(getPrv_direct()) {
					case "LEFT" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, -20, 0)); break;
					case "RIGHT" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 20, 0)); break;
					case "UP" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, -20)); break;
					case "DOWN" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, 20)); break;
					default : break;
				}
				break;
			}
		}
		
		return ;
	}
	
	public void slash() {
		if(!KnifeAvailable() || handler.Player == null) return ;
		
		KnifeTime = 0;
		
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
		if(direct != prv_direct) SpriteCnt = 0;
		int frame = (SpriteCnt / 15) % 8;
		
		switch(getUsed()) {
			case 0 : WalkAni(frame); break;
			case 1 : KnifeAni(frame); break;
			case 2 : GunAni(frame); break;
			default : WalkAni(frame); break;
		}
		
		SpriteCnt++;
		if(direct != "Z") prv_direct = direct;
		previousAni = currentAni;
		SpriteCnt %= 120;
		g.drawImage(currentAni, (int)xPos, (int)yPos, null);
		
		return ;
	}
	
	private void WalkAni(int frame) {
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
	}
	
	private void KnifeAni(int frame) { // TODO
		// TODO Auto-generated method stub
		
	}

	private void GunAni(int frame) { // TODO
		if(Checker.UnpressedWalkDirection(key) && Checker.UnpressedHitDirection(key)) {
			switch(direct) {
				case "LEFT" : currentAni = T_Left[frame]; break;
				case "RIGHT" : currentAni = T_Right[frame]; break;
				case "UP" : currentAni = T_Up[frame]; break;
				case "DOWN" : currentAni = T_Down[frame]; break;
				case "L" : currentAni = T_Left[frame]; break;
				case "R" : currentAni = T_Right[frame]; break;
				case "U" : currentAni = T_Up[frame]; break;
				case "D" : currentAni = T_Down[frame]; break;
				default : {
					switch(prv_direct) {
						case "LEFT" : currentAni = T_Left[defaultAni]; break;
						case "RIGHT" : currentAni = T_Right[defaultAni]; break;
						case "UP" : currentAni = T_Up[defaultAni]; break;
						case "DOWN" : currentAni = T_Down[defaultAni]; break;
						case "L" : currentAni = T_Left[defaultAni]; break;
						case "R" : currentAni = T_Right[defaultAni]; break;
						case "U" : currentAni = T_Up[defaultAni]; break;
						case "D" : currentAni = T_Down[defaultAni]; break;
						default : currentAni = previousAni; break;
					}
					break;
				}
			}
		}
		else if(Checker.UnpressedWalkDirection(key)) {
			switch(direct) {
				case "LEFT" : currentAni = T_Left[defaultAni]; break;
				case "RIGHT" : currentAni = T_Right[defaultAni]; break;
				case "UP" : currentAni = T_Up[defaultAni]; break;
				case "DOWN" : currentAni = T_Down[defaultAni]; break;
				default : {
					switch(prv_direct) {
						case "LEFT" : currentAni = T_Left[defaultAni]; break;
						case "RIGHT" : currentAni = T_Right[defaultAni]; break;
						case "UP" : currentAni = T_Up[defaultAni]; break;
						case "DOWN" : currentAni = T_Down[defaultAni]; break;
						default : currentAni = previousAni; break;
					}
					break;
				}
			}
		}
		else if(Checker.UnpressedHitDirection(key)) {
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
		}
		else switch(direct) {
			case "LEFT" : currentAni = T_Left[frame]; break;
			case "RIGHT" : currentAni = T_Right[frame]; break;
			case "UP" : currentAni = T_Up[frame]; break;
			case "DOWN" : currentAni = T_Down[frame]; break;
			case "L" : currentAni = T_Left[frame]; break;
			case "R" : currentAni = T_Right[frame]; break;
			case "U" : currentAni = T_Up[frame]; break;
			case "D" : currentAni = T_Down[frame]; break;
			default : {
				switch(prv_direct) {
					case "LEFT" : currentAni = T_Left[defaultAni]; break;
					case "RIGHT" : currentAni = T_Right[defaultAni]; break;
					case "UP" : currentAni = T_Up[defaultAni]; break;
					case "DOWN" : currentAni = T_Down[defaultAni]; break;
					case "L" : currentAni = T_Left[defaultAni]; break;
					case "R" : currentAni = T_Right[defaultAni]; break;
					case "U" : currentAni = T_Up[defaultAni]; break;
					case "D" : currentAni = T_Down[defaultAni]; break;
					default : currentAni = previousAni; break;
				}
				break;
			}
		}
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

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
		return ;
	}

	public Keys getKey() {
		return key;
	}

	public void setKey(Keys key) {
		this.key = key;
		return ;
	}
	
	
}
