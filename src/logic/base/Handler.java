package logic.base;

import java.awt.Graphics;
import java.util.LinkedList;

import logic.person.Person;
import logic.person.Player;

public class Handler {
	
	public LinkedList<GameObject> all_objects = new LinkedList<GameObject>();
	public GameObject Player;
	
	public Handler(LinkedList<GameObject> all_objects, GameObject Player) {
		this.all_objects = all_objects;
		this.Player = Player;
	}
	
	public void update() {
		for(GameObject object : all_objects) {
			object.update();
		}
		Player.update();
	}
	
	public void render(Graphics g) {
		for(GameObject object : all_objects) {
			object.render(g);
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
