package logic.base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public Keys key = new Keys();
	
	public void keyPressed(KeyEvent x) {
		int keyInt = x.getKeyCode();
		
		if(keyInt == KeyEvent.VK_W) key.W = true;
		if(keyInt == KeyEvent.VK_A) key.A = true;
		if(keyInt == KeyEvent.VK_S) key.S = true;
		if(keyInt == KeyEvent.VK_D) key.D = true;
		if(keyInt == KeyEvent.VK_LEFT) key.LEFT = true;
		if(keyInt == KeyEvent.VK_RIGHT) key.RIGHT = true;
		if(keyInt == KeyEvent.VK_UP) key.UP = true;
		if(keyInt == KeyEvent.VK_DOWN) key.DOWN = true;
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = true;
		if(keyInt == KeyEvent.VK_SPACE) key.SPACE = true;
		
	}
	
	public void keyReleased(KeyEvent x) {
		int keyInt = x.getKeyCode();
		
		if(keyInt == KeyEvent.VK_W) key.W = false;
		if(keyInt == KeyEvent.VK_A) key.A = false;
		if(keyInt == KeyEvent.VK_S) key.S = false;
		if(keyInt == KeyEvent.VK_D) key.D = false;
		if(keyInt == KeyEvent.VK_LEFT) key.LEFT = false;
		if(keyInt == KeyEvent.VK_RIGHT) key.RIGHT = false;
		if(keyInt == KeyEvent.VK_UP) key.UP = false;
		if(keyInt == KeyEvent.VK_DOWN) key.DOWN = false;
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = false;
		if(keyInt == KeyEvent.VK_SPACE) key.SPACE = false;
		
	}
	
}
