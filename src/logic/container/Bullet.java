package logic.container;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;

public class Bullet extends GameObject {
	
	private int maxDamage, minDamage;
	
	public Bullet(double xPos, double yPos, ID id) {
		super(xPos + 20, yPos + 20, id);
		setxVelo(0);
		setyVelo(0);
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 8, 8));
		setSolidX(8);
		setSolidY(8);
		setMinDamage(35);
		setMaxDamage(75);
	}
	
	public Bullet(double xPos, double yPos, ID id, double xVelo, double yVelo) {
		super(xPos, yPos, id);
		setxVelo(xVelo);
		setyVelo(yVelo);
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 8, 8));
		setSolidX(8);
		setSolidY(8);
	}

	public Bullet(double xPos, double yPos, ID id, double xVelo, double yVelo, int MxD, int MnD) {
		super(xPos, yPos, id);
		setxVelo(xVelo);
		setyVelo(yVelo);
		setSolidArea(new Rectangle((int)getxPos(), (int)getyPos(), 8, 8));
		setSolidX(8);
		setSolidY(8);
		setMinDamage(MxD);
		setMaxDamage(MnD);
	}

	@Override
	public void update() {
		move();
//		System.out.println(getxPos() + ' ' + getyPos());
		return ;
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillOval((int)getxPos(), (int)getyPos(), 8, 8);
		return ;
	}
	
	public int damage() {
		return (int)(Math.random()*(getMaxDamage()-getMinDamage()+1)+getMinDamage()); 
	}
	
	// Getters & Setters
	
	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
		return ;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
		return ;
	}
	
}
