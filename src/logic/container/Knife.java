package logic.container;

import java.awt.Color;
import java.awt.Graphics;

import logic.base.GameObject;
import logic.base.ID;

public class Knife extends GameObject {
	
	private boolean visible = true;
	
	public Knife(double xPos, double yPos, ID id) {
		super(xPos, yPos, id);
		this.visible = true;
	}
	
	public Knife(double xPos, double yPos, ID id, boolean visible) {
		super(xPos, yPos, id);
		this.visible = visible;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(!isVisible()) return ;
		
		g.setColor(Color.gray);
		g.fillOval((int)xPos, (int)yPos, 48, 48);
		
		return ;
	}
	
	// Getters & Setters
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		return ;
	}
	
}
