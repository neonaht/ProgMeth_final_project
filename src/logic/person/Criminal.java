package logic.person;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.container.Bullet;
import logic.container.PinkBlock;
import utilz.Checker;
import utilz.Obj;

public class Criminal extends Person {
	
	private Handler handler;
	private double init_xPos, init_yPos, disc;

	public Criminal(int xPos, int yPos, ID id, Handler handler, double xVelo, double yVelo, double disc) {
		super(xPos, yPos, id);
		this.handler = handler;
		setxVelo(xVelo);
		setyVelo(yVelo);
		init_xPos = xPos;
		init_yPos = yPos;
		this.disc = disc;
		
		// Tempt
		
		BulletTime = 0;
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 40, 55));
		setDirect(Checker.GetDirectionByVelo(getxVelo(), getyVelo()));
		setUsed(2);
		gun = true;
		
	}

	@Override
	public void update() {
		Obj.follow(this, handler.Player);
		setDirect(Obj.getDirection(this, handler.Player));
		
		if(BulletTime < 30) BulletTime++;
		if(KnifeTime < 30) KnifeTime++;
		
		if(getUsed() == 1 && KnifeTime == 30) slash();
		if(getUsed() == 2 && BulletTime == 30) shoot();
		
		if(BulletTime > 30) BulletTime = 0;
		if(KnifeTime > 30) KnifeTime = 0;
		
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 40, 55));
		
		return ;
	}

	@Override
	public void render(Graphics g) {
		if(getDirect() != "Z") setPrv_direct(getDirect());
		g.setColor(Color.red);
		g.fillOval((int)getxPos(), (int)getyPos(), 32, 32);
		return ;
	}

	@Override
	public void shoot() {
		if(!GunAvailable() || handler.Player == null) return ;
		
		switch(getDirect()) {
			case "L" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, -20, 0)); break;
			case "R" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 20, 0)); break;
			case "U" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, -20)); break;
			case "D" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, 20)); break;
			default : {
				switch(getPrv_direct()) {
					case "L" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, -20, 0)); break;
					case "R" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 20, 0)); break;
					case "U" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, -20)); break;
					case "D" : handler.addObject(new Bullet(getxPos(), getyPos(), ID.Bullet, 0, 20)); break;
					default : break;
				}
				break;
			}
		}
		
		BulletTime = 0;
		
		return ;
	}

	@Override
	public void slash() {
		// TODO Auto-generated method stub
		
	}
	
}
