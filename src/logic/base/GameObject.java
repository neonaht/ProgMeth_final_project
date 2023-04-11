package logic.base;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected double xPos, yPos;
	protected double xVelo, yVelo;
	protected Rectangle SolidArea;
	protected int SolidX, SolidY;
	protected ID id;
	protected int Code;
	
	public GameObject(double xPos, double yPos, ID id) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.id = id;
		this.Code = Handler.Code++;
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
	
	public Rectangle getSolidArea() {
		return SolidArea;
	}

	public void setSolidArea(Rectangle solidArea) {
		SolidArea = solidArea;
		return ;
	}

	public int getSolidX() {
		return SolidX;
	}

	public void setSolidX(int solidX) {
		SolidX = solidX;
		return ;
	}

	public int getSolidY() {
		return SolidY;
	}

	public void setSolidY(int solidY) {
		SolidY = solidY;
		return ;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
		return ;
	}
	
	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
		return ;
	}
	
}
