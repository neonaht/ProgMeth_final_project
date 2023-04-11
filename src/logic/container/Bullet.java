package logic.container;

import java.awt.Color;
import java.awt.Graphics;

import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;

public class Bullet extends GameObject {
	
	public Bullet(double xPos, double yPos, ID id) {
		super(xPos, yPos, id);
		setxVelo(0);
		setyVelo(0);
	}

	public Bullet(double xPos, double yPos, ID id, double xVelo, double yVelo) {
		super(xPos, yPos, id);
		setxVelo(xVelo);
		setyVelo(yVelo);
	}

	@Override
	public void update() {
		move();
		return ;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int)getxPos() + 20, (int)getyPos() + 40, 8, 8);
		return ;
	}
	
}
