package application;

import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.person.Player;

public class Camera {
	
	private double x, y;
	private Handler handler;
	private double Player_xPos = Player._CurxPos;
	private double Player_yPos = Player._CuryPos;
	
	public Camera(double x, double y, Handler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
		getPlayer();
	}
	
	public void getPlayer() {
		Player_xPos = Player._CurxPos;
		Player_yPos = Player._CuryPos;
		return ;
	}
	
	public void update() {
		getPlayer();
		x = Player_xPos - Game.WIDTH / 2 + 30;
		y = Player_yPos - Game.HEIGHT / 2 + 40;
		return ;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		return ;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		return ;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
		return ;
	}
	
	// Getters & Setters
	
	
	
}
