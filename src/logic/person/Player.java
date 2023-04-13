package logic.person;

import application.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.base.KeyInput;
import logic.base.Keys;
import logic.container.Bullet;
import logic.container.PinkBlock;
import utilz.Checker;
import utilz.LoadSave;
import utilz.Obj;

public class Player extends Person {
	
	// default
	private double _ac = .8f;
	private double _dc = .4f;
	private KeyInput input;
	private Keys key;
	
	private Handler handler;

	public static double _CurxPos;
	public static double _CuryPos;
	
	private Image[] T_Up, T_Down, T_Left, T_Right;
	Image currentAni, previousAni;
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
		setHp(100);
		setDirect("U");
		setPrv_direct("Z");
		setKey(new Keys());
		previousAni = T_Up[defaultAni];
		
		// Tempt
		
		gun = true;
		
	}
	
	public void initImg() {
		T_Up = new Image[12];
		T_Up[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_Default);
		T_Up[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_0);
		T_Up[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_1);
		T_Up[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_2);
		T_Up[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_3);
		T_Up[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_4);
		T_Up[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_5);
		T_Up[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_6);
		T_Up[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Up_7);
		
		T_Down = new Image[12];
		T_Down[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_Default);
		T_Down[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_0);
		T_Down[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_1);
		T_Down[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_2);
		T_Down[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_3);
		T_Down[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_4);
		T_Down[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_5);
		T_Down[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_6);
		T_Down[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Down_7);
		
		T_Left = new Image[12];
		T_Left[defaultAni] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_Default);
		T_Left[0] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_0);
		T_Left[1] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_1);
		T_Left[2] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_2);
		T_Left[3] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_3);
		T_Left[4] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_4);
		T_Left[5] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_5);
		T_Left[6] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_6);
		T_Left[7] = LoadSave.GetSpriteAtlas(LoadSave.Player_Animation_Left_7);
		
		T_Right = new Image[12];
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
		
//		Collision();
//		if(getHp() == 0) System.out.println("die");
		
		setKey(input.key);
		
		if(key.ONE) {
			setUsed(1);
			if(getUsed() == 1) setSpeed(.8f, .4f);
		}
		if(key.TWO) {
			setUsed(2);
			if(getUsed() == 2) setSpeed(.7f, .35f);
		}
		if(key.THREE) {
			setUsed(3);
			if(getUsed() == 3) setSpeed(.5f, .25f);
		}
		
		_CurxPos = getxPos();
		_CuryPos = getyPos();
		
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
		
		if(getUsed() == 1) setDirect(Checker.KeyWalkDirection(key));
		else setDirect(Checker.KeyDirection(key));
		
		if(BulletTime < 30) BulletTime++;
		if(KnifeTime < 30) KnifeTime++;
		
		if(getUsed() != 1 && (key.LEFT || key.RIGHT || key.UP || key.DOWN)) {
			if(getUsed() == 2 && KnifeTime == 30) slash();
			if(getUsed() == 3 && BulletTime == 30) shoot();
		}
		
		_Vx = cut(_Vx, -get_ac() * 4, get_ac() * 4);
		_Vy = cut(_Vy, -get_ac() * 4, get_ac() * 4);
		
		setxPos(getxPos() + _Vx - (key.SHIFT ? _Vx / 2 : 0));
		setyPos(getyPos() + _Vy - (key.SHIFT ? _Vy / 2 : 0));
		
		setxVelo(_Vx);
		setyVelo(_Vy);
		
		if(BulletTime >= 30) BulletTime = 0;
		if(KnifeTime >= 30) KnifeTime = 0;
		
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 40, 55));
		
		Animation();
		
		return ;
	}
	
	public void Animation() {
		if(direct != prv_direct) SpriteCnt = 0;
		int frame = (SpriteCnt / 5) % 8;
		
		switch(getUsed()) {
			case 1 : WalkAni(frame); break;
			case 2 : KnifeAni(frame); break;
			case 3 : GunAni(frame); break;
			default : WalkAni(frame); break;
		}
		
		SpriteCnt++;
		if(direct != "Z") prv_direct = direct;
		previousAni = currentAni;
		SpriteCnt %= 40;
		return ;
	}
	
	public void Collision() { // ERROR NOT FIXING YET
		for(int i = 0; i < handler.all_objects.size(); i++) {
			if(handler.all_objects.get(i).getCode() == this.getCode()) continue;
			if(this.SolidArea.intersects(handler.all_objects.get(i).getSolidArea().getBoundsInLocal())) {
				Obj.action(this, handler.all_objects.get(i));
				handler.removeObject(handler.all_objects.get(i));
			}
		}
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
	public void render(GraphicsContext gc) { // Set Player Graphics
		gc.drawImage(currentAni, xPos, yPos);
//		gc.setFill(Color.GREENYELLOW);
//		gc.fillOval((int)getxPos(), (int)getyPos(), 32, 32);
		
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
	
	public void setSpeed(double _ac, double _dc) {
		set_ac(_ac);
		set_dc(_dc);
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
