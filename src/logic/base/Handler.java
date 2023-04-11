package logic.base;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import logic.person.Person;
import logic.person.Player;

public class Handler {
	
	public LinkedList<GameObject> all_objects = new LinkedList<GameObject>();
	public Player Player;
	
	public Handler() {
		all_objects = new LinkedList<GameObject>();
	}
	
	public void update() {
		for(int i = 0; i < all_objects.size(); i++) {
			all_objects.get(i).update();
		}
		Player.update();
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < all_objects.size(); i++) {
			all_objects.get(i).render(g);
		}
		Player.render(g);
		return ;
	}
	
	public void addObject(GameObject object) {
		all_objects.add(object);
		return ;
	}
	
	public void removeObject(GameObject object) {
		all_objects.remove(object);
		return ;
	}

}
