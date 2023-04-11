package logic.person;

import java.awt.Graphics;

import logic.base.GameObject;
import logic.base.ID;

public abstract class Person extends GameObject {

	public Person(double xPos, double yPos, ID id) {
		super(xPos, yPos, id);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

}
