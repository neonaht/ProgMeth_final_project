package logic.person;

import java.awt.Color;
import java.awt.Graphics;

import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.container.PinkBlock;
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
	}

	@Override
	public void update() {
		
		Obj.follow(this, handler.Player);
		
		double _Vx = getxVelo();
		double _Vy = getyVelo();
		
		setxPos(getxPos() + _Vx);
		setyPos(getyPos() + _Vy);
//		
//		if(Math.abs(getxPos() - init_xPos) > disc) setxVelo(-getxVelo());
//		if(Math.abs(getyPos() - init_yPos) > disc) setyVelo(-getyVelo());
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)xPos, (int)yPos, 32, 32);
		return ;
	}
	
}
