package logic.base;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected double xPos, yPos;
	protected double xVelo, yVelo;
	protected ID id;
	
	public GameObject(double xPos, double yPos, ID id) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.id = id;
	}
	
	public void move() {
		setxPos(getxPos() + getxVelo());
		setyPos(getyPos() + getyVelo());
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	// Getters & Setters

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
		return ;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
		return ;
	}

	public double getxVelo() {
		return xVelo;
	}

	public void setxVelo(double xVelo) {
		this.xVelo = xVelo;
		return ;
	}

	public double getyVelo() {
		return yVelo;
	}

	public void setyVelo(double yVelo) {
		this.yVelo = yVelo;
		return ;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
		return ;
	}
	
	
	
}
